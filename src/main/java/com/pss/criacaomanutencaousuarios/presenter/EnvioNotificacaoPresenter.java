package com.pss.criacaomanutencaousuarios.presenter;

import com.pss.criacaomanutencaousuarios.model.Usuario;
import com.pss.criacaomanutencaousuarios.model.UsuarioRepository;
import com.pss.criacaomanutencaousuarios.view.EnvioNotificacaoView;
import javax.swing.JInternalFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class EnvioNotificacaoPresenter implements JanelaPresenter {
    private EnvioNotificacaoView view;
    private UsuarioRepository usuarios;
    
    public EnvioNotificacaoPresenter(UsuarioRepository usuarios) {
        this.usuarios = usuarios;
        view = new EnvioNotificacaoView();
        
        configuraView();
    }

    @Override
    public JInternalFrame getView() {
        return view;
    }
    
    private void configuraView() {
        carregarUsuarios(view.getTblUsuarios());
        
        view.setVisible(true);
    }
    
    private void carregarUsuarios(JTable tabela) {
        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
        modelo.setRowCount(0);
        
        for(Usuario usuario : usuarios.getAll()) {
            modelo.addRow(new Object[] {
                false, usuario.getNome()
            });
        }
    }  
}
