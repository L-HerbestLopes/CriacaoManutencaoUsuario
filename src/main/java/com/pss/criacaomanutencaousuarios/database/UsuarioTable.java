package com.pss.criacaomanutencaousuarios.database;


public class UsuarioTable implements TabelaDatabase{
    @Override
    public String getNomeTabela() {
        return "usuarios";
    }

    @Override
    public String getSqlCriacao() {
        return """
            CREATE TABLE IF NOT EXISTS usuarios (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                nome TEXT NOT NULL UNIQUE,
                senha TEXT NOT NULL,
                tipo INTEGER NOT NULL,
                data_registro TEXT,
                ativo INTEGER DEFAULT 0
            );
        """;
    }
}
