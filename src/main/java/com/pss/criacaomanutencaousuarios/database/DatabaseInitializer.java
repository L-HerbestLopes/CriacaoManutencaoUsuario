package com.pss.criacaomanutencaousuarios.database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DatabaseInitializer {
    
    private final List<TabelaDatabase> tabelas;

    public DatabaseInitializer() {
        this.tabelas = new ArrayList<>();
        tabelas.add(new UsuarioTable());
        tabelas.add(new NotificacaoTable());
        tabelas.add(new NotificacaoUsuarioTable());
        this.inicializar();
    }

    public void inicializar() {
        try (Connection conn = DatabaseConnection.connect();
             Statement stmt = conn.createStatement()) {
            
            for (TabelaDatabase tabelas : tabelas) {
                System.out.println("Verificando/Criando tabela: " + tabelas.getNomeTabela());
                stmt.execute(tabelas.getSqlCriacao());
            }
            
        } catch (SQLException e) {
            System.err.println("Erro ao inicializar banco: " + e.getMessage());
        }
    }
}