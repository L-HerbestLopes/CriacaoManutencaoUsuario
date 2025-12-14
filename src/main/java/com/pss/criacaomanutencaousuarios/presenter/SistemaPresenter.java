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
        
        view.getMitEnviarNotificacoes().setVisible(false);
        view.getMitAutenticarUsuarios().setVisible(false);
        view.getMitPromoverUsuario().setVisible(false);
        view.getMitExcluirUsuario().setVisible(false);
        view.getMnuSistema().setVisible(false);
        view.getMitCriarUsuario().setVisible(false);
        view.getMitRebaixarUsuario().setVisible(false);
        
        view.getMitVisualizarNotificacoes().setVisible(true);
        
        if (usuario != null) {
             view.getLblIdentificacaoUsuario().setText(usuario.toString());
             view.getBtnNotificacoes().setText(new NotificacaoUsuarioService().getNotificacoes(usuario, notificacoesDeUsuario).size() + " Notificaçao(oes)");
            
        } else {
            view.getLblIdentificacaoUsuario().setText("Aguardando login");
        }
        
        if(usuario.getTipo().getCodigo() == TipoDeUsuarioEnum.administrador.getCodigo()) {
            view.getMitEnviarNotificacoes().setVisible(true);
            view.getMitCriarUsuario().setVisible(true);
            view.getMitAutenticarUsuarios().setVisible(true);
        }
        if(usuario.getTipo().getCodigo() == TipoDeUsuarioEnum.naoConfirmado.getCodigo()){
            view.setVisible(false);
        }
        
        if(usuario.getTipo().getCodigo() >= TipoDeUsuarioEnum.administradorPrincipal.getCodigo()){
            view.getMitEnviarNotificacoes().setVisible(true);
            view.getMitExcluirUsuario().setVisible(true);
            view.getMnuSistema().setVisible(true);
            view.getMitCriarUsuario().setVisible(true);
            view.getMitRebaixarUsuario().setVisible(true);
            view.getMitPromoverUsuario().setVisible(true);
            view.getMitAutenticarUsuarios().setVisible(true);
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

         view.getMitCriarUsuario().addActionListener(new ActionListener(){
             @Override
            public void actionPerformed(ActionEvent e) {
                abrirJanela(new CriarUsuarioPresenter(repository)); 
            }
         });
         view.getMitRebaixarUsuario().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if (usuario != null) {
                     abrirJanela(new RebaixarUsuarioPresenter(usuario, repository));
                }
            }
         });
        
        view.getMnbSistema().setVisible(false);
    }
    
    
}
