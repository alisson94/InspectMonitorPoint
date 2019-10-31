/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import javax.swing.JOptionPane;
import usuario.Usuario;
import usuario.UsuarioDAO;
import util.Util;

/**
 *
 * @author Everton
 */
public class CadastroUsuario extends javax.swing.JFrame {
    Usuario usuario = new Usuario();
    UsuarioDAO usuarioDAO = new UsuarioDAO();
    
    public CadastroUsuario() {
        initComponents();
        limparCampos();
    }

    public void limparCampos() {
        tfNome.setText("");
        tfUsuario.setText("");
        tfSenha.setText("");
        usuario = new Usuario();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnExcluir = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnPesquisar = new javax.swing.JButton();
        VOLTAR = new javax.swing.JButton();
        tfNome = new javax.swing.JTextField();
        tfUsuario = new javax.swing.JTextField();
        tfSenha = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnExcluir.setBorder(null);
        btnExcluir.setContentAreaFilled(false);
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });
        getContentPane().add(btnExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(375, 434, 100, 30));

        btnSalvar.setBorder(null);
        btnSalvar.setContentAreaFilled(false);
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(494, 434, 100, 30));

        btnPesquisar.setBorder(null);
        btnPesquisar.setContentAreaFilled(false);
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });
        getContentPane().add(btnPesquisar, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 434, 98, 30));

        VOLTAR.setBorder(null);
        VOLTAR.setContentAreaFilled(false);
        VOLTAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VOLTARActionPerformed(evt);
            }
        });
        getContentPane().add(VOLTAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 430, 110, 40));

        tfNome.setBorder(null);
        getContentPane().add(tfNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 254, 460, 35));

        tfUsuario.setBorder(null);
        getContentPane().add(tfUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 355, 330, 38));

        tfSenha.setBorder(null);
        getContentPane().add(tfSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 304, 460, 35));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/TelaCadastroUsuario.jpg"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 610, 480));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if (usuarioDAO.consultarValorRepetido("loginUsuario", tfUsuario.getText()) && usuario.getId() == 0) {
            JOptionPane.showMessageDialog(rootPane, "O usuário '" + tfUsuario.getText() + "' já está sendo utilizado!",
                    "Erro ao salvar", JOptionPane.ERROR_MESSAGE);
        } else {
            if (Util.chkVazio(tfUsuario.getText(), tfNome.getText(), tfSenha.getText())) {
                usuario.setLogin(tfUsuario.getText());
                usuario.setNome(tfNome.getText().toUpperCase());
                usuario.setSenha(tfSenha.getText());
                usuarioDAO.salvar(usuario);
            }
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void VOLTARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VOLTARActionPerformed
        dispose();
    }//GEN-LAST:event_VOLTARActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnExcluirActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CadastroUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton VOLTAR;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField tfNome;
    private javax.swing.JPasswordField tfSenha;
    private javax.swing.JTextField tfUsuario;
    // End of variables declaration//GEN-END:variables
}
