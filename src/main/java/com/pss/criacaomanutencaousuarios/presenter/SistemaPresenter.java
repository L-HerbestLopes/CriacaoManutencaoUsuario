package com.pss.criacaomanutencaousuarios.presenter;

import com.css.criacaomanutencaousuarios.service.NotificacaoUsuarioService;
import com.pss.criacaomanutencaousuarios.model.TipoDeUsuarioEnum;
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
        
        // esconde todas as funcionalidades para que decida quais serão mostradas depois
        view.getMitEnviarNotificacoes().setVisible(false);
        view.getMitAutenticarUsuarios().setVisible(false);
        view.getMitPromoverUsuario().setVisible(false);
        view.getMitExcluirUsuario().setVisible(false);
        view.getMnuSistema().setVisible(false);
        
        view.getMitVisualizarNotificacoes().setVisible(false);
        
        if (usuario != null) {
             view.getLblIdentificacaoUsuario().setText(usuario.toString());
            
             //TO DO     arrumar a linha de baixo para mostrar quantas notificacoes o usuario tem
             view.getBtnNotificacoes().setText(new NotificacaoUsuarioService().getNotificacoes(usuario, notificacoesDeUsuario).size() + " Notificaçao(oes)");
            
        } else {
            view.getLblIdentificacaoUsuario().setText("Aguardando login");
        }
        
        // expor funcionalidades apenas para usuários com acesso
        if(usuario.getTipo().getCodigo() >= TipoDeUsuarioEnum.administrador.getCodigo()) {
            view.getMitEnviarNotificacoes().setVisible(true);
            view.getMitAutenticarUsuarios().setVisible(true);
            view.getMitPromoverUsuario().setVisible(true);
        }
        
        if(usuario.getTipo().getCodigo() >= TipoDeUsuarioEnum.usuarioComum.getCodigo()) {
            view.getMitVisualizarNotificacoes().setVisible(true);
        }
        if(usuario.getTipo().getCodigo() >= TipoDeUsuarioEnum.administradorPrincipal.getCodigo()){
            view.getMitExcluirUsuario().setVisible(true);
            view.getMnuSistema().setVisible(true);
        }
    }
    
    private void configuraView() {
        view.getMitEnviarNotificacoes().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirJanela(new EnvioNotificacaoPresenter(repository, notificacoesDeUsuario));
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
         view.getMitExcluirUsuario().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (usuario != null) {
                     abrirJanela(new ExcluirUsuarioPresenter(usuario, repository));
                }
            }
        });
         view.getMitCSV().addActionListener(new ActionListener(){
             @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Tipo de log definido como CSV", "LOG", JOptionPane.INFORMATION_MESSAGE);
                
            }
         });
         view.getMitJSON().addActionListener(new ActionListener(){
             @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Tipo de log definido como JSON", "LOG", JOptionPane.INFORMATION_MESSAGE);
                
            }
         });
         view.getBtnNotificacoes().addActionListener(new ActionListener(){
             @Override
            public void actionPerformed(ActionEvent e) {
                abrirJanela(new VisualizarNotificacoesPresenter(usuario, notificacoesDeUsuario));
            }
         });
        
        view.getMnbSistema().setVisible(false);
    }
    
    
}
