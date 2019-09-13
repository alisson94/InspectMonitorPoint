/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import curso.Curso;
import curso.CursoDAO;
import curso.CursoTableModel;
import java.util.List;
import javax.swing.JOptionPane;
import professor.Professor;
import professor.ProfessorDAO;
import professor.ProfessorTableModel;

/**
 *
 * @author Alisson
 */
public class CadastroProfessor extends javax.swing.JFrame {
    
    Professor professor = new Professor();
    ProfessorDAO professorDAO = new ProfessorDAO();
    
    CursoDAO cursoDAO = new CursoDAO();
    /**
     * Creates new form CadastroProfessor
     */
    public CadastroProfessor() {
        initComponents();
        
    }

    public void limparCampos() {
        tfNome.setText("");
        tfEmail.setText("");
        tfCpf.setText("");
        tfTelefone.setText("");
        professor = new Professor();
    }
            
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tfNome = new javax.swing.JTextField();
        btnSalvarProfessor = new javax.swing.JButton();
        tfCpf = new javax.swing.JFormattedTextField();
        tfEmail = new javax.swing.JTextField();
        btnPesquisar = new javax.swing.JButton();
        tfTelefone = new javax.swing.JFormattedTextField();
        btnExcluir = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tfNome.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        tfNome.setBorder(null);
        getContentPane().add(tfNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 258, 410, 35));

        btnSalvarProfessor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botaosalvarpequeno.png"))); // NOI18N
        btnSalvarProfessor.setBorder(null);
        btnSalvarProfessor.setContentAreaFilled(false);
        btnSalvarProfessor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarProfessorActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalvarProfessor, new org.netbeans.lib.awtextra.AbsoluteConstraints(493, 438, -1, -1));

        tfCpf.setBorder(null);
        try {
            tfCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tfCpf.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        getContentPane().add(tfCpf, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 350, 160, 35));

        tfEmail.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        tfEmail.setBorder(null);
        getContentPane().add(tfEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 305, 460, 35));

        btnPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botaolupa.png"))); // NOI18N
        btnPesquisar.setBorder(null);
        btnPesquisar.setBorderPainted(false);
        btnPesquisar.setContentAreaFilled(false);
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });
        getContentPane().add(btnPesquisar, new org.netbeans.lib.awtextra.AbsoluteConstraints(554, 254, -1, -1));

        tfTelefone.setBorder(null);
        try {
            tfTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) # ####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tfTelefone.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        getContentPane().add(tfTelefone, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 350, 180, 35));

        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botaoexcluirpequeno.png"))); // NOI18N
        btnExcluir.setBorder(null);
        btnExcluir.setContentAreaFilled(false);
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });
        getContentPane().add(btnExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 438, -1, 30));

        btnVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botaovoltarpequeno.png"))); // NOI18N
        btnVoltar.setBorder(null);
        btnVoltar.setContentAreaFilled(false);
        getContentPane().add(btnVoltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 438, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/backgroundcadastroprofessor.jpg"))); // NOI18N
        jLabel2.setPreferredSize(new java.awt.Dimension(615, 488));
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarProfessorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarProfessorActionPerformed
        if(!tfNome.getText().equals("") && !tfCpf.getText().equals("   .   .   -  ") && !tfTelefone.getText().equals("(  )     -    ")) {
            professor.setNome(tfNome.getText());
            professor.setEmail(tfEmail.getText());
            professor.setCpf(tfCpf.getText());
            professor.setTelefone(tfTelefone.getText());
            professorDAO.salvar(professor);
            limparCampos();
        } else {
            JOptionPane.showMessageDialog(null, "Verifique se não existe nenhum campo vazio!");
        }
    }//GEN-LAST:event_btnSalvarProfessorActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        List<Professor> lista = professorDAO.listar();
        ProfessorTableModel model = new ProfessorTableModel(lista);
        Object objetoRetorno = PesquisaGenerica.exibeTela(model, "Professor");
        if(objetoRetorno != null){
            professor = professorDAO.consultarObjetoId("id", objetoRetorno);
            tfNome.setText(professor.getNome());
            tfEmail.setText(professor.getEmail());
            tfCpf.setText(professor.getCpf());
            tfTelefone.setText(professor.getTelefone());
        }
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
         Object[] options = {"Sim", "Não"};
        if (professor.getId()!= 0) {
            if (JOptionPane.showOptionDialog(rootPane, "Deseja excluir o(a) professor(a) " + professor.getNome()
                    + "?", "InspectMonitorPoint", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]) == JOptionPane.YES_OPTION) {
                if (professorDAO.remover(professor)) {
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Não foi possível excluir o(a) professor(a) " + professor.getNome(),
                            "Erro ao Excluir", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "A exclusão foi cancelada!");
            }
        limparCampos();
        }
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
            java.util.logging.Logger.getLogger(CadastroProfessor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroProfessor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroProfessor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroProfessor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroProfessor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnSalvarProfessor;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JFormattedTextField tfCpf;
    private javax.swing.JTextField tfEmail;
    private javax.swing.JTextField tfNome;
    private javax.swing.JFormattedTextField tfTelefone;
    // End of variables declaration//GEN-END:variables
}
