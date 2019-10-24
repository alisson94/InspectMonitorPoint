/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package email;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Properties;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import monitor.Monitor;

/**
 *
 * @author Everton
 */
public class Email {
    public void enviarEmail(Monitor monitor, int horasTrabalhadas){
    
    int diferencaEmMillis = 28800000 - horasTrabalhadas;
    
    int diferencaHora;
    int diferencaMinute;
    int diferencaSegundos;


    diferencaHora = (int) (diferencaEmMillis / 60000) / 60;
    diferencaMinute =(int) (diferencaEmMillis / 60000) % 60;
    diferencaSegundos = (int) (diferencaEmMillis / 1000) % 60;

    
    SimpleDateFormat formatarHoraCompleta = new SimpleDateFormat("HH:mm:ss");
    
    Time horasPendentes = Time.valueOf(diferencaHora + ":" + diferencaMinute + ":" + diferencaSegundos);
    
    Properties props = new Properties();
    /** Parâmetros de conexão com servidor Gmail */
    props.put("mail.smtp.host", "smtp.gmail.com");
    props.put("mail.smtp.socketFactory.port", "465");
    props.put("mail.smtp.socketFactory.class", 
    "javax.net.ssl.SSLSocketFactory");
    props.put("mail.smtp.auth", "true");
    props.put("mail.smtp.port", "465");
 
    Session session = Session.getDefaultInstance(props,
      new javax.mail.Authenticator() {
           protected PasswordAuthentication getPasswordAuthentication() 
           {
                 return new PasswordAuthentication("epevertonpinheiro90@gmail.com", "vida987654321");
           }
      });
 
    /** Ativa Debug para sessão */
    session.setDebug(true);
 
    try {
 
      Message message = new MimeMessage(session);
      message.setFrom(new InternetAddress(monitor.getAluno().getEmail())); 
      //Remetente
      
        if(monitor.getAluno().getEmail() != null && !monitor.getAluno().getEmail().equals("")) {
            Address[] toUser = InternetAddress.parse(monitor.getAluno().getEmail()); //Destinatário(s)
            message.setRecipients(Message.RecipientType.TO, toUser);
            message.setSubject("Ponto Eletrônico - InspectMonitorPoint | Faculdade Vale do Salgado");//Assunto
            message.setText("Olá " + monitor.getAluno().getNome() + "!\n\n"
                    + "Você não cumpriu com sua meta de 8 horas semanais."
                    + "\nVocê tem uma pendência de " + horasPendentes + "."
                    + "\n\n\nEste é um e-mail automático, por favor, não responda!"
                    + "\n\nFábrica de Software EEEP © 2019 - Todos os direitos reservados."
            );
            Transport.send(message);
        }
     } catch (MessagingException e) {
        throw new RuntimeException(e);
    }
    System.out.println("Mensagens Enviadas com Sucesso!");
  }
    
}
