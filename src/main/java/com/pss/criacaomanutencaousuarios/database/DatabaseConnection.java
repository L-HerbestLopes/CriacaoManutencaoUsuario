package com.pss.criacaomanutencaousuarios.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {

    private static final String DATABASE_URL = "jdbc:sqlite:seu_banco.sqlite"; 

    public static Connection connect() {
        Connection conn = null;
        try {
            // O driver já foi carregado graças à dependência no pom.xml
            conn = DriverManager.getConnection(DATABASE_URL);
            System.out.println("Conexão estabelecida com sucesso.");
        } catch (SQLException e) {
            System.err.println("Erro de conexão com o SQLite: " + e.getMessage());
            e.printStackTrace();
        }
        return conn;
    }
    
    
    
    public static void main(String[] args) {
        Connection testConn = connect();
        if (testConn != null) {
            try {
                testConn.close();
                System.out.println("Conexão fechada.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}