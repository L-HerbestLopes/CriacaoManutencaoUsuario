package com.pss.criacaomanutencaousuarios.model;

/**
 * @author André Tavares Louzada, Lucas Herbest Lopes e Yuri Sousa Almeida
 */
public class NotificacaoUsuario {
    private Notificacao notificacao;
    private Usuario usuario;
    private boolean foiLida;
    
    public NotificacaoUsuario(Notificacao notificacao, Usuario usuario) {
        this.notificacao = notificacao;
        this.usuario = usuario;
        foiLida = false;
    }

    public Notificacao getNotificacao() {
        return notificacao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public boolean foiLida() {
        return foiLida;
    }
    
    public void marcarLida() {
        foiLida = true;
    }
}
