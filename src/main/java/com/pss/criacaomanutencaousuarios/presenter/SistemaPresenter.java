package com.pss.criacaomanutencaousuarios.presenter;

import com.pss.criacaomanutencaousuarios.model.NotificacaoUsuarioRepository;
import com.pss.criacaomanutencaousuarios.model.Usuario;
import com.pss.criacaomanutencaousuarios.model.UsuarioRepository;
import com.pss.criacaomanutencaousuarios.view.SistemaView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JInternalFrame;

/**
 * Classe presenter singleton que lida com o sistema/desktop principal do MDI
 * @author André Tavares Louzada, Lucas Herbest Lopes e Yuri Sousa Almeida
 */
public class SistemaPresenter {
    private final SistemaView view;
    private static SistemaPresenter instancia;
    private Usuario usuario;
    private UsuarioRepository usuarios;
    private NotificacaoUsuarioRepository notificacoes;
    
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
    
    public void setUsuarioRepository(UsuarioRepository repository) {
        usuarios = repository;
    }
    
    public void setNotificacaoUsuarioRepository(NotificacaoUsuarioRepository repository) {
        notificacoes = repository;
    }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public void abrirJanela(JanelaPresenter janela) {
        
        JInternalFrame janelaView = janela.getView();
        view.add(janelaView);
    }
    
    public void recarregarView() {
        view.getMnbSistema().setVisible(true);
        
        // testa para o tipo de usuário se funcionalidades podem aparecer na interface
        if(usuario.getTipo().getCodigo() > 0) {
            view.getMitEnviarNotificacoes().setVisible(true);
        }
    }
    
    private void configuraView() {
        view.getMitEnviarNotificacoes().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirJanela(new EnvioNotificacaoPresenter(usuarios));
            }
        });
        
        view.getMitVisualizarNotificacoes().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirJanela(new VisualizarNotificacoesPresenter(usuario, notificacoes));
            }
        });
        
        view.getMitEnviarNotificacoes().setVisible(false);
        
        view.getMnbSistema().setVisible(false);
        view.setVisible(true);
    }
}
