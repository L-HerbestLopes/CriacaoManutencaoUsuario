package com.pss.criacaomanutencaousuarios.presenter;

import com.pss.criacaomanutencaousuarios.model.TipoDeUsuarioEnum;
import com.pss.criacaomanutencaousuarios.model.Usuario;
import com.pss.criacaomanutencaousuarios.repository.UsuarioRepository;
import com.pss.criacaomanutencaousuarios.helper.AdministradorDePermissoesHelper;
import com.pss.criacaomanutencaousuarios.view.PromoverUsuarioView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

public class PromoverUsuarioPresenter implements JanelaPresenter {
    private PromoverUsuarioView view;
    private UsuarioRepository repository;
    private Usuario usuarioAdmin;
    private AdministradorDePermissoesHelper permissoesHelper;
    
    public PromoverUsuarioPresenter(Usuario usuarioAdmin, UsuarioRepository repository){
        this.usuarioAdmin = usuarioAdmin;
        this.repository = repository;
        this.permissoesHelper = new AdministradorDePermissoesHelper();
        this.view = new PromoverUsuarioView(); 
        
        configuraView();
    }
    
    @Override
    public JInternalFrame getView() {
        return view;
    }
    
    private void configuraView() {
        if(permissoesHelper.podeAlterarUsuario(usuarioAdmin)){
            
            listarUsuariosPendentes();
            
            view.getBtnPromover().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    promoverUsuario();
                }
            });
            
            view.setVisible(true);
        } else {
             JOptionPane.showMessageDialog(null, "Acesso Negado.");
             view.dispose();
        }
    }
    
    private void listarUsuariosPendentes() {
        view.getjTextArea1().setText(""); 
        StringBuilder lista = new StringBuilder();
        
        for (Usuario u : repository.getAll()) {
            if (u.getAtivo() && u.getTipo() == TipoDeUsuarioEnum.usuarioComum) {
                lista.append("Nome: ").append(u.getNome())
                     .append("\n");
            }
        }
        
        if (lista.length() == 0) {
            view.getjTextArea1().setText("Nenhum usuário pode ser promovido.");
        } else {
            view.getjTextArea1().setText(lista.toString());
        }
    }

    private void promoverUsuario() {
        String nomeAlvo = view.getTxtNomeUsuario().getText();
        
        if (nomeAlvo.isEmpty()) {
            JOptionPane.showMessageDialog(view, "Digite o nome do usuário.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Usuario usuarioAlvo = repository.buscarUsuario(nomeAlvo);
        
        if (usuarioAlvo != null) {
            usuarioAlvo.setAtivo(true);
            usuarioAlvo.setTipo(TipoDeUsuarioEnum.administrador); 
            repository.atualizarUsuario(usuarioAlvo);
            
            JOptionPane.showMessageDialog(view, "Usuário " + nomeAlvo + " promovido com sucesso!");
            listarUsuariosPendentes();
            view.getTxtNomeUsuario().setText("");
            
        } else {
            JOptionPane.showMessageDialog(view, "Usuário não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }   
}