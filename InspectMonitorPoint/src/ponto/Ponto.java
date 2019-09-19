/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ponto;

import java.sql.Time;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import monitor.Monitor;

/**
 *
 * @author Everton
 */
public class Ponto {
    
     @Id
    @GeneratedValue
    private int idPonto;
     
    @OneToOne 
    private Monitor monitor;
    
    @Column
    private Date dataPontoCompleta;

    @Column
    private String dataPonto;

    @Column
    private Time horaEntradaPonto;

    @Column
    private Time horaSaidaPonto;

    public int getIdPonto() {
        return idPonto;
    }

    public void setIdPonto(int idPonto) {
        this.idPonto = idPonto;
    }

    public Monitor getMonitor() {
        return monitor;
    }

    public void setMonitor(Monitor monitor) {
        this.monitor = monitor;
    }

    public Date getDataPontoCompleta() {
        return dataPontoCompleta;
    }

    public void setDataPontoCompleta(Date dataPontoCompleta) {
        this.dataPontoCompleta = dataPontoCompleta;
    }

    public String getDataPonto() {
        return dataPonto;
    }

    public void setDataPonto(String dataPonto) {
        this.dataPonto = dataPonto;
    }

    public Time getHoraEntradaPonto() {
        return horaEntradaPonto;
    }

    public void setHoraEntradaPonto(Time horaEntradaPonto) {
        this.horaEntradaPonto = horaEntradaPonto;
    }

    public Time getHoraSaidaPonto() {
        return horaSaidaPonto;
    }

    public void setHoraSaidaPonto(Time horaSaidaPonto) {
        this.horaSaidaPonto = horaSaidaPonto;
    }
}
