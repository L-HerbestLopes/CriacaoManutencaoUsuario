package com.pss.criacaomanutencaousuarios.view;

import java.awt.event.ActionListener;


public interface ILoginView {
    void acaoCadastrar(ActionListener acao);
    void acaoLogin(ActionListener acao);
    
    void setVisible(boolean visibilidade);
    String getNome();
    String getSenha();
}
