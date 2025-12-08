package com.pss.sistemanotificacaoprojetos.presenter;

import com.pss.sistemanotificacaoprojetos.model.Usuario;
import com.pss.sistemanotificacaoprojetos.model.UsuarioRepository;
import com.pss.sistemanotificacaoprojetos.view.SistemaView;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe presenter singleton que lida com o sistema/desktop principal do MDI
 * @author André Tavares Louzada, Lucas Herbest Lopes e Yuri Sousa Almeida
 */
public class SistemaPresenter {
    private final SistemaView view;
    private static SistemaPresenter instancia;
    private final List<JanelaPresenter> janelas;
    private Usuario usuario;
    private UsuarioRepository repository;
    
    private SistemaPresenter() {
        view = new SistemaView();
        configuraView();
        
        janelas = new ArrayList<>();
        
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
    
    public void abrirJanela() {
        
    }
    
    private void configuraView() {
        view.setVisible(true);
    }
}
