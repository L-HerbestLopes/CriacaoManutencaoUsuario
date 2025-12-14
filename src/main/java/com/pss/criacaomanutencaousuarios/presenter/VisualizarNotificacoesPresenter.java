package com.pss.criacaomanutencaousuarios.presenter;

import com.css.criacaomanutencaousuarios.service.NotificacaoUsuarioService;
import com.pss.criacaomanutencaousuarios.model.NotificacaoUsuario;
import com.pss.criacaomanutencaousuarios.repository.NotificacaoUsuarioRepository;
import com.pss.criacaomanutencaousuarios.model.Usuario;
import com.pss.criacaomanutencaousuarios.view.VisualizarNotificacoesView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JInternalFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * @author André Tavares Louzada, Lucas Herbest Lopes e Yuri Sousa Almeida
 */
public class VisualizarNotificacoesPresenter implements JanelaPresenter {
    private VisualizarNotificacoesView view;
    private Usuario usuario;
    private NotificacaoUsuarioRepository notificacoes;
    private NotificacaoUsuarioService notificacaoService;

    public VisualizarNotificacoesPresenter(Usuario usuario, NotificacaoUsuarioRepository notificacoes) {
        this.usuario = usuario;
        this.notificacoes = notificacoes;
        notificacaoService = new NotificacaoUsuarioService();
        view = new VisualizarNotificacoesView();
        
        configuraView();
    }

    @Override
    public JInternalFrame getView() {
        return view;
    }
    
    private void configuraView() {
        carregarNotificacoes(view.getTblNotificacoes());
        
        view.getBtnMarcarTodas().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel modelo = (DefaultTableModel) view.getTblNotificacoes().getModel();
                
                for(int i = 0; i < modelo.getRowCount(); i++) {
                    modelo.setValueAt(true, i, 1);
                }
            }
        });
        
        view.getBtnConcluir().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel modelo = (DefaultTableModel) view.getTblNotificacoes().getModel();
                List<NotificacaoUsuario> notificacoesCarregadas = notificacaoService.getNotificacoes(usuario, notificacoes);

                for(int i = 0; i < modelo.getRowCount(); i++) {
                    boolean isSelected = (boolean) modelo.getValueAt(i, 1);

                    if (isSelected) {
                         String mensagemTabela = (String) modelo.getValueAt(i, 0);

                         for(NotificacaoUsuario notificacao : notificacoesCarregadas) {
                            if(mensagemTabela.equals(notificacao.getNotificacao().getMessage())) {

                                notificacao.marcarLida();
                                notificacoes.atualizarNotificacaoUsuario(notificacao);
                            }
                        }
                    }
                }
                view.dispose();
            }
        });
        
        view.setVisible(true);
    }
    
    private void carregarNotificacoes(JTable tabela) {
        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
        modelo.setRowCount(0);
        
        List<NotificacaoUsuario> notificacoes = notificacaoService.getNotificacoes(usuario, this.notificacoes);
        
        for(NotificacaoUsuario notificacao : notificacoes) {
            if(!notificacao.foiLida())
            modelo.addRow(new Object[] {
                notificacao.getNotificacao().getMessage(), false
            });
        }
    }
}
