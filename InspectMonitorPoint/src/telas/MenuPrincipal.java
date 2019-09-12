/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package telas;

/**
 *
 * @author Everton
 */
public class MenuPrincipal extends javax.swing.JFrame {
    
    private boolean seVisivelPainelCadastro;
    private boolean seVisivelPainelBiometria;
    private boolean seVisivelPainelRelatorio;
   
    public MenuPrincipal() {
        initComponents();
        panelBotaoCadastro.setVisible(false);
        panelBotaoBiometria.setVisible(false);
        panelBotaoRelatorio.setVisible(false);
        seVisivelPainelCadastro = false;
        seVisivelPainelBiometria = false;
        seVisivelPainelRelatorio = false;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCadastroMenu = new javax.swing.JButton();
        btnBiometriaMenu = new javax.swing.JButton();
        btnRelatorioMenu = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        panelBotaoRelatorio = new javax.swing.JPanel();
        btnCadastrarMonitorMenu2 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        panelBotaoBiometria = new javax.swing.JPanel();
        btnCadastrarMonitorMenu1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        panelBotaoCadastro = new javax.swing.JPanel();
        btnCadastrarMonitorMenu = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        backgroundMenuPrincipal = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCadastroMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botaocadastro.png"))); // NOI18N
        btnCadastroMenu.setBorder(null);
        btnCadastroMenu.setBorderPainted(false);
        btnCadastroMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCadastroMenu.setFocusPainted(false);
        btnCadastroMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCadastroMenuMouseEntered(evt);
            }
        });
        btnCadastroMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastroMenuActionPerformed(evt);
            }
        });
        getContentPane().add(btnCadastroMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 175, -1, -1));

        btnBiometriaMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botaobiometria.png"))); // NOI18N
        btnBiometriaMenu.setBorder(null);
        btnBiometriaMenu.setBorderPainted(false);
        btnBiometriaMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBiometriaMenu.setFocusPainted(false);
        btnBiometriaMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnBiometriaMenuMouseEntered(evt);
            }
        });
        btnBiometriaMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBiometriaMenuActionPerformed(evt);
            }
        });
        getContentPane().add(btnBiometriaMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(493, 175, -1, -1));

        btnRelatorioMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botaorelatorio.png"))); // NOI18N
        btnRelatorioMenu.setBorder(null);
        btnRelatorioMenu.setBorderPainted(false);
        btnRelatorioMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRelatorioMenu.setFocusPainted(false);
        btnRelatorioMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnRelatorioMenuMouseEntered(evt);
            }
        });
        btnRelatorioMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRelatorioMenuActionPerformed(evt);
            }
        });
        getContentPane().add(btnRelatorioMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 175, -1, -1));

        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botaosair.png"))); // NOI18N
        jButton11.setBorder(null);
        jButton11.setContentAreaFilled(false);
        jButton11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 503, -1, -1));

        panelBotaoRelatorio.setBackground(new java.awt.Color(255, 255, 255));
        panelBotaoRelatorio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelBotaoRelatorio.setPreferredSize(new java.awt.Dimension(148, 120));
        panelBotaoRelatorio.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCadastrarMonitorMenu2.setText("Cadastrar Monitor");
        btnCadastrarMonitorMenu2.setBorder(null);
        btnCadastrarMonitorMenu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarMonitorMenu2ActionPerformed(evt);
            }
        });
        panelBotaoRelatorio.add(btnCadastrarMonitorMenu2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 147, 30));

        jButton6.setText("Cadastrar Professor");
        jButton6.setBorder(null);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        panelBotaoRelatorio.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 147, 30));

        jButton7.setText("Cadastrar Curso");
        jButton7.setBorder(null);
        panelBotaoRelatorio.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 147, 30));

        getContentPane().add(panelBotaoRelatorio, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 180, 149, 135));

        panelBotaoBiometria.setBackground(new java.awt.Color(255, 255, 255));
        panelBotaoBiometria.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelBotaoBiometria.setPreferredSize(new java.awt.Dimension(148, 120));
        panelBotaoBiometria.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCadastrarMonitorMenu1.setText("Cadastrar Monitor");
        btnCadastrarMonitorMenu1.setBorder(null);
        btnCadastrarMonitorMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarMonitorMenu1ActionPerformed(evt);
            }
        });
        panelBotaoBiometria.add(btnCadastrarMonitorMenu1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 147, 30));

        jButton4.setText("Cadastrar Professor");
        jButton4.setBorder(null);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        panelBotaoBiometria.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 147, 30));

        jButton5.setText("Cadastrar Curso");
        jButton5.setBorder(null);
        panelBotaoBiometria.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 147, 30));

        getContentPane().add(panelBotaoBiometria, new org.netbeans.lib.awtextra.AbsoluteConstraints(493, 180, 149, 135));

        panelBotaoCadastro.setBackground(new java.awt.Color(255, 255, 255));
        panelBotaoCadastro.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelBotaoCadastro.setPreferredSize(new java.awt.Dimension(148, 120));
        panelBotaoCadastro.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCadastrarMonitorMenu.setText("Cadastrar Monitor");
        btnCadastrarMonitorMenu.setBorder(null);
        btnCadastrarMonitorMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarMonitorMenuActionPerformed(evt);
            }
        });
        panelBotaoCadastro.add(btnCadastrarMonitorMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 147, 30));

        jButton2.setText("Cadastrar Professor");
        jButton2.setBorder(null);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        panelBotaoCadastro.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 147, 30));

        jButton3.setText("Cadastrar Curso");
        jButton3.setBorder(null);
        panelBotaoCadastro.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 147, 30));

        getContentPane().add(panelBotaoCadastro, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 180, 149, 135));

        backgroundMenuPrincipal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/backgroundmenuprincipal.jpg"))); // NOI18N
        backgroundMenuPrincipal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backgroundMenuPrincipalMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                backgroundMenuPrincipalMouseEntered(evt);
            }
        });
        getContentPane().add(backgroundMenuPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastroMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastroMenuActionPerformed
        if(seVisivelPainelCadastro){
            panelBotaoCadastro.setVisible(false);
            seVisivelPainelCadastro = false;
        }else{
            panelBotaoCadastro.setVisible(true);
            seVisivelPainelCadastro = true;
        }
    }//GEN-LAST:event_btnCadastroMenuActionPerformed

    private void backgroundMenuPrincipalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backgroundMenuPrincipalMouseClicked
        panelBotaoCadastro.setVisible(false);
        seVisivelPainelCadastro = false;
        panelBotaoBiometria.setVisible(false);
        seVisivelPainelBiometria = false;
        panelBotaoRelatorio.setVisible(false);
        seVisivelPainelRelatorio = false;
    }//GEN-LAST:event_backgroundMenuPrincipalMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnBiometriaMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBiometriaMenuActionPerformed
        if(seVisivelPainelBiometria){
            panelBotaoBiometria.setVisible(false);
            seVisivelPainelBiometria = false;
        } else{
            panelBotaoBiometria.setVisible(true);
            seVisivelPainelBiometria = true;
        }
    }//GEN-LAST:event_btnBiometriaMenuActionPerformed

    private void btnRelatorioMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRelatorioMenuActionPerformed
        if(seVisivelPainelRelatorio){
            panelBotaoRelatorio.setVisible(false);
            seVisivelPainelRelatorio = false;
        } else{
            panelBotaoRelatorio.setVisible(true);
            seVisivelPainelRelatorio = true;
        }
    }//GEN-LAST:event_btnRelatorioMenuActionPerformed

    private void btnCadastrarMonitorMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarMonitorMenuActionPerformed
        CadastroMonitor frame = new CadastroMonitor();
        frame.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnCadastrarMonitorMenuActionPerformed

    private void btnCadastroMenuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCadastroMenuMouseEntered
        panelBotaoCadastro.setVisible(true);
        panelBotaoBiometria.setVisible(false);
        panelBotaoRelatorio.setVisible(false);
    }//GEN-LAST:event_btnCadastroMenuMouseEntered

    private void btnBiometriaMenuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBiometriaMenuMouseEntered
        panelBotaoBiometria.setVisible(true);
        panelBotaoCadastro.setVisible(false);
        panelBotaoRelatorio.setVisible(false);
    }//GEN-LAST:event_btnBiometriaMenuMouseEntered

    private void btnRelatorioMenuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRelatorioMenuMouseEntered
        panelBotaoRelatorio.setVisible(true);
        panelBotaoCadastro.setVisible(false);
        panelBotaoBiometria.setVisible(false);
    }//GEN-LAST:event_btnRelatorioMenuMouseEntered

    private void backgroundMenuPrincipalMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backgroundMenuPrincipalMouseEntered
        panelBotaoRelatorio.setVisible(false);
        panelBotaoCadastro.setVisible(false);
        panelBotaoBiometria.setVisible(false);
    }//GEN-LAST:event_backgroundMenuPrincipalMouseEntered

    private void btnCadastrarMonitorMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarMonitorMenu1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCadastrarMonitorMenu1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void btnCadastrarMonitorMenu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarMonitorMenu2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCadastrarMonitorMenu2ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

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
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel backgroundMenuPrincipal;
    private javax.swing.JButton btnBiometriaMenu;
    private javax.swing.JButton btnCadastrarMonitorMenu;
    private javax.swing.JButton btnCadastrarMonitorMenu1;
    private javax.swing.JButton btnCadastrarMonitorMenu2;
    private javax.swing.JButton btnCadastroMenu;
    private javax.swing.JButton btnRelatorioMenu;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JPanel panelBotaoBiometria;
    private javax.swing.JPanel panelBotaoCadastro;
    private javax.swing.JPanel panelBotaoRelatorio;
    // End of variables declaration//GEN-END:variables

}
