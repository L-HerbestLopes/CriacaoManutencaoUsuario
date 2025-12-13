package com.pss.criacaomanutencaousuarios.presenter;

import com.pss.criacaomanutencaousuarios.model.TipoDeUsuarioEnum;
import com.pss.criacaomanutencaousuarios.model.Usuario;
import com.pss.criacaomanutencaousuarios.repository.UsuarioRepository;
import com.pss.criacaomanutencaousuarios.view.AutenticarUsuarioView;
import com.pss.criacaomanutencaousuarios.helper.AdministradorDePermissoesHelper;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

public class AutenticarUsuarioPresenter implements JanelaPresenter {
    private AutenticarUsuarioView view;
    private UsuarioRepository repository;
    private Usuario usuarioAdmin;
    private AdministradorDePermissoesHelper permissoesHelper;
    
    public AutenticarUsuarioPresenter(Usuario usuarioAdmin, UsuarioRepository repository){
        this.usuarioAdmin = usuarioAdmin;
        this.repository = repository;
        this.permissoesHelper = new AdministradorDePermissoesHelper();
        this.view = new AutenticarUsuarioView(); 
        
        configuraView();
    }
    
    @Override
    public JInternalFrame getView() {
        return view;
    }
    
    private void configuraView() {
        if(permissoesHelper.podeAutenticarUsuario(usuarioAdmin)){
            
            listarUsuariosPendentes();
            
            view.getBtnValidar().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    aprovarUsuario();
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
            if (!u.getAtivo() || u.getTipo() == TipoDeUsuarioEnum.naoConfirmado) {
                lista.append("Nome: ").append(u.getNome())
                     .append("\n");
            }
        }
        
        if (lista.length() == 0) {
            view.getjTextArea1().setText("Nenhum usuário aguardando validação.");
        } else {
            view.getjTextArea1().setText(lista.toString());
        }
    }

    private void aprovarUsuario() {
        String nomeAlvo = view.getTxtNomeUsuario().getText();
        
        if (nomeAlvo.isEmpty()) {
            JOptionPane.showMessageDialog(view, "Digite o nome do usuário.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Usuario usuarioAlvo = repository.buscarUsuario(nomeAlvo);
        
        if (usuarioAlvo != null) {
            usuarioAlvo.setAtivo(true);
            usuarioAlvo.setTipo(TipoDeUsuarioEnum.usuarioComum);
            repository.atualizarUsuario(usuarioAlvo);
            
            JOptionPane.showMessageDialog(view, "Usuário " + nomeAlvo + " validado com sucesso!");
            listarUsuariosPendentes();
            view.getTxtNomeUsuario().setText("");
            
        } else {
            JOptionPane.showMessageDialog(view, "Usuário não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }   
}