/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.pss.criacaomanutencaousuarios.view;

import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
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
        btnNotificacoes = new javax.swing.JButton();
        mnbSistema = new javax.swing.JMenuBar();
        mnuUsuario = new javax.swing.JMenu();
        mitTrocarDeUsuario = new javax.swing.JMenuItem();
        mitTrocarSenha = new javax.swing.JMenuItem();
        mitAutenticarUsuarios = new javax.swing.JMenuItem();
        mitPromoverUsuario = new javax.swing.JMenuItem();
        mitRebaixarUsuario = new javax.swing.JMenuItem();
        mitCriarUsuario = new javax.swing.JMenuItem();
        mitExcluirUsuario = new javax.swing.JMenuItem();
        mnuNotificacoes = new javax.swing.JMenu();
        mitVisualizarNotificacoes = new javax.swing.JMenuItem();
        mitEnviarNotificacoes = new javax.swing.JMenuItem();
        mnuSistema = new javax.swing.JMenu();
        mitCSV = new javax.swing.JMenuItem();
        mitJSON = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblIdentificacaoUsuario.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblIdentificacaoUsuario.setText("Aguardando login");
        lblIdentificacaoUsuario.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        btnNotificacoes.setBackground(new java.awt.Color(204, 204, 204));

        mnuUsuario.setText("Usuário");

        mitTrocarDeUsuario.setText("Desconectar Usuario");
        mnuUsuario.add(mitTrocarDeUsuario);
        mitTrocarDeUsuario.getAccessibleContext().setAccessibleName("Alterar ");

        mitTrocarSenha.setLabel("Trocar Senha");
        mnuUsuario.add(mitTrocarSenha);

        mitAutenticarUsuarios.setText("Autenticar Usuarios");
        mnuUsuario.add(mitAutenticarUsuarios);

        mitPromoverUsuario.setText("Promover Usuario");
        mnuUsuario.add(mitPromoverUsuario);

        mitRebaixarUsuario.setText("Rebaixar Usuario");
        mnuUsuario.add(mitRebaixarUsuario);

        mitCriarUsuario.setText("Criar Usuario");
        mnuUsuario.add(mitCriarUsuario);

        mitExcluirUsuario.setText("Excluir Usuario");
        mnuUsuario.add(mitExcluirUsuario);

        mnbSistema.add(mnuUsuario);

        mnuNotificacoes.setText("Notificações");

        mitVisualizarNotificacoes.setText("Visualizar notificações");
        mnuNotificacoes.add(mitVisualizarNotificacoes);

        mitEnviarNotificacoes.setText("Enviar notificações");
        mnuNotificacoes.add(mitEnviarNotificacoes);

        mnbSistema.add(mnuNotificacoes);

        mnuSistema.setText("Sistema");

        mitCSV.setText("Definir Log como CSV");
        mnuSistema.add(mitCSV);

        mitJSON.setText("Definir Log como JSON");
        mnuSistema.add(mitJSON);

        mnbSistema.add(mnuSistema);

        setJMenuBar(mnbSistema);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(456, Short.MAX_VALUE)
                .addComponent(lblIdentificacaoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(btnNotificacoes, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(727, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnNotificacoes, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblIdentificacaoUsuario))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNotificacoes;
    private javax.swing.JLabel lblIdentificacaoUsuario;
    private javax.swing.JMenuItem mitAutenticarUsuarios;
    private javax.swing.JMenuItem mitCSV;
    private javax.swing.JMenuItem mitCriarUsuario;
    private javax.swing.JMenuItem mitEnviarNotificacoes;
    private javax.swing.JMenuItem mitExcluirUsuario;
    private javax.swing.JMenuItem mitJSON;
    private javax.swing.JMenuItem mitPromoverUsuario;
    private javax.swing.JMenuItem mitRebaixarUsuario;
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
    public JMenuItem getMitAutenticarUsuarios() {
        return mitAutenticarUsuarios;
    }

    public JMenuItem getMitPromoverUsuario() {
        return mitPromoverUsuario;
    }
    public JMenuItem getMitCSV() {
        return mitCSV;
    }

    public JMenuItem getMitExcluirUsuario() {
        return mitExcluirUsuario;
    }

    public JMenuItem getMitJSON() {
        return mitJSON;
    }

    public JMenu getMnuSistema() {
        return mnuSistema;
    }

    public JButton getBtnNotificacoes() {
        return btnNotificacoes;
    }

    public JMenuItem getMitCriarUsuario() {
        return mitCriarUsuario;
    }

    public JMenuItem getMitRebaixarUsuario() {
        return mitRebaixarUsuario;
    }
}
