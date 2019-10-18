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
import util.LeitorBiometrico;



/**
 *
 * @author Everton
 */
public class CadastroPonto extends javax.swing.JFrame {
    //Email email = new Email();
    Ponto ponto = new Ponto();
    PontoDAO pontoDAO = new PontoDAO();
    Monitor monitor = new Monitor();
    MonitorDAO monitorDAO = new MonitorDAO();
    LeitorBiometrico digital = new LeitorBiometrico();
    
    SimpleDateFormat formatarData = new SimpleDateFormat("dd/MM/yyyy");
    SimpleDateFormat formatarHora = new SimpleDateFormat("HH");
    SimpleDateFormat formatarMinuto = new SimpleDateFormat("mm");
    SimpleDateFormat formatarDiaSemana = new SimpleDateFormat("E");
    SimpleDateFormat formatarHoraCompleta = new SimpleDateFormat("HH:mm:ss");
    SimpleDateFormat formatarSemandaDoAno = new SimpleDateFormat("w");
    Date dataHoraSistema;
    
    List<Ponto> listaPontoTabela = new ArrayList<>();
    List<Monitor> listaMonitores;
    
    public CadastroPonto() {
        initComponents();
        jlMonitorNaoLocalizado.setVisible(false);
        dataHoraSistema = new Date();
        mostrarHora();
        listaMonitores = monitorDAO.listar();
        
//        new Thread() {;
//            @Override
//            public void run() {
//                try {     
//                    compararDigital();
//                } catch (ParseException ex) {
//                }
//            }
//        }.start();

        
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
            if(ponto.getMonitor().getId() == monitor.getId() && semanaDoAnoPonto.equals(semanaDoAno) && ponto.getHorasTrabalhadas() != null){
                horasTrabalhadasSemana += (ponto.getHorasTrabalhadas().getTime() - 10800000);
            }
        }
        if(horasTrabalhadasSemana < 28800000){
            JOptionPane.showMessageDialog(null, "enviar email" + monitor.getAluno().getNome() + horasTrabalhadasSemana);
            //email.enviarEmail(monitor, horasTrabalhadasSemana);
        }else{
            JOptionPane.showMessageDialog(null, "Nao enviar Email" + monitor.getAluno().getNome() + horasTrabalhadasSemana);
        }
      }
    }
    
    private void compararDigital() throws ParseException {
        monitor = new Monitor();
        monitor = digital.verificarSeCadastrado(null, listaMonitores);
        if (monitor != null) {
            registrarPresentePonto(monitor);
            jlMonitorNaoLocalizado.setVisible(false);

        } else {
            jlMonitorNaoLocalizado.setVisible(true);
        }
        compararDigital();
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
    
    public Time calcularDiferencaHoras(Time horaInicio, Time horaFinal){
        long diferencaEmMillis;
        
        int diferencaHora;
        int diferencaMinute;
        
        diferencaEmMillis = horaFinal.getTime() - horaInicio.getTime();
        
        diferencaHora = (int) (diferencaEmMillis / 60000) / 60;
        diferencaMinute =(int) (diferencaEmMillis / 60000) % 60;
        
        return Time.valueOf(diferencaHora + ":" + diferencaMinute + ":00");
    }
    
    public void registrarPresentePonto(Monitor monitor){
        ponto = new Ponto();
        List<Ponto> listaPontosMonitor = pontoDAO.checkExistsPontoMonitor("dataPonto", formatarData.format(dataHoraSistema),
                "monitor.id", monitor.getId(),
                "turnoPonto", carregarTurno());
        dataHoraSistema = new Date();
        
        if (!listaPontosMonitor.isEmpty()) {
            ponto = listaPontosMonitor.get(listaPontosMonitor.size() - 1);
            
            if (ponto.getHoraEntradaPonto() != null && ponto.getHoraSaidaPonto() == null) {
                ponto.setHoraSaidaPonto(Time.valueOf(formatarHoraCompleta.format(dataHoraSistema)));
                ponto.setHorasTrabalhadas(calcularDiferencaHoras(ponto.getHoraEntradaPonto(), ponto.getHoraSaidaPonto()));
                
                listaPontoTabela.add(0, ponto);
                atualizarTabela();
                pontoDAO.atualizar(ponto);
                
            }else if(ponto.getHoraEntradaPonto() != null && ponto.getHoraSaidaPonto() != null){
                ponto.setDataPontoCompleta(dataHoraSistema);
                ponto.setDataPonto(formatarData.format(dataHoraSistema));
                ponto.setDiaDaSemana(formatarDiaSemana.format(dataHoraSistema));
                ponto.setMonitor(monitor);
                ponto.setTurnoPonto(carregarTurno());
                ponto.setHoraEntradaPonto(Time.valueOf(formatarHoraCompleta.format(dataHoraSistema)));
                ponto.setHoraSaidaPonto(null);
                ponto.setHorasTrabalhadas(null);
                listaPontoTabela.add(0, ponto);
                atualizarTabela();

                pontoDAO.adicionar(ponto);
            }
            
            
            
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
        lbHora = new javax.swing.JLabel();
        jlMonitorNaoLocalizado = new javax.swing.JLabel();
        btnVoltar = new javax.swing.JButton();
        tfInOut = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbPontoMonitor.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
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

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(229, 235, 600, 294));

        lbHora.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbHora.setText("Hora:");
        getContentPane().add(lbHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 450, -1, -1));

        jlMonitorNaoLocalizado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/monitornaoencontrado.png"))); // NOI18N
        getContentPane().add(jlMonitorNaoLocalizado, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 162, 460, 60));

        btnVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/botaovoltarpequeno.png"))); // NOI18N
        btnVoltar.setBorder(null);
        btnVoltar.setContentAreaFilled(false);
        btnVoltar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });
        getContentPane().add(btnVoltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 500, -1, -1));
        getContentPane().add(tfInOut, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 80, 70, -1));

        jButton1.setText("entrada/saida");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 80, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/TelaPontoEletronico.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int id = Integer.parseInt(tfInOut.getText());
        Monitor monitor = monitorDAO.consultarObjetoId("id", id);
        registrarPresentePonto(monitor);
    }//GEN-LAST:event_jButton1ActionPerformed

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
    private javax.swing.JButton btnVoltar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jlMonitorNaoLocalizado;
    private javax.swing.JLabel lbHora;
    private javax.swing.JTable tbPontoMonitor;
    private javax.swing.JTextField tfInOut;
    // End of variables declaration//GEN-END:variables
}
