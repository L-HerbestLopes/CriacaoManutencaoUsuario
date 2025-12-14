package com.pss.criacaomanutencaousuarios.presenter;

import com.pss.criacaomanutencaousuarios.helper.AdministradorDePermissoesHelper;
import com.pss.criacaomanutencaousuarios.model.TipoDeUsuarioEnum;
import com.pss.criacaomanutencaousuarios.model.Usuario;
import com.pss.criacaomanutencaousuarios.repository.UsuarioRepository;
import com.pss.criacaomanutencaousuarios.view.RebaixarUsuarioView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

/**
 * @author André
 */
public class RebaixarUsuarioPresenter implements JanelaPresenter {
    private RebaixarUsuarioView view;
    private UsuarioRepository repository;
    private Usuario usuarioAdmin;
    private AdministradorDePermissoesHelper permissoesHelper;
    
    public RebaixarUsuarioPresenter(Usuario usuarioAdmin, UsuarioRepository repository){
        this.usuarioAdmin = usuarioAdmin;
        this.repository = repository;
        this.permissoesHelper = new AdministradorDePermissoesHelper();
        this.view = new RebaixarUsuarioView(); 
        
        configuraView();
    }
    
    @Override
    public JInternalFrame getView() {
        return view;
    }
    
    private void configuraView() {
        if(permissoesHelper.podeAlterarUsuario(usuarioAdmin)){
            
            listarUsuariosRebaixaveis(); 
            
            view.getBtnRebaixar().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    rebaixarUsuario();
                }
            });
            
            view.setVisible(true);
        } else {
             JOptionPane.showMessageDialog(null, "Acesso Negado.");
             view.dispose();
        }
    }
    
    private void listarUsuariosRebaixaveis() {
        view.getjTextArea1().setText(""); 
        StringBuilder lista = new StringBuilder();
        
        for (Usuario u : repository.getAll()) {
            if (u.getAtivo() && 
                u.getTipo() == TipoDeUsuarioEnum.administrador && 
                !u.getNome().equals(usuarioAdmin.getNome())) {
                
                lista.append("Nome: ").append(u.getNome())
                     .append(" (Administrador)\n");
            }
        }
        
        if (lista.length() == 0) {
            view.getjTextArea1().setText("Nenhum administrador disponível para rebaixamento.");
        } else {
            view.getjTextArea1().setText(lista.toString());
        }
    }

    private void rebaixarUsuario() {
        String nomeAlvo = view.getTxtNomeUsuario().getText();
        
        if (nomeAlvo.isEmpty()) {
            JOptionPane.showMessageDialog(view, "Digite o nome do usuário.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (nomeAlvo.equals(usuarioAdmin.getNome())) {
            JOptionPane.showMessageDialog(view, "Você não pode rebaixar a si mesmo!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Usuario usuarioAlvo = repository.buscarUsuario(nomeAlvo);
        
        if (usuarioAlvo != null) {
        
            if (permissoesHelper.podeSerRebaixado(usuarioAlvo)) {
                usuarioAlvo.setAtivo(true); 
                usuarioAlvo.setTipo(TipoDeUsuarioEnum.usuarioComum); 
                repository.atualizarUsuario(usuarioAlvo);

                JOptionPane.showMessageDialog(view, "Usuário " + nomeAlvo + " rebaixado para Usuário Comum!");
                
                listarUsuariosRebaixaveis();
                view.getTxtNomeUsuario().setText("");
                
            } else {
                 JOptionPane.showMessageDialog(view, "Este usuário não pode ser rebaixado (Ex: Admin Principal).", "Erro", JOptionPane.ERROR_MESSAGE);
            }
            
        } else {
            JOptionPane.showMessageDialog(view, "Usuário não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }   
}