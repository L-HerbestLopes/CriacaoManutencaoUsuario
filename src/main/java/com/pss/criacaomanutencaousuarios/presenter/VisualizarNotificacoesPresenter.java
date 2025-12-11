package com.pss.criacaomanutencaousuarios.presenter;

import com.pss.criacaomanutencaousuarios.model.NotificacaoUsuario;
import com.pss.criacaomanutencaousuarios.model.NotificacaoUsuarioRepository;
import com.pss.criacaomanutencaousuarios.model.Usuario;
import com.pss.criacaomanutencaousuarios.view.VisualizarNotificacoesView;
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
        
        view.setVisible(true);
    }
    
    private void carregarNotificacoes(JTable tabela) {
        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
        modelo.setRowCount(0);
        
        List<NotificacaoUsuario> notificacoes = notificacaoService.getNotificacoes(usuario, this.notificacoes);
        
        for(NotificacaoUsuario notificacao : notificacoes) {
            modelo.addRow(new Object[] {
                notificacao.getNotificacao().getMessage(), false
            });
        }
    }
}
