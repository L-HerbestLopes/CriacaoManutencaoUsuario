
package com.pss.sistemanotificacaoprojetos.presenter;

import com.pss.sistemanotificacaoprojetos.view.FormularioUsuarioView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JInternalFrame;

/**
 * @author André Tavares Louzada, Lucas Herbest Lopes e Yuri Sousa Almeida
 */
public class FormularioUsuarioPresenter implements JanelaPresenter {
    private FormularioUsuarioView view;
    
    public FormularioUsuarioPresenter(String titulo) {
        view = new FormularioUsuarioView(titulo);
        
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
                    cancelar();
                } catch(Exception ex) {
                    // lidar e registrar erro aqui...
                }
            }
        });
        
        view.getBtnConfirmar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    confirmar();
                } catch(Exception ex) {
                    // lidar e registrar erro aqui...
                }
            }
        });
        
        view.setVisible(true);
    }
    
    private void cancelar() {
        
    }
    
    private void confirmar() {
        System.out.println(view.getTxtNome());
    }
}
