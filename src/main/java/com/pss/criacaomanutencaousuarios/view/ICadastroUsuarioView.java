package com.pss.criacaomanutencaousuarios.view;

import java.awt.event.ActionListener;

public interface ICadastroUsuarioView {
    void addAcaoCadastrar(ActionListener acao);
    void addAcaoLogin(ActionListener acao);
    
    String getTxtNome();
    String getTxtSenha();
    String getTxtSenhaConfirmada();
    
    void setVisible(boolean visibilidade);
    void limparCampos();
}
