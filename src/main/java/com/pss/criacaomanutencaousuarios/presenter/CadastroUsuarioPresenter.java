
package com.pss.criacaomanutencaousuarios.presenter;

import com.pss.criacaomanutencaousuarios.model.TipoDeUsuarioEnum;
import com.pss.criacaomanutencaousuarios.model.Usuario;
import com.pss.criacaomanutencaousuarios.repository.UsuarioRepository;
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
    private UsuarioRepository repository;
    
    public CadastroUsuarioPresenter(UsuarioRepository repository) {
        this.view = new CadastroUsuarioView();
        this.repository = repository;
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
                    ex.printStackTrace();
                }
            }
        });
        
        view.addAcaoCadastrar(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    confirmar();
                } catch(Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        
        view.setVisible(true);
    }
    
    private void cancelar() {
        view.limparCampos();
        view.setVisible(false);
        new LoginPresenter(repository);
    }
    
    private void confirmar() {
        
        ValidadorSenha validador = new ValidadorSenha();
        List<String> resultado = validador.validar(view.getTxtSenha());
        
        if(!resultado.isEmpty()) {
            System.err.println(resultado.get(0));
            JOptionPane.showMessageDialog(null,resultado.get(0), "Erro!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if(!view.getTxtSenha().equals(view.getTxtSenhaConfirmada())) {
            System.err.println("Senhas fornecidas são diferentes!");
                JOptionPane.showMessageDialog(null, "As senhas fornecidas são diferentes", "Erro!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if(repository.buscarUsuario(view.getTxtNome()) != null){
            System.err.println("Já existe usuario com esse nome!");
            JOptionPane.showMessageDialog(null, "Já existe usuário com esse nome!", "Erro!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if(view.getTxtNome().length() < 2){
            System.err.println("Insira um nome válido!");
            JOptionPane.showMessageDialog(null, "Insira um nome válido!", "Erro!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        

        Usuario novoUsuario;
        SistemaPresenter sistema = SistemaPresenter.getInstancia();

        if(repository.listaVazia()){
            novoUsuario = new Usuario(view.getTxtNome(), view.getTxtSenha(), TipoDeUsuarioEnum.administradorPrincipal, LocalDate.now());
            novoUsuario.setAtivo(true);
            JOptionPane.showMessageDialog(null, "Administrador principal criado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            
        }
        else{
            novoUsuario = new Usuario(view.getTxtNome(), view.getTxtSenha(), TipoDeUsuarioEnum.naoConfirmado, LocalDate.now());
            JOptionPane.showMessageDialog(null, "Usuário criado com sucesso! Aguardando confirmação", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            
        }
        
        repository.incluirUsuario(novoUsuario);
        sistema.setUsuario(novoUsuario);
        view.setVisible(false);
        new LoginPresenter(this.repository);

    }

}
