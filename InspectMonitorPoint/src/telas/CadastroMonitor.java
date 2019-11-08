package telas;

import aluno.Aluno;
import aluno.AlunoDAO;
import aluno.AlunoTableModel;
import curso.Curso;
import curso.CursoDAO;
import curso.CursoTableModel;
import disciplina.Disciplina;
import disciplina.DisciplinaDAO;
import disciplina.DisciplinaTableModel;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import monitor.Monitor;
import monitor.MonitorDAO;
import monitor.MonitorTableModel;
import professor.Professor;
import professor.ProfessorDAO;
import professor.ProfessorTableModel;

/**
 *
 * @author Alisson
 */
public class CadastroMonitor extends javax.swing.JFrame {
    List<Monitor> listaMonitores = new ArrayList<>();
    Monitor monitor = new Monitor();
    MonitorDAO monitorDAO = new MonitorDAO();
    
    Aluno aluno = new Aluno();
    AlunoDAO alunoDAO = new AlunoDAO();
    
    Professor professor = new Professor();
    ProfessorDAO professorDAO = new ProfessorDAO();
    
    Curso curso = new Curso();
    CursoDAO cursoDAO = new CursoDAO();
    
    List<Disciplina> listaDisciplinas = new ArrayList<>();
    Disciplina disciplina = new Disciplina();
    DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
    
    public CadastroMonitor() {
        initComponents();
    }

    public void limparCampos(){
        lbAluno.setText("SELECIONE UM ALUNO...");
        lbProfessor.setText("SELECIONE UM PROFESSOR...");
        lbCurso.setText("SELECIONE UM CURSO...");
        lbDisciplina.setText("SELECIONE UMA DISCIPLINA");
        aluno = new Aluno();
        professor = new Professor();
        curso = new Curso();
        disciplina = new Disciplina();
        monitor = new Monitor();
    }
    
    public boolean isAlunoMonitor(){
        listaMonitores = monitorDAO.listar();
        for (Monitor monitor : listaMonitores) {
            if(monitor.getAluno().getId() == aluno.getId()){
                return true;
            }
        }
        return false;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lbAluno = new javax.swing.JLabel();
        lbProfessor = new javax.swing.JLabel();
        lbCurso = new javax.swing.JLabel();
        lbDisciplina = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        btnAddProf = new javax.swing.JButton();
        btnAddAluno = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        btnAddCurso = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        btnAddDisciplina = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnPesquisar = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        btnLimpar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Logo.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 20, 110, 80));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 0, 100, 90));

        lbAluno.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lbAluno.setText("SELECIONE UM ALUNO...");
        getContentPane().add(lbAluno, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 268, 540, 35));

        lbProfessor.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lbProfessor.setText("SELECIONE UM PROFESSOR...");
        getContentPane().add(lbProfessor, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 315, 540, 35));

        lbCurso.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lbCurso.setText("SELECIONE UM CURSO...");
        getContentPane().add(lbCurso, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 360, 540, 35));

        lbDisciplina.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lbDisciplina.setText("SELECIONE UMA DISCIPLINA...");
        getContentPane().add(lbDisciplina, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 410, 540, 35));

        jButton1.setToolTipText("");
        jButton1.setBorder(null);
        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(706, 314, 36, 36));

        btnAddProf.setContentAreaFilled(false);
        btnAddProf.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnAddProf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddProfActionPerformed(evt);
            }
        });
        getContentPane().add(btnAddProf, new org.netbeans.lib.awtextra.AbsoluteConstraints(755, 314, 36, 36));

        btnAddAluno.setBorder(null);
        btnAddAluno.setContentAreaFilled(false);
        btnAddAluno.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnAddAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddAlunoActionPerformed(evt);
            }
        });
        getContentPane().add(btnAddAluno, new org.netbeans.lib.awtextra.AbsoluteConstraints(755, 267, 36, 36));

        jButton4.setBorder(null);
        jButton4.setContentAreaFilled(false);
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(706, 267, 36, 36));

        btnAddCurso.setBorder(null);
        btnAddCurso.setContentAreaFilled(false);
        btnAddCurso.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnAddCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddCursoActionPerformed(evt);
            }
        });
        getContentPane().add(btnAddCurso, new org.netbeans.lib.awtextra.AbsoluteConstraints(755, 362, 36, 36));

        jButton6.setContentAreaFilled(false);
        jButton6.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(706, 361, 36, 36));

        btnAddDisciplina.setBorder(null);
        btnAddDisciplina.setContentAreaFilled(false);
        btnAddDisciplina.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnAddDisciplina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddDisciplinaActionPerformed(evt);
            }
        });
        getContentPane().add(btnAddDisciplina, new org.netbeans.lib.awtextra.AbsoluteConstraints(755, 408, 36, 36));

        jButton8.setBorder(null);
        jButton8.setContentAreaFilled(false);
        jButton8.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(706, 408, 36, 36));

        btnSalvar.setBorder(null);
        btnSalvar.setContentAreaFilled(false);
        btnSalvar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(707, 499, 120, 40));

        btnExcluir.setBorder(null);
        btnExcluir.setContentAreaFilled(false);
        btnExcluir.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });
        getContentPane().add(btnExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(558, 499, 120, 40));

        btnPesquisar.setBorder(null);
        btnPesquisar.setContentAreaFilled(false);
        btnPesquisar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });
        getContentPane().add(btnPesquisar, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 499, 120, 40));

        btnVoltar.setBorder(null);
        btnVoltar.setContentAreaFilled(false);
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });
        getContentPane().add(btnVoltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 499, 120, 40));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/TelaCadastroMonitor.jpg"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 550));

        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });
        getContentPane().add(btnLimpar, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 500, 120, 40));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        
        if(!lbAluno.getText().equals("SELECIONE UM ALUNO...") && !lbProfessor.getText().equals("SELECIONE UM PROFESSOR...") && !lbCurso.getText().equals("SELECIONE UM CURSO...") && !lbDisciplina.getText().equals("SELECIONE UMA DISCIPLINA")){
            if(!isAlunoMonitor()){
                monitor.setAluno(aluno);
                monitor.setProfessor(professor);
                monitor.setCurso(curso);
                monitor.setDisciplina(disciplina);
                monitor.setAtivo(true);
                monitorDAO.salvar(monitor);
                limparCampos();
            }else{
                JOptionPane.showMessageDialog(null, "Este aluno já é monitor");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Verifique se não existe nenhum campo vazio!");
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        List<Aluno> lista = alunoDAO.listar();
        AlunoTableModel model = new AlunoTableModel(lista);
        Object objetoRetorno = PesquisaGenerica.exibeTela(model, "Aluno");
        if(objetoRetorno != null){
            aluno = alunoDAO.consultarObjetoId("id", objetoRetorno);
            lbAluno.setText(aluno.getNome());
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        List<Professor> lista = professorDAO.listar();
        ProfessorTableModel model = new ProfessorTableModel(lista);
        Object objetoRetorno = PesquisaGenerica.exibeTela(model, "Professor");
        if(objetoRetorno != null){
            professor = professorDAO.consultarObjetoId("id", objetoRetorno);
            lbProfessor.setText(professor.getNome());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        List<Curso> lista = cursoDAO.listar();
        CursoTableModel model = new CursoTableModel(lista);
        Object objetoRetorno = PesquisaGenerica.exibeTela(model, "Curso");
        if(objetoRetorno != null){
            curso = cursoDAO.consultarObjetoId("id", objetoRetorno);
            lbCurso.setText(curso.getNome());
            
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        if(curso.getId() != 0){
            List<Disciplina> lista = disciplinaDAO.listar();
            List<Disciplina> listaFiltrada = new ArrayList<>();

            for (Disciplina disciplina : lista) {
                if(disciplina.getCurso().getId() == curso.getId()){
                    listaFiltrada.add(disciplina);
                }
            }
            
            DisciplinaTableModel model = new DisciplinaTableModel(listaFiltrada);
            Object objetoRetorno = PesquisaGenerica.exibeTela(model, "Disciplina");
            if(objetoRetorno != null){
                disciplina = disciplinaDAO.consultarObjetoId("id", objetoRetorno);
                lbDisciplina.setText(disciplina.getNome());
            }
        }else{
            JOptionPane.showMessageDialog(null, "Selecione um Curso antes");
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        List<Monitor> lista = monitorDAO.listar();
        MonitorTableModel model = new MonitorTableModel(lista);
        Object objetoRetorno = PesquisaGenerica.exibeTela(model, "Monitor");
        if(objetoRetorno != null){
            monitor = monitorDAO.consultarObjetoId("id", objetoRetorno);
            lbAluno.setText(monitor.getAluno().getNome());
            lbProfessor.setText(monitor.getProfessor().getNome());
            lbCurso.setText(monitor.getCurso().getNome());
            lbDisciplina.setText(monitor.getDisciplina().getNome());
        }
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void btnAddAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddAlunoActionPerformed
        CadastroAluno frame = new CadastroAluno();
        frame.setVisible(true);
    }//GEN-LAST:event_btnAddAlunoActionPerformed

    private void btnAddProfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddProfActionPerformed
        CadastroProfessor frame = new CadastroProfessor();
        frame.setVisible(true);
    }//GEN-LAST:event_btnAddProfActionPerformed

    private void btnAddCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddCursoActionPerformed
        CadastroCurso frame = new CadastroCurso();
        frame.setVisible(true);
    }//GEN-LAST:event_btnAddCursoActionPerformed

    private void btnAddDisciplinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddDisciplinaActionPerformed
        CadastroDisciplina frame = new CadastroDisciplina();
        frame.setVisible(true);
    }//GEN-LAST:event_btnAddDisciplinaActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
          Object[] options = {"Sim", "Não"};
        if (monitor.getId()!= 0) {
            if (JOptionPane.showOptionDialog(rootPane, "Deseja excluir o(a) monitor(a) " + monitor.getAluno().getNome()
                    + "?", "InspectMonitorPoint", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]) == JOptionPane.YES_OPTION) {
                if (monitorDAO.remover(monitor)) {
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Não foi possível excluir o(a) monitor(a) " + monitor.getAluno().getNome(),
                            "Erro ao Excluir", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "A exclusão foi cancelada!");
            }
        limparCampos();
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        limparCampos();
    }//GEN-LAST:event_btnLimparActionPerformed

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
    private javax.swing.JButton btnAddAluno;
    private javax.swing.JButton btnAddCurso;
    private javax.swing.JButton btnAddDisciplina;
    private javax.swing.JButton btnAddProf;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbAluno;
    private javax.swing.JLabel lbCurso;
    private javax.swing.JLabel lbDisciplina;
    private javax.swing.JLabel lbProfessor;
    // End of variables declaration//GEN-END:variables
}
