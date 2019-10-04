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

    Monitor monitor = new Monitor();
    MonitorDAO monitorDAO = new MonitorDAO();
    
    Aluno aluno = new Aluno();
    AlunoDAO alunoDAO = new AlunoDAO();
    Professor professor = new Professor();
    ProfessorDAO professorDAO = new ProfessorDAO();
    Curso curso = new Curso();
    CursoDAO cursoDAO = new CursoDAO();
    Disciplina disciplina = new Disciplina();
    DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
    
    public CadastroMonitor() {
        initComponents();
    }

    public void limparCampos(){
        lbAluno.setText("");
        lbProfessor.setText("");
        lbCurso.setText("");
        lbDisciplina.setText("");
        aluno = new Aluno();
        professor = new Professor();
        curso = new Curso();
        disciplina = new Disciplina();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jLabel1.setText("Aluno:");

        jLabel2.setText("Professor:");

        jLabel3.setText("Curso:");

        jLabel4.setText("Disciplina:");

        jButton1.setText("Pesquisar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnAddProf.setText("Add");
        btnAddProf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddProfActionPerformed(evt);
            }
        });

        btnAddAluno.setText("Add");
        btnAddAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddAlunoActionPerformed(evt);
            }
        });

        jButton4.setText("Pesquisar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        btnAddCurso.setText("Add");
        btnAddCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddCursoActionPerformed(evt);
            }
        });

        jButton6.setText("Pesquisar");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        btnAddDisciplina.setText("Add");
        btnAddDisciplina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddDisciplinaActionPerformed(evt);
            }
        });

        jButton8.setText("Pesquisar");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbAluno))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbDisciplina))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbCurso))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(lbProfessor)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAddProf))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAddAluno))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAddCurso))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAddDisciplina)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnVoltar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
                .addComponent(btnPesquisar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExcluir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSalvar)
                .addGap(25, 25, 25))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lbAluno)
                    .addComponent(jButton4)
                    .addComponent(btnAddAluno))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lbProfessor)
                    .addComponent(jButton1)
                    .addComponent(btnAddProf))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lbCurso)
                    .addComponent(jButton6)
                    .addComponent(btnAddCurso))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lbDisciplina)
                    .addComponent(jButton8)
                    .addComponent(btnAddDisciplina))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar)
                    .addComponent(btnExcluir)
                    .addComponent(btnPesquisar)
                    .addComponent(btnVoltar))
                .addGap(46, 46, 46))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed

        if(!lbAluno.getText().equals("") && !lbProfessor.getText().equals("") && !lbCurso.getText().equals("") && !lbDisciplina.getText().equals("")){
            monitor.setAluno(aluno);
            monitor.setProfessor(professor);
            monitor.setCurso(curso);
            monitor.setDisciplina(disciplina);
            monitor.setAtivo(true);
            monitorDAO.salvar(monitor);
            limparCampos();
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
        List<Disciplina> lista = disciplinaDAO.listar();
        DisciplinaTableModel model = new DisciplinaTableModel(lista);
        Object objetoRetorno = PesquisaGenerica.exibeTela(model, "Disciplina");
        if(objetoRetorno != null){
            disciplina = disciplinaDAO.consultarObjetoId("id", objetoRetorno);
            lbDisciplina.setText(disciplina.getNome());
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
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lbAluno;
    private javax.swing.JLabel lbCurso;
    private javax.swing.JLabel lbDisciplina;
    private javax.swing.JLabel lbProfessor;
    // End of variables declaration//GEN-END:variables
}
