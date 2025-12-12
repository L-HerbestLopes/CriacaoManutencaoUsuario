
package com.pss.criacaomanutencaousuarios.presenter;

import com.pss.criacaomanutencaousuarios.model.Usuario;
import com.pss.criacaomanutencaousuarios.view.CadastroUsuarioView;
import com.pss.senha.validacao.ValidadorSenha;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * @author André Tavares Louzada, Lucas Herbest Lopes e Yuri Sousa Almeida
 */

public class CadastroUsuarioPresenter {
    private CadastroUsuarioView view;
    private Usuario usuario;
    
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
        
        ValidadorSenha validador = new ValidadorSenha();
        List<String> resultado = validador.validar(view.getTxtSenha());
        
        // falha caso validar retorne alguma string indicando erro
        if(!resultado.isEmpty()) {
                
            // no futuro expor esse erro para o usuario
            System.err.println(resultado.get(0));
            JOptionPane.showMessageDialog(null,resultado.get(0), "Erro!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if(!view.getTxtSenha().equals(view.getTxtSenhaConfirmada())) {
            // no futuro expor esse erro para o usuario
            System.err.println("Senhas fornecidas são diferentes!");
                JOptionPane.showMessageDialog(null, "As senhas fornecidas são diferentes", "Erro!", JOptionPane.ERROR_MESSAGE);
            return;
        }
            
    //MOSTRAR adicionado com sucedo (alert) joptionpane
    // view.getTxtSenha(); e view.getTxtSenhaConfirmada();
    
        // 2. Criar o Usuário (Model)

        Usuario novoUsuario = new Usuario(view.getName(), view.getTxtSenha(), LocalDate.now());

        //usuarioRepository.cadastrar(novoUsuario);
        JOptionPane.showMessageDialog(null, "Usuario cadastrado com sucesso!", "Criado com sucesso!", JOptionPane.INFORMATION_MESSAGE);
        System.out.println("Validação do usuário '" + view.getName() + "'solicitado, aguardando confirmação");
        view.limparCampos(); 
        view.setVisible(false);
    }

}
