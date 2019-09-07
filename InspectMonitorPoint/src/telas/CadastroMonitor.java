/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import javax.swing.JOptionPane;
import monitor.Monitor;
import monitor.MonitorDAO;

/**
 *
 * @author Everton
 */
public class CadastroMonitor extends javax.swing.JFrame {
    
    Monitor monitor = new Monitor();
    MonitorDAO monitorDAO = new MonitorDAO();
    
    /**
     * Creates new form CadastroMonitor
     */
    public CadastroMonitor() {
        initComponents();
    }

    public void limparCampos(){
        tfNome.setText("");
        tfMatricula.setText("");
        tfEmail.setText("");
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tfNome = new javax.swing.JTextField();
        tfMatricula = new javax.swing.JTextField();
        tfEmail = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        tfSemestre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tfNome.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        tfNome.setAlignmentX(10.0F);
        tfNome.setBorder(null);
        tfNome.setMargin(null);
        tfNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNomeActionPerformed(evt);
            }
        });
        getContentPane().add(tfNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 267, 680, 30));

        tfMatricula.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        tfMatricula.setBorder(null);
        getContentPane().add(tfMatricula, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 326, 190, 30));

        tfEmail.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        tfEmail.setBorder(null);
        getContentPane().add(tfEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 326, 370, 30));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botaosalvar.png"))); // NOI18N
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(657, 500, -1, -1));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botaovoltar.png"))); // NOI18N
        jButton2.setBorder(null);
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 500, -1, -1));

        tfSemestre.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        tfSemestre.setAlignmentX(10.0F);
        tfSemestre.setBorder(null);
        tfSemestre.setMargin(null);
        tfSemestre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfSemestreActionPerformed(evt);
            }
        });
        getContentPane().add(tfSemestre, new org.netbeans.lib.awtextra.AbsoluteConstraints(618, 444, 180, 30));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/backgroundcadastromonitor.jpg"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfNomeActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        monitor.setNome(tfNome.getText());
        monitor.setMatricula(Integer.parseInt(tfMatricula.getText()));
        monitor.setEmail(tfEmail.getText());
        limparCampos();
        monitorDAO.salvarMonitor(monitor);
        JOptionPane.showMessageDialog(null, "Monitor cadastrado com sucesso!");

    }//GEN-LAST:event_jButton1ActionPerformed

    private void tfSemestreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfSemestreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfSemestreActionPerformed

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
            java.util.logging.Logger.getLogger(CadastroMonitor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroMonitor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroMonitor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroMonitor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroMonitor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField tfEmail;
    private javax.swing.JTextField tfMatricula;
    private javax.swing.JTextField tfNome;
    private javax.swing.JTextField tfSemestre;
    // End of variables declaration//GEN-END:variables
}
