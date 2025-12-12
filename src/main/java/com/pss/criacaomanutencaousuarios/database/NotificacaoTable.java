package com.pss.criacaomanutencaousuarios.database;

public class NotificacaoTable implements TabelaDatabase{
    @Override
    public String getNomeTabela() {
        return "notificacoes";
    }

    @Override
    public String getSqlCriacao() {
        return """
            CREATE TABLE IF NOT EXISTS notificacoes (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                mensagem TEXT NOT NULL,
                data_criacao TEXT DEFAULT CURRENT_TIMESTAMP
            );
        """;
    }
}