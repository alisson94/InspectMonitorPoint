/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import monitor.Monitor;
import monitor.MonitorDAO;
import ponto.*;
import util.Relogio;
import email.Email;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author Everton
 */
public class CadastroPonto extends javax.swing.JFrame {
    Email email = new Email();
    Ponto ponto = new Ponto();
    PontoDAO pontoDAO = new PontoDAO();
    Monitor monitor = new Monitor();
    MonitorDAO monitorDAO = new MonitorDAO();
    
    SimpleDateFormat formatarData = new SimpleDateFormat("dd/MM/yyyy");
    SimpleDateFormat formatarHora = new SimpleDateFormat("HH");
    SimpleDateFormat formatarMinuto = new SimpleDateFormat("mm");
    SimpleDateFormat formatarDiaSemana = new SimpleDateFormat("E");
    SimpleDateFormat formatarHoraCompleta = new SimpleDateFormat("HH:mm:ss");
    SimpleDateFormat formatarSemandaDoAno = new SimpleDateFormat("w");
    Date dataHoraSistema;
    
    List<Ponto> listaPontoTabela = new ArrayList<>();
    
    public CadastroPonto() {
        initComponents();
        dataHoraSistema = new Date();
        mostrarHora();
        
        new Thread(){
            @Override
            public void run(){
                try {
                    while(true){
                        dataHoraSistema = new Date();
                        String hora = formatarHora.format(dataHoraSistema);
                        String minuto = formatarMinuto.format(dataHoraSistema);
                        String diaDaSemana = formatarDiaSemana.format(dataHoraSistema);

                        if(hora.equals("23") && diaDaSemana.equals("Sex")){
                            JOptionPane.showMessageDialog(null, "Entrou");
                            for(Monitor monitor : monitorDAO.listar()){
                                verificarHorasSemanais(monitor);
                            }
                            JOptionPane.showMessageDialog(null, "Saiu");
                            System.exit(0);
                        }
                        
                        sleep(1000);
                    }
                } catch (Exception e) {
                }
            }
        }.start();
    }
    
    public void verificarHorasSemanais(Monitor monitor){
      List<Ponto> listaPontos = pontoDAO.listar();
      String semanaDoAno = formatarSemandaDoAno.format(dataHoraSistema);
      int horasTrabalhadasSemana = 0;
      
      if(!listaPontos.isEmpty()){
        for(Ponto ponto : listaPontos){
            String semanaDoAnoPonto = formatarSemandaDoAno.format(ponto.getDataPontoCompleta());
            if(ponto.getMonitor().getId() == monitor.getId() && semanaDoAnoPonto.equals(semanaDoAno)){
                horasTrabalhadasSemana += ponto.getHorasTrabalhadas().getTime();
            }
        }
        if(horasTrabalhadasSemana < 28800000){
            email.enviarEmail(monitor, horasTrabalhadasSemana);
        }else{
            JOptionPane.showMessageDialog(null, "Nao enviar Email");
        }
      }
    }
    
    public void mostrarHora() {
        Relogio ah = new Relogio(lbHora);
        ah.mostrarData(true);
        Thread thHora = ah;
        thHora.start();
    }
    
    public void atualizarTabela(){
        PontoTableModelRegistro model = new PontoTableModelRegistro(listaPontoTabela);
        tbPontoMonitor.setModel(model);
        tbPontoMonitor.getColumnModel().getColumn(0).setPreferredWidth(300);
    }
    
    public String carregarTurno() {
        dataHoraSistema = new Date();
        int hora = Integer.parseInt(formatarHora.format(dataHoraSistema));
        int minuto = Integer.parseInt(formatarMinuto.format(dataHoraSistema));
        if ((hora >= 5 && hora <= 12) || ((hora == 13) && minuto <= 15)) {
            return "Manhã";
        } else if ((hora >= 13 && hora <= 16) || ((hora == 17) && minuto <= 20)) {
            return "Tarde";
        } else {
            return "Noite";
        }
    }
    
    public Time calcularDiferencaHoras(Time horaInicio, Time horaFinal) throws ParseException{
        long diferencaEmMillis;
        
        int diferencaHora;
        int diferencaMinute;
        
        diferencaEmMillis = horaFinal.getTime() - horaInicio.getTime();
        
        diferencaHora = (int) (diferencaEmMillis / 60000) / 60;
        diferencaMinute =(int) (diferencaEmMillis / 60000) % 60;
        
        Date date = formatarHoraCompleta.parse(diferencaHora + ":" + diferencaMinute + ":00");
        
        return Time.valueOf(formatarHoraCompleta.format(date));
    }
    
    public void registrarPresentePonto(Monitor monitor) throws ParseException {
        ponto = new Ponto();
        List<Ponto> listaPontosMonitor = pontoDAO.checkExistsPontoMonitor("dataPonto", formatarData.format(dataHoraSistema),
                "monitor.id", monitor.getId(),
                "turnoPonto", carregarTurno());
        dataHoraSistema = new Date();
        
        if (!listaPontosMonitor.isEmpty()) {
            ponto = (Ponto) listaPontosMonitor.get(0);
            if (ponto.getHoraEntradaPonto() == null) {
                ponto.setHoraEntradaPonto(Time.valueOf(formatarHoraCompleta.format(dataHoraSistema)));
            } else if (ponto.getHoraEntradaPonto() != null && ponto.getHoraSaidaPonto() == null) {
                ponto.setHoraSaidaPonto(Time.valueOf(formatarHoraCompleta.format(dataHoraSistema)));
                ponto.setHorasTrabalhadas(calcularDiferencaHoras(ponto.getHoraEntradaPonto(), ponto.getHoraSaidaPonto()));
            } else {
                ponto.setHoraEntradaPonto(Time.valueOf(formatarHoraCompleta.format(dataHoraSistema)));
                ponto.setHoraSaidaPonto(null);
            }
            listaPontoTabela.add(0, ponto);
            atualizarTabela();
            pontoDAO.atualizar(ponto);
            //abrirTelaMensagemPonto(ponto);

        } else {
            ponto.setDataPontoCompleta(dataHoraSistema);
            ponto.setDataPonto(formatarData.format(dataHoraSistema));
            ponto.setDiaDaSemana(formatarDiaSemana.format(dataHoraSistema));
            ponto.setMonitor(monitor);
            ponto.setTurnoPonto(carregarTurno());
            ponto.setHoraEntradaPonto(Time.valueOf(formatarHoraCompleta.format(dataHoraSistema)));
            listaPontoTabela.add(0, ponto);
            atualizarTabela();
            pontoDAO.adicionar(ponto);
            //abrirTelaMensagemPonto(ponto);
        }

    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbPontoMonitor = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        lbHora = new javax.swing.JLabel();
        tfIdMonitor = new javax.swing.JTextField();
        tfHoraFinal = new javax.swing.JFormattedTextField();
        tfHoraInicial = new javax.swing.JFormattedTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbPontoMonitor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tbPontoMonitor);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 780, 240));

        jButton1.setText("Dar entrada/saida");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 70, -1, -1));

        lbHora.setText("Hora:");
        getContentPane().add(lbHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));
        getContentPane().add(tfIdMonitor, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 70, 80, -1));

        try {
            tfHoraFinal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/#### ##:##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        getContentPane().add(tfHoraFinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 150, 120, -1));

        try {
            tfHoraInicial.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/#### ##:##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        getContentPane().add(tfHoraInicial, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 120, 120, -1));

        jButton2.setText("ir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 130, -1, -1));

        jButton3.setText("Verificar horas");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 40, -1, -1));

        jLabel2.setText("CADASTRO DE PONTO");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, 260, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/backgroundpesquisagenerica.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int idMonitor = Integer.parseInt(tfIdMonitor.getText());
        monitor = monitorDAO.consultarObjetoId("id", idMonitor);
        try {
            registrarPresentePonto(monitor);
        } catch (ParseException ex) {
            Logger.getLogger(CadastroPonto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // COLOCA AQUI
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int idMonitor = Integer.parseInt(tfIdMonitor.getText());
        monitor = monitorDAO.consultarObjetoId("id", idMonitor);
        verificarHorasSemanais(monitor);
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(CadastroPonto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroPonto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroPonto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroPonto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroPonto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbHora;
    private javax.swing.JTable tbPontoMonitor;
    private javax.swing.JFormattedTextField tfHoraFinal;
    private javax.swing.JFormattedTextField tfHoraInicial;
    private javax.swing.JTextField tfIdMonitor;
    // End of variables declaration//GEN-END:variables
}
