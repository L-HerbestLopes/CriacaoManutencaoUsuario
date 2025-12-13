package com.pss.criacaomanutencaousuarios.model;

import com.pss.criacaomanutencaousuarios.database.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Repositório responsável pela persistência de usuários no SQLite.
 * @author André Tavares Louzada, Lucas Herbest Lopes e Yuri Sousa Almeida
 */
public class UsuarioRepository {

    public UsuarioRepository() {
        // Não é necessário manter lista em memória, pois agora usamos o banco.
    }
    
    // INSERT
    public void incluirUsuario(Usuario usuario) {
        String sql = "INSERT INTO usuarios(nome, senha, tipo, data_registro, ativo) VALUES(?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, usuario.getNome());
            pstmt.setString(2, usuario.getSenha());
            pstmt.setInt(3, usuario.getTipo().getCodigo()); 
            pstmt.setString(4, usuario.getDataRegistro().toString());
            pstmt.setInt(5, usuario.getAtivo() ? 1 : 0);

            pstmt.executeUpdate();
            System.out.println("Usuário inserido no banco: " + usuario.getNome());

        } catch (SQLException e) {
            System.err.println("Erro ao incluir usuário: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    public void removerUsuario(Usuario usuario) {
        String sql = "DELETE FROM usuarios WHERE nome = ?";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, usuario.getNome());
            pstmt.executeUpdate();
            
        } catch (SQLException e) {
            System.err.println("Erro ao remover usuário: " + e.getMessage());
        }
    }
    
    public Usuario buscarUsuario(String nome) {
        String sql = "SELECT * FROM usuarios WHERE nome = ?";
        Usuario usuarioEncontrado = null;

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, nome);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                usuarioEncontrado = mapearResultSetParaUsuario(rs);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar usuário: " + e.getMessage());
        }
        return usuarioEncontrado;
    }
    
    public List<Usuario> getAll() {
        List<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM usuarios";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                usuarios.add(mapearResultSetParaUsuario(rs));
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar usuários: " + e.getMessage());
        }
        return usuarios;
    }
    
    public boolean listaVazia() {
        String sql = "SELECT COUNT(*) AS total FROM usuarios";
        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            if (rs.next()) {
                return rs.getInt("total") == 0;
            }
        } catch (SQLException e) {
            System.err.println("Erro ao verificar lista vazia: " + e.getMessage());
        }
        return true; 
    }

    
    private Usuario mapearResultSetParaUsuario(ResultSet rs) throws SQLException {
        
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