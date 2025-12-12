package com.pss.criacaomanutencaousuarios.database;

public class NotificacaoUsuarioTable implements TabelaDatabase {

    @Override
    public String getNomeTabela() {
        return "notificacoes_usuarios";
    }

    @Override
    public String getSqlCriacao() {
        return """
            CREATE TABLE IF NOT EXISTS notificacoes_usuarios (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                id_usuario INTEGER NOT NULL,
                id_notificacao INTEGER NOT NULL,
                lida INTEGER DEFAULT 0,
                
                FOREIGN KEY (id_usuario) REFERENCES usuarios(id),
                FOREIGN KEY (id_notificacao) REFERENCES notificacoes(id)
            );
        """;
    }
}