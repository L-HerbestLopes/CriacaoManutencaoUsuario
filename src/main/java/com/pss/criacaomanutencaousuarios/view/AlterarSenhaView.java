package com.pss.criacaomanutencaousuarios.view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class AlterarSenhaView extends javax.swing.JInternalFrame {

   
    public AlterarSenhaView() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblAlterarSenha = new javax.swing.JLabel();
        lblSenhaAtual = new javax.swing.JLabel();
        lblNovaSenha = new javax.swing.JLabel();
        lblConfirmarSenha = new javax.swing.JLabel();
        txtSenhaAtual = new javax.swing.JTextField();
        txtNovaSenha = new javax.swing.JTextField();
        txtConfirmarSenha = new javax.swing.JTextField();
        btnConfirmar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setClosable(true);

        lblAlterarSenha.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblAlterarSenha.setText("Alterar Senha");

        lblSenhaAtual.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblSenhaAtual.setText("Senha Atual:");

        lblNovaSenha.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblNovaSenha.setText("Nova Senha:");

        lblConfirmarSenha.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblConfirmarSenha.setText("Confirmar Senha:");

        txtSenhaAtual.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        txtNovaSenha.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        txtConfirmarSenha.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        btnConfirmar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnConfirmar.setText("Confirmar");
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(66, 66, 66)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblNovaSenha)
                                    .addGap(33, 33, 33)
                                    .addComponent(txtNovaSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblSenhaAtual)
                                    .addGap(34, 34, 34)
                                    .addComponent(txtSenhaAtual, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(44, 44, 44)
                            .addComponent(lblConfirmarSenha)
                            .addGap(18, 18, 18)
                            .addComponent(txtConfirmarSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(188, 188, 188)
                            .addComponent(lblAlterarSenha)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(64, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(lblAlterarSenha)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSenhaAtual)
                    .addComponent(txtSenhaAtual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNovaSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNovaSenha))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtConfirmarSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblConfirmarSenha))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConfirmar)
                    .addComponent(btnCancelar))
                .addContainerGap(56, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnConfirmarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JLabel lblAlterarSenha;
    private javax.swing.JLabel lblConfirmarSenha;
    private javax.swing.JLabel lblNovaSenha;
    private javax.swing.JLabel lblSenhaAtual;
    private javax.swing.JTextField txtConfirmarSenha;
    private javax.swing.JTextField txtNovaSenha;
    private javax.swing.JTextField txtSenhaAtual;
    // End of variables declaration//GEN-END:variables

    public JButton getBtnCancelar() {
        return btnCancelar;
    }

    public JButton getBtnConfirmar() {
        return btnConfirmar;
    }

    public JLabel getLblAlterarSenha() {
        return lblAlterarSenha;
    }

    public JLabel getLblConfirmarSenha() {
        return lblConfirmarSenha;
    }

    public JLabel getLblNovaSenha() {
        return lblNovaSenha;
    }

    public JLabel getLblSenhaAtual() {
        return lblSenhaAtual;
    }

    public JTextField getTxtConfirmarSenha() {
        return txtConfirmarSenha;
    }

    public JTextField getTxtNovaSenha() {
        return txtNovaSenha;
    }

    public JTextField getTxtSenhaAtual() {
        return txtSenhaAtual;
    }

    public void setTxtSenhaAtual(JTextField txtSenhaAtual) {
        this.txtSenhaAtual = txtSenhaAtual;
    }

}
