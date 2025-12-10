package com.pss.criacaomanutencaousuarios;

import com.pss.criacaomanutencaousuarios.database.DatabaseConnection;
import com.pss.criacaomanutencaousuarios.model.Usuario;
import com.pss.criacaomanutencaousuarios.model.UsuarioRepository;
import com.pss.criacaomanutencaousuarios.presenter.EnvioNotificacaoPresenter;
import com.pss.criacaomanutencaousuarios.presenter.FormularioUsuarioPresenter;
import com.pss.criacaomanutencaousuarios.presenter.NotificacaoUsuarioService;
import com.pss.criacaomanutencaousuarios.presenter.SistemaPresenter;
import com.pss.criacaomanutencaousuarios.model.TipoDeUsuarioEnum;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

/**
 * @author André Tavares Louzada, Lucas Herbest Lopes e Yuri Sousa Almeida
 */
public class Principal {

    public static void main(String[] args) {
        listTables(DatabaseConnection.connect());
        
        SistemaPresenter sistema = SistemaPresenter.getInstancia();
        
        ArrayList<Usuario> usuarios = new ArrayList<>();
        UsuarioRepository repository = new UsuarioRepository(usuarios);
        sistema.setRepository(repository);
        
        repository.incluirUsuario(new Usuario(
                "Marcos", "marcos123", TipoDeUsuarioEnum.usuarioComum, LocalDate.now()
                        ));
        repository.incluirUsuario(new Usuario(
                "Júlia", "senhajulia", TipoDeUsuarioEnum.administrador, LocalDate.now()
                        ));
        repository.incluirUsuario(new Usuario(
                "Guilherme", "silva2003", TipoDeUsuarioEnum.usuarioComum, LocalDate.now()
                        ));
        
        EnvioNotificacaoPresenter janela = new EnvioNotificacaoPresenter(repository, new NotificacaoUsuarioService());
        sistema.abrirJanela(janela);
    }
    
	    
    public static void listTables(Connection conn) {
        // Consulta o sqlite_master para encontrar todas as tabelas (temporário)
        String sql = "SELECT name FROM sqlite_master WHERE type='table' AND name NOT LIKE 'sqlite_%'";

        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("\n--- TABELAS EXISTENTES NO BANCO ---");
            boolean found = false;
            
            while (rs.next()) {
                String tableName = rs.getString("name");
                System.out.println("Tabela: " + tableName);
                found = true;
            }
            
            if (!found) {
                 System.out.println("Nenhuma tabela de usuário encontrada.");
            }

        } catch (SQLException e) {
            System.err.println("Erro ao listar as tabelas: " + e.getMessage());
        }
    }

}



