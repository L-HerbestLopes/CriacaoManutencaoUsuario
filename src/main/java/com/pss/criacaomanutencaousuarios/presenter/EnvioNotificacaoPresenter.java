package com.pss.criacaomanutencaousuarios.presenter;

import com.css.criacaomanutencaousuarios.service.NotificacaoUsuarioService;
import com.pss.criacaomanutencaousuarios.model.Notificacao;
import com.pss.criacaomanutencaousuarios.model.Usuario;
import com.pss.criacaomanutencaousuarios.repository.UsuarioRepository;
import com.pss.criacaomanutencaousuarios.view.EnvioNotificacaoView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JInternalFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class EnvioNotificacaoPresenter implements JanelaPresenter {
    private EnvioNotificacaoView view;
    private UsuarioRepository usuarios;
    private NotificacaoUsuarioService notificacaoService;
    
    public EnvioNotificacaoPresenter(UsuarioRepository usuarios) {
        this.usuarios = usuarios;
        this.notificacaoService = new NotificacaoUsuarioService();
        view = new EnvioNotificacaoView();
        
        configuraView();
    }

    @Override
    public JInternalFrame getView() {
        return view;
    }
    
    private void configuraView() {
        carregarUsuarios(view.getTblUsuarios());
        
        view.getBtnMarcarTodos().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                preencher(view.getTblUsuarios(), true);
            }
        });
        
        view.getBtnDesmarcarTodos().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                preencher(view.getTblUsuarios(), false);
            }
        });
        
        view.getBtnEnviar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                enviar();
            }
        });
        
        view.getBtnCancelar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cancelar();
            }
        });
        
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
    
    private void preencher(JTable tabela, boolean opcao) {
        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
        
        for(int i = 0; i < modelo.getRowCount(); i++) {
            modelo.setValueAt(opcao, i, 0);
        }
    }
    
    private void enviar() {
        Notificacao notificacao = new Notificacao(view.getTxtMensagem().getText());
        List<Usuario> usuarios = new ArrayList<>();
        
        DefaultTableModel modelo = (DefaultTableModel) view.getTblUsuarios().getModel();
        for(int i = 0; i < modelo.getRowCount(); i++) {
            if((boolean) modelo.getValueAt(i, 0)) {
                String nome = modelo.getValueAt(i, 1).toString();
                usuarios.add(this.usuarios.buscarUsuario(nome));
            }
        }
        
        notificacaoService.EnviarNotificacao(usuarios, notificacao);
    }
    
    private void cancelar() {
        view.dispose();
    }
}
