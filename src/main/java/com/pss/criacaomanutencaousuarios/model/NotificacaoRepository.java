package com.pss.criacaomanutencaousuarios.model;

import com.pss.criacaomanutencaousuarios.database.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Repositório para a tabela de mensagens de notificação.
 * @author André Tavares Louzada, Lucas Herbest Lopes e Yuri Sousa Almeida
 */
public class NotificacaoRepository {
    
    public NotificacaoRepository(ArrayList<Notificacao> notificacoes) {
    }
    
    public void incluirNotificacao(Notificacao notificacao) {
        String sql = "INSERT INTO notificacoes (mensagem) VALUES (?)";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, notificacao.getMessage());
            pstmt.executeUpdate();
            
        } catch (SQLException e) {
            System.err.println("Erro ao incluir notificação: " + e.getMessage());
        }
    }
    
    public void removerNotificacao(Notificacao notificacao) {
        String sql = "DELETE FROM notificacoes WHERE mensagem = ?"; 

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, notificacao.getMessage());
            pstmt.executeUpdate();
            
        } catch (SQLException e) {
            System.err.println("Erro ao remover notificação: " + e.getMessage());
        }
    }
}