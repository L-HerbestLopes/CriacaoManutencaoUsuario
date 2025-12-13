package com.pss.criacaomanutencaousuarios.presenter;

import com.pss.criacaomanutencaousuarios.model.Usuario;
import com.pss.criacaomanutencaousuarios.model.UsuarioRepository; 
import com.pss.criacaomanutencaousuarios.view.AlterarSenhaView;
import com.pss.senha.validacao.ValidadorSenha;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

public class AlterarSenhaPresenter implements JanelaPresenter {
    private AlterarSenhaView view;
    private Usuario usuarioLogado;
    private UsuarioRepository repository; 
    
    public AlterarSenhaPresenter(Usuario usuarioLogado, UsuarioRepository repository){
        this.usuarioLogado = usuarioLogado;
        this.repository = repository; 
        this.view = new AlterarSenhaView(); 
        configuraView();
    }
    
    @Override
    public JInternalFrame getView() {
        return view;
    }
    
    private void configuraView() {
        view.getBtnCancelar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    fechar();
                } catch(Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        
        view.getBtnConfirmar().addActionListener(new ActionListener() {
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

    private void confirmar() {
        String senhaAtualDigitada = view.getTxtSenhaAtual().getText();
        String novaSenha = view.getTxtNovaSenha().getText();
        String confirmarSenha = view.getTxtConfirmarSenha().getText();
        
        if (!usuarioLogado.getSenha().equals(senhaAtualDigitada)) {
            JOptionPane.showMessageDialog(view, "A senha atual está incorreta!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        ValidadorSenha validador = new ValidadorSenha();
        List<String> resultado = validador.validar(novaSenha);
        
        if(!resultado.isEmpty()) {
            System.err.println(resultado.get(0));
            JOptionPane.showMessageDialog(null,resultado.get(0), "Erro!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if(!novaSenha.equals(confirmarSenha)) {
            System.err.println("Senhas fornecidas são diferentes!");
            JOptionPane.showMessageDialog(null, "As senhas fornecidas são diferentes", "Erro!", JOptionPane.ERROR_MESSAGE);
            return;
        }

        usuarioLogado.setSenha(novaSenha);
        repository.atualizarUsuario(usuarioLogado);
        JOptionPane.showMessageDialog(view, "Senha alterada com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        fechar();
    }
    
    private void fechar() {
        view.dispose();
    }
}