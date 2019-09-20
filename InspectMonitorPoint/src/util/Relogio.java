package util;

import java.text.SimpleDateFormat;  
import java.util.Date;  
import javax.swing.JLabel;  
/** 
* 
* @author AJFILHO 
*/  
public class Relogio extends Thread {  
  
    private JLabel hr;  
    private boolean mostrarData;  
  
    public Relogio(JLabel hora) {  
        this.hr = hora;  
    }  
  
    public void mostrarData(boolean mostrar) {  
        if (mostrar) {  
            this.mostrarData = true;  
        } else {  
            this.mostrarData = false;  
        }  
    }  
  
    @Override  
    public void run() {  
        try {  
            while (true) {  
                Date d = new Date();  
                StringBuffer data = new StringBuffer();  
                if (mostrarData) {  
                    SimpleDateFormat sdfData = new SimpleDateFormat("dd.MM.yyyy");  
                    data.append(sdfData.format(d));  
                    data.append(" - ");  
                }  
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");  
                this.hr.setText(data.toString() + sdf.format(d));  
                Thread.sleep(1000);  
                this.hr.revalidate();  
            }  
        } catch (InterruptedException ex) {  
            System.out.println("Problema na atualização da data/hora");  
            ex.printStackTrace();  
        }  
    }  
}  
