package com.pss.criacaomanutencaousuarios.model;

/**
 * @author André Tavares Louzada, Lucas Herbest Lopes e Yuri Sousa Almeida
 */
public class Notificacao {
    private String message;
    
    public Notificacao(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
