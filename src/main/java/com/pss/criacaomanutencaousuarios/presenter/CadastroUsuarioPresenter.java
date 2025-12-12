
package com.pss.criacaomanutencaousuarios.presenter;

import com.pss.criacaomanutencaousuarios.model.TipoDeUsuarioEnum;
import com.pss.criacaomanutencaousuarios.model.Usuario;
import com.pss.criacaomanutencaousuarios.model.UsuarioRepository;
import com.pss.criacaomanutencaousuarios.view.CadastroUsuarioView;
import com.pss.criacaomanutencaousuarios.view.LoginView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

/**
 * @author André Tavares Louzada, Lucas Herbest Lopes e Yuri Sousa Almeida
 */

public class CadastroUsuarioPresenter {
    private CadastroUsuarioView view;
    
    
    
    public CadastroUsuarioPresenter() {
        this.view = new CadastroUsuarioView();

        configuraView();
    }
    
    public CadastroUsuarioView getView() {
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
        new LoginPresenter();
    }
    
    private void confirmar() {
                                                        //TO DO
                                                        
                                                        
    //MOSTRAR adicionado com sucedo (alert) joptionpane
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
