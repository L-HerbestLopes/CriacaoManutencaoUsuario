
package com.pss.criacaomanutencaousuarios.presenter;

import com.pss.criacaomanutencaousuarios.model.TipoDeUsuarioEnum;
import com.pss.criacaomanutencaousuarios.model.Usuario;
import com.pss.criacaomanutencaousuarios.model.UsuarioRepository;
import com.pss.criacaomanutencaousuarios.view.ICadastroUsuarioView;
import com.pss.criacaomanutencaousuarios.view.ILoginView;
import com.pss.criacaomanutencaousuarios.view.LoginView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

/**
 * @author André Tavares Louzada, Lucas Herbest Lopes e Yuri Sousa Almeida
 */

public class CadastroUsuarioPresenter {
    private ICadastroUsuarioView view;
    private UsuarioRepository repository;
    
    
    public CadastroUsuarioPresenter(ICadastroUsuarioView view,UsuarioRepository repository) {
        this.view = view;
        this.repository = repository;
        configuraView();
    }
    public CadastroUsuarioPresenter(ICadastroUsuarioView view) {
        this.view = view;
        configuraView();
    }
    
    public ICadastroUsuarioView getView() {
        return view;
    }
    
    private void configuraView() {
        view.addAcaoLogin(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    cancelar();
                } catch(Exception ex) {
                    // lidar e registrar erro aqui...
                }
            }
        });
        
        view.addAcaoCadastrar(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    confirmar();
                } catch(Exception ex) {
                    // lidar e registrar erro aqui...
                }
            }
        });
        
        view.setVisible(true);
    }
    
    private void cancelar() {
        view.limparCampos();
        view.setVisible(false);
        ILoginView login = new LoginView();
        new LoginPresenter(login, this.repository);
        login.setVisible(true);
    }
    
    private void confirmar() {
    //if ( biblioteca verificadora de senhas aqui)
    // view.getTxtSenha(); e view.getTxtSenhaConfirmada();
    
    // 2. Criar o Usuário (Model)
    String nome = view.getTxtNome();
    
    Usuario novoUsuario = new Usuario(nome, view.getTxtSenha(), LocalDate.now());
    
    //usuarioRepository.cadastrar(novoUsuario);
    System.out.println("Validação do usuário '" + nome + "'solicitado, aguardando confirmação");
    view.limparCampos(); 
    view.setVisible(false);
    }
}
