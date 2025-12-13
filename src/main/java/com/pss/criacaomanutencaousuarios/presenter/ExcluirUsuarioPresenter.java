package com.pss.criacaomanutencaousuarios.presenter;

import com.pss.criacaomanutencaousuarios.helper.AdministradorDePermissoesHelper;
import com.pss.criacaomanutencaousuarios.model.TipoDeUsuarioEnum;
import com.pss.criacaomanutencaousuarios.model.Usuario;
import com.pss.criacaomanutencaousuarios.repository.UsuarioRepository;
import com.pss.criacaomanutencaousuarios.view.ExcluirUsuarioView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

public class ExcluirUsuarioPresenter implements JanelaPresenter {
    private ExcluirUsuarioView view;
    private UsuarioRepository repository;
    private Usuario usuarioAdmin;
    private AdministradorDePermissoesHelper permissoesHelper;
    
    public ExcluirUsuarioPresenter(Usuario usuarioAdmin, UsuarioRepository repository){
        this.usuarioAdmin = usuarioAdmin;
        this.repository = repository;
        this.permissoesHelper = new AdministradorDePermissoesHelper();
        this.view = new ExcluirUsuarioView(); 
        
        configuraView();
    }
    
    @Override
    public JInternalFrame getView() {
        return view;
    }
    
    private void configuraView() {
        if(permissoesHelper.podeExcluirUsuario(usuarioAdmin)){
            
            listarUsuariosParaExclusao();
            
            view.getBtnExcluir().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    excluirUsuario();
                }
            });
            
            view.setVisible(true);
        } else {
             JOptionPane.showMessageDialog(null, "Acesso Negado.");
             view.dispose();
        }
    }
    
    private void listarUsuariosParaExclusao() {
        view.getjTextArea1().setText(""); 
        StringBuilder lista = new StringBuilder();
        
        for (Usuario u : repository.getAll()) {
            if (u.getAtivo() && !u.getNome().equals(usuarioAdmin.getNome())) {
                lista.append("Nome: ").append(u.getNome())
                     .append(" | Tipo: ").append(u.getTipo())
                     .append("\n");
            }
        }
        
        if (lista.length() == 0) {
            view.getjTextArea1().setText("Nenhum usuário disponível para exclusão.");
        } else {
            view.getjTextArea1().setText(lista.toString());
        }
    }

    private void excluirUsuario() {
        String nomeAlvo = view.getTxtNomeUsuario().getText();
        
        if (nomeAlvo.isEmpty()) {
            JOptionPane.showMessageDialog(view, "Digite o nome do usuário.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (nomeAlvo.equals(usuarioAdmin.getNome())) {
            JOptionPane.showMessageDialog(view, "Você não pode se excluir!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Usuario usuarioAlvo = repository.buscarUsuario(nomeAlvo);
        
        if (usuarioAlvo != null) {
            usuarioAlvo.setAtivo(false);                
            usuarioAlvo.setTipo(TipoDeUsuarioEnum.excluido); 
            
            repository.atualizarUsuario(usuarioAlvo); 
            
            JOptionPane.showMessageDialog(view, "Usuário " + nomeAlvo + " excluído com sucesso!");
            
            listarUsuariosParaExclusao(); 
            view.getTxtNomeUsuario().setText("");
            
        } else {
            JOptionPane.showMessageDialog(view, "Usuário não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }   
}