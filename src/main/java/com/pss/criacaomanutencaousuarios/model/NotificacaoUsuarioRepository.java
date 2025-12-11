package com.pss.criacaomanutencaousuarios.model;

import java.util.ArrayList;
import java.util.List;


public class NotificacaoUsuarioRepository {
    private List<NotificacaoUsuario> notificacoes;
    
    public NotificacaoUsuarioRepository(ArrayList<NotificacaoUsuario> notificacoes) {
        this.notificacoes = notificacoes;
    }
    
    public void incluirNotificacaoUsuario(NotificacaoUsuario notificacao) {
        notificacoes.add(notificacao);
    }
    
    public void removerNotificacaoUsuario(NotificacaoUsuario notificacao) {
        if(notificacoes.isEmpty()) throw new RuntimeException("O repositório de notificações está vazio.");
        if(notificacoes == null) throw new RuntimeException("O repositório de notificações não foi iniciado propriamente");
    }
    
    public List<NotificacaoUsuario> getAll() {
        return notificacoes;
    }
}
