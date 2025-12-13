package com.pss.criacaomanutencaousuarios.presenter;

import com.pss.criacaomanutencaousuarios.repository.NotificacaoRepository;
import com.pss.criacaomanutencaousuarios.repository.NotificacaoUsuarioRepository;
import com.pss.criacaomanutencaousuarios.model.Usuario;
import com.pss.criacaomanutencaousuarios.repository.UsuarioRepository;
import com.pss.criacaomanutencaousuarios.view.SistemaView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

/**
 * Classe presenter singleton que lida com o sistema/desktop principal do MDI
 * @author André Tavares Louzada, Lucas Herbest Lopes e Yuri Sousa Almeida
 */
public class SistemaPresenter {
    private final SistemaView view;
    private static SistemaPresenter instancia;
    private Usuario usuario;
    private UsuarioRepository repository;
    private NotificacaoRepository notificacoes;
    private NotificacaoUsuarioRepository notificacoesDeUsuario;
    
    public SistemaPresenter() {
        this.view = new SistemaView();
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
        this.repository = repository;
    }
    
    public void setNotificacoesRepository(NotificacaoRepository repository) {
        notificacoes = repository;
    }
    
    public void setNotificacaoUsuarioRepository(NotificacaoUsuarioRepository repository) {
        notificacoesDeUsuario = repository;
    }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public void abrirJanela(JanelaPresenter janela) {
        
        JInternalFrame janelaView = janela.getView();
        view.add(janelaView);
    }
    
    public void carregarView() {
        view.setVisible(true);
        view.getMnbSistema().setVisible(true);
        
        if (usuario != null) {
            if(usuario.getTipo().getCodigo() > 0) {
                view.getMitEnviarNotificacoes().setVisible(true);
            }
            
            view.getLblIdentificacaoUsuario().setText(usuario.toString());
        } else {
            view.getLblIdentificacaoUsuario().setText("Aguardando login");
            view.getMitEnviarNotificacoes().setVisible(false);
        }
    }
    
    private void configuraView() {
        carregarView();
        view.getMitEnviarNotificacoes().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirJanela(new EnvioNotificacaoPresenter(repository));
            }
        });
        
        view.getMitVisualizarNotificacoes().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirJanela(new VisualizarNotificacoesPresenter(usuario, notificacoesDeUsuario));
            }
        });
        
        view.getMitTrocarSenha().addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (usuario != null) {
                abrirJanela(new AlterarSenhaPresenter(usuario, repository));
            }
        }
    });
        
        view.getMitTrocarDeUsuario().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                JOptionPane.showMessageDialog(null, "Usuario Desconectado", "Logout!", JOptionPane.INFORMATION_MESSAGE);
                new CadastroUsuarioPresenter(repository);
                view.setVisible(false);
            }
        });
        view.getMitAutenticarUsuarios().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (usuario != null) {
                    abrirJanela(new AutenticarUsuarioPresenter(usuario, repository));
                }
            }
        });

        
         view.getMitPromoverUsuario().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (usuario != null) {
                     abrirJanela(new PromoverUsuarioPresenter(usuario, repository));
                }
            }
        });
        
        
        view.getMitEnviarNotificacoes().setVisible(false);
        
        view.getMnbSistema().setVisible(false);
        view.setVisible(true);
    }
    
    
}
