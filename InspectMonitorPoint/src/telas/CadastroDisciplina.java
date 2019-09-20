/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import curso.Curso;
import curso.CursoDAO;
import curso.CursoTableModel;
import disciplina.Disciplina;
import disciplina.DisciplinaDAO;
import disciplina.DisciplinaTableModel;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Alisson
 */
public class CadastroDisciplina extends javax.swing.JFrame {
    
    Disciplina disciplina = new Disciplina();
    DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
    
    Curso curso = new Curso();
    CursoDAO cursoDAO = new CursoDAO();
    /**
     * Creates new form CadastroDisciplina
     */
    public CadastroDisciplina() {
        initComponents();
        
    }
    
    public void limparCampos(){
        tfNome.setText("");
        tfCargaHoraria.setText("");
        lbCurso.setText("");
        disciplina = new Disciplina();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton3 = new javax.swing.JButton();
        tfNome = new javax.swing.JTextField();
        btnExcluirDisciplina = new javax.swing.JButton();
        btnSalvarDisciplina = new javax.swing.JButton();
        btnVoltarDisciplina = new javax.swing.JButton();
        tfCargaHoraria = new javax.swing.JFormattedTextField();
        lbCurso = new javax.swing.JLabel();
        btnPesquisarCurso = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAutoRequestFocus(false);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botaolupa.png"))); // NOI18N
        jButton3.setBorder(null);
        jButton3.setContentAreaFilled(false);
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 430, 40, 40));

        tfNome.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        tfNome.setBorder(null);
        getContentPane().add(tfNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 410, 35));

        btnExcluirDisciplina.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botaoexcluirpequeno.png"))); // NOI18N
        btnExcluirDisciplina.setBorder(null);
        btnExcluirDisciplina.setBorderPainted(false);
        btnExcluirDisciplina.setContentAreaFilled(false);
        btnExcluirDisciplina.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnExcluirDisciplina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirDisciplinaActionPerformed(evt);
            }
        });
        getContentPane().add(btnExcluirDisciplina, new org.netbeans.lib.awtextra.AbsoluteConstraints(368, 436, 105, 34));

        btnSalvarDisciplina.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botaosalvarpequeno.png"))); // NOI18N
        btnSalvarDisciplina.setBorder(null);
        btnSalvarDisciplina.setBorderPainted(false);
        btnSalvarDisciplina.setContentAreaFilled(false);
        btnSalvarDisciplina.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalvarDisciplina.setPreferredSize(new java.awt.Dimension(159, 49));
        btnSalvarDisciplina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarDisciplinaActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalvarDisciplina, new org.netbeans.lib.awtextra.AbsoluteConstraints(491, 434, 105, 34));

        btnVoltarDisciplina.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botaovoltarpequeno.png"))); // NOI18N
        btnVoltarDisciplina.setBorder(null);
        btnVoltarDisciplina.setBorderPainted(false);
        btnVoltarDisciplina.setContentAreaFilled(false);
        btnVoltarDisciplina.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVoltarDisciplina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarDisciplinaActionPerformed(evt);
            }
        });
        getContentPane().add(btnVoltarDisciplina, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 438, -1, -1));

        tfCargaHoraria.setBorder(null);
        tfCargaHoraria.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        tfCargaHoraria.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        getContentPane().add(tfCargaHoraria, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, 170, 35));
        getContentPane().add(lbCurso, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 260, 40, 20));

        btnPesquisarCurso.setText("Pesquisar");
        btnPesquisarCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarCursoActionPerformed(evt);
            }
        });
        getContentPane().add(btnPesquisarCurso, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 260, -1, -1));

        jButton1.setText("Add Curso");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 260, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnExcluirDisciplinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirDisciplinaActionPerformed
 Object[] options = {"Sim", "Não"};
        if (disciplina.getId()!= 0) {
            if (JOptionPane.showOptionDialog(rootPane, "Deseja excluir a " + disciplina.getNome()
                    + "?", "InspectMonitorPoint", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]) == JOptionPane.YES_OPTION) {
                if (disciplinaDAO.remover(disciplina)) {
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Não foi possível excluir a disciplina " + disciplina.getNome(),
                            "Erro ao Excluir", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "A exclusão foi cancelada!");
            }
        limparCampos();
        }
    }//GEN-LAST:event_btnExcluirDisciplinaActionPerformed

    private void btnSalvarDisciplinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarDisciplinaActionPerformed
        if(!tfNome.getText().equals("") && !tfCargaHoraria.getText().equals("") && !lbCurso.getText().equals("")) {
            disciplina.setNome(tfNome.getText());
            disciplina.setCargaHoraria(Integer.parseInt(tfCargaHoraria.getText()));
            disciplina.setCurso(curso);
            disciplinaDAO.salvar(disciplina);
            limparCampos();
        } else {
            JOptionPane.showMessageDialog(null, "Verifique se não existe nenhum campo vazio!");
        }
    }//GEN-LAST:event_btnSalvarDisciplinaActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        List<Disciplina> lista = disciplinaDAO.listar();
        DisciplinaTableModel model = new DisciplinaTableModel(lista);
        Object objetoRetorno = PesquisaGenerica.exibeTela(model, "Disciplina");
        if(objetoRetorno != null){
            disciplina = disciplinaDAO.consultarObjetoId("id", objetoRetorno);
            tfNome.setText(disciplina.getNome());
            tfCargaHoraria.setText(Integer.toString(disciplina.getCargaHoraria()));
            lbCurso.setText(disciplina.getCurso().getNome());
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnPesquisarCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarCursoActionPerformed
        List<Curso> lista = cursoDAO.listar();
        CursoTableModel model = new CursoTableModel(lista);
        Object objetoRetorno = PesquisaGenerica.exibeTela(model, "Curso");
        if(objetoRetorno != null){
            curso = cursoDAO.consultarObjetoId("id", objetoRetorno);
            lbCurso.setText(curso.getNome());
        }
    }//GEN-LAST:event_btnPesquisarCursoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        CadastroCurso tela = new CadastroCurso();
        tela.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnVoltarDisciplinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarDisciplinaActionPerformed
        dispose();
    }//GEN-LAST:event_btnVoltarDisciplinaActionPerformed

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
            java.util.logging.Logger.getLogger(CadastroDisciplina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroDisciplina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroDisciplina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroDisciplina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroDisciplina().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExcluirDisciplina;
    private javax.swing.JButton btnPesquisarCurso;
    private javax.swing.JButton btnSalvarDisciplina;
    private javax.swing.JButton btnVoltarDisciplina;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel lbCurso;
    private javax.swing.JFormattedTextField tfCargaHoraria;
    private javax.swing.JTextField tfNome;
    // End of variables declaration//GEN-END:variables
}
