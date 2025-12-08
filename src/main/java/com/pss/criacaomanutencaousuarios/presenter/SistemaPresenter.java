package com.pss.criacaomanutencaousuarios.presenter;

import com.pss.criacaomanutencaousuarios.model.Usuario;
import com.pss.criacaomanutencaousuarios.model.UsuarioRepository;
import com.pss.criacaomanutencaousuarios.view.SistemaView;
import javax.swing.JInternalFrame;

/**
 * Classe presenter singleton que lida com o sistema/desktop principal do MDI
 * @author André Tavares Louzada, Lucas Herbest Lopes e Yuri Sousa Almeida
 */
public class SistemaPresenter {
    private final SistemaView view;
    private static SistemaPresenter instancia;
    private Usuario usuario;
    private UsuarioRepository repository;
    
    private SistemaPresenter() {
        view = new SistemaView();
        configuraView();
        
        // inicialização de outras coisas junto ao construtor
        // usuario se mantém null até autenticação/cadastro
        // a referência a usuário é passada para janelas filhas mesmo se ainda for null
    }
    
    public static SistemaPresenter getInstancia() {
        if (instancia == null) instancia = new SistemaPresenter();
        
        return instancia;
    }
    
    public void setRepository(UsuarioRepository repository) {
        this.repository = repository;
    }
    
    public void abrirJanela(JanelaPresenter janela) {
        
        JInternalFrame janelaView = janela.getView();
        view.add(janelaView);
    }
    
    private void configuraView() {
        view.setVisible(true);
    }
}
