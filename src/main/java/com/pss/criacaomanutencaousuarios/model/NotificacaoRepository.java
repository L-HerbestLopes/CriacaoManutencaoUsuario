package com.pss.criacaomanutencaousuarios.model;

import java.util.ArrayList;
import java.util.List;


public class NotificacaoRepository {
    private List<Notificacao> notificacoes;
    
    public NotificacaoRepository(ArrayList<Notificacao> notificacoes) {
        this.notificacoes = notificacoes;
    }
    
    public void incluirNotificacao(Notificacao notificacao) {
        notificacoes.add(notificacao);
    }
    
    public void removerNotificacao(Notificacao notificacao) {
        if(notificacoes.isEmpty()) throw new RuntimeException("O repositório de notificações está vazio.");
        if(notificacoes == null) throw new RuntimeException("O repositório de notificações não foi iniciado propriamente");
    }
}
