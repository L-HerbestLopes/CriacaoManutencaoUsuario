package com.pss.criacaomanutencaousuarios.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TableInfo {
    public static void listTables(Connection conn) {
        String sql = "SELECT name FROM sqlite_master WHERE type='table' AND name NOT LIKE 'sqlite_%'";

        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("\n--- TABELAS EXISTENTES NO BANCO ---");
            boolean achado = false;
            
            while (rs.next()) {
                String tableName = rs.getString("name");
                System.out.println("Tabela: " + tableName);
                achado = true;
            }
            
            if (!achado) {
                 System.out.println("Nenhuma tabela de usuário encontrada.");
            }

        } catch (SQLException e) {
            System.err.println("Erro ao listar as tabelas: " + e.getMessage());
        }
    }

    
}
