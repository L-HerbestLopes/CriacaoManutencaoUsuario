/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.pss.criacaomanutencaousuarios.view;

import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;

/**
 * @author André Tavares Louzada, Lucas Herbest Lopes e Yuri Sousa Almeida
 */
public class SistemaView extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(SistemaView.class.getName());

    public SistemaView() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblIdentificacaoUsuario = new javax.swing.JLabel();
        mnbSistema = new javax.swing.JMenuBar();
        mnuUsuario = new javax.swing.JMenu();
        mitTrocarDeUsuario = new javax.swing.JMenuItem();
        mitTrocarSenha = new javax.swing.JMenuItem();
        mnuNotificacoes = new javax.swing.JMenu();
        mitVisualizarNotificacoes = new javax.swing.JMenuItem();
        mitEnviarNotificacoes = new javax.swing.JMenuItem();
        mnuSistema = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblIdentificacaoUsuario.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblIdentificacaoUsuario.setText("Aguardando login");
        lblIdentificacaoUsuario.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        mnuUsuario.setText("Usuário");

        mitTrocarDeUsuario.setText("Desconectar Usuario");
        mnuUsuario.add(mitTrocarDeUsuario);
        mitTrocarDeUsuario.getAccessibleContext().setAccessibleName("Alterar ");

        mitTrocarSenha.setLabel("Trocar Senha");
        mnuUsuario.add(mitTrocarSenha);

        mnbSistema.add(mnuUsuario);

        mnuNotificacoes.setText("Notificações");

        mitVisualizarNotificacoes.setText("Visualizar notificações");
        mnuNotificacoes.add(mitVisualizarNotificacoes);

        mitEnviarNotificacoes.setText("Enviar notificações");
        mnuNotificacoes.add(mitEnviarNotificacoes);

        mnbSistema.add(mnuNotificacoes);

        mnuSistema.setText("Sistema");
        mnbSistema.add(mnuSistema);

        setJMenuBar(mnbSistema);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(650, Short.MAX_VALUE)
                .addComponent(lblIdentificacaoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(733, Short.MAX_VALUE)
                .addComponent(lblIdentificacaoUsuario)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblIdentificacaoUsuario;
    private javax.swing.JMenuItem mitEnviarNotificacoes;
    private javax.swing.JMenuItem mitTrocarDeUsuario;
    private javax.swing.JMenuItem mitTrocarSenha;
    private javax.swing.JMenuItem mitVisualizarNotificacoes;
    private javax.swing.JMenuBar mnbSistema;
    private javax.swing.JMenu mnuNotificacoes;
    private javax.swing.JMenu mnuSistema;
    private javax.swing.JMenu mnuUsuario;
    // End of variables declaration//GEN-END:variables

    public JMenuItem getMitEnviarNotificacoes() {
        return mitEnviarNotificacoes;
    }

    public JMenuItem getMitVisualizarNotificacoes() {
        return mitVisualizarNotificacoes;
    }

    public JMenuBar getMnbSistema() {
        return mnbSistema;
    }

    public JLabel getLblIdentificacaoUsuario() {
        return lblIdentificacaoUsuario;
    }

    public JMenuItem getMitTrocarDeUsuario() {
        return mitTrocarDeUsuario;
    }

    public JMenuItem getMitTrocarSenha() {
        return mitTrocarSenha;
    }

}
