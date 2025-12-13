package com.pss.criacaomanutencaousuarios.model;

import com.pss.criacaomanutencaousuarios.database.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Repositório para a tabela de ligação entre Usuários e Notificações.
 * @author André Tavares Louzada, Lucas Herbest Lopes e Yuri Sousa Almeida
 */
public class NotificacaoUsuarioRepository {
    
    public NotificacaoUsuarioRepository(ArrayList<NotificacaoUsuario> notificacoes) {
        // Construtor mantido para compatibilidade
    }
    
    /**
     * Inclui o vínculo. 
     * Lógica: 
     * 1. Verifica se a notificação já existe na tabela 'notificacoes', se não, cria e pega o ID.
     * 2. Pega o ID do usuário pelo Nome (já que o objeto Usuario não tem ID na memória).
     * 3. Insere na tabela 'notificacoes_usuarios'.
     */
    public void incluirNotificacaoUsuario(NotificacaoUsuario notificacaoUsuario) {
        Connection conn = null;
        PreparedStatement pstmtNotif = null;
        PreparedStatement pstmtLink = null;
        ResultSet rs = null;

        try {
            conn = DatabaseConnection.connect();
            // Desliga auto-commit para garantir integridade (transação)
            conn.setAutoCommit(false); 

            // --- PASSO 1: Obter ID da Notificação (Criar se não existir) ---
            int idNotificacao = 0;
            String msg = notificacaoUsuario.getNotificacao().getMessage();
            
            // Tenta buscar ID se já existe
            PreparedStatement pstmtBusca = conn.prepareStatement("SELECT id FROM notificacoes WHERE mensagem = ?");
            pstmtBusca.setString(1, msg);
            rs = pstmtBusca.executeQuery();
            
            if (rs.next()) {
                idNotificacao = rs.getInt("id");
            } else {
                // Se não existe, insere e pega o ID gerado
                String sqlInsertNotif = "INSERT INTO notificacoes (mensagem) VALUES (?)";
                pstmtNotif = conn.prepareStatement(sqlInsertNotif, Statement.RETURN_GENERATED_KEYS);
                pstmtNotif.setString(1, msg);
                pstmtNotif.executeUpdate();
                
                ResultSet generatedKeys = pstmtNotif.getGeneratedKeys();
                if (generatedKeys.next()) {
                    idNotificacao = generatedKeys.getInt(1);
                }
            }
            // Fechar recursos auxiliares do passo 1
            if(rs != null) rs.close();
            if(pstmtBusca != null) pstmtBusca.close();

            
            // --- PASSO 2: Inserir o Vínculo na tabela notificacoes_usuarios ---
            // Usamos uma subquery para pegar o ID do usuário pelo nome
            String sqlLink = """
                INSERT INTO notificacoes_usuarios (id_usuario, id_notificacao, lida) 
                VALUES ((SELECT id FROM usuarios WHERE nome = ?), ?, ?)
            """;
            
            pstmtLink = conn.prepareStatement(sqlLink);
            pstmtLink.setString(1, notificacaoUsuario.getUsuario().getNome());
            pstmtLink.setInt(2, idNotificacao);
            pstmtLink.setInt(3, 0); // 0 = Não lida

            pstmtLink.executeUpdate();

            conn.commit(); // Confirma transação
            System.out.println("Notificação vinculada ao usuário: " + notificacaoUsuario.getUsuario().getNome());

        } catch (SQLException e) {
            System.err.println("Erro ao incluir notificação usuário: " + e.getMessage());
            if (conn != null) {
                try { conn.rollback(); } catch (SQLException ex) { ex.printStackTrace(); }
            }
        } finally {
            // Fechar tudo manualmente
            try { if (pstmtLink != null) pstmtLink.close(); } catch (SQLException e) {}
            try { if (pstmtNotif != null) pstmtNotif.close(); } catch (SQLException e) {}
            try { if (conn != null) conn.close(); } catch (SQLException e) {}
        }
    }
    
    public void removerNotificacaoUsuario(NotificacaoUsuario notificacao) {
        // Remove apenas o vínculo
        String sql = """
            DELETE FROM notificacoes_usuarios 
            WHERE id_usuario = (SELECT id FROM usuarios WHERE nome = ?) 
            AND id_notificacao = (SELECT id FROM notificacoes WHERE mensagem = ?)
        """;
        
        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, notificacao.getUsuario().getNome());
            pstmt.setString(2, notificacao.getNotificacao().getMessage());
            pstmt.executeUpdate();
            
        } catch (SQLException e) {
            System.err.println("Erro ao remover vínculo: " + e.getMessage());
        }
    }
    
    public List<NotificacaoUsuario> getAll() {
        List<NotificacaoUsuario> lista = new ArrayList<>();
        
        // Faz JOIN para trazer os dados completos do Usuário e da Mensagem
        String sql = """
            SELECT nu.lida, n.mensagem, 
                   u.nome, u.senha, u.tipo, u.data_registro, u.ativo
            FROM notificacoes_usuarios nu
            JOIN notificacoes n ON nu.id_notificacao = n.id
            JOIN usuarios u ON nu.id_usuario = u.id
        """;

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                // 1. Reconstruir Objeto Notificacao
                Notificacao n = new Notificacao(rs.getString("mensagem"));
                
                // 2. Reconstruir Objeto Usuario (Lógica similar ao UsuarioRepository)
                Usuario u = mapearUsuario(rs);
                
                // 3. Criar objeto de vínculo (assumindo que existe esse construtor)
                NotificacaoUsuario nu = new NotificacaoUsuario(n, u);
                // Se tiver campo 'lida', poderia setar aqui: nu.setLida(rs.getInt("lida") == 1);
                
                lista.add(nu);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar notificações usuários: " + e.getMessage());
            e.printStackTrace();
        }
        return lista;
    }
    
    /**
     * Helper para mapear usuário (Cópia da lógica do UsuarioRepository para evitar duplicação se possível,
     * mas aqui replicada para independência da classe).
     */
    private Usuario mapearUsuario(ResultSet rs) throws SQLException {
        String nome = rs.getString("nome");
        String senha = rs.getString("senha");
        int tipoCodigo = rs.getInt("tipo");
        String dataStr = rs.getString("data_registro");
        boolean ativo = rs.getInt("ativo") == 1;

        TipoDeUsuarioEnum tipoEnum = TipoDeUsuarioEnum.usuarioComum;
        for (TipoDeUsuarioEnum t : TipoDeUsuarioEnum.values()) {
            if (t.getCodigo() == tipoCodigo) {
                tipoEnum = t;
                break;
            }
        }

        LocalDate dataRegistro = null;
        if (dataStr != null && !dataStr.isEmpty()) {
            dataRegistro = LocalDate.parse(dataStr);
        }

        Usuario u = new Usuario(nome, senha, tipoEnum, dataRegistro);
        u.setAtivo(ativo);
        return u;
    }
}