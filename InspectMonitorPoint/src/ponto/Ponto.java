/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ponto;

import java.sql.Time;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import monitor.Monitor;

@Entity
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
    
    private String turnoPonto;
    private String diaDaSemana;
    private Time horasTrabalhadas;
    
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

    public String getTurnoPonto() {
        return turnoPonto;
    }

    public void setTurnoPonto(String turnoPonto) {
        this.turnoPonto = turnoPonto;
    }

    public String getDiaDaSemana() {
        return diaDaSemana;
    }

    public void setDiaDaSemana(String diaDaSemana) {
        this.diaDaSemana = diaDaSemana;
    }

    public Time getHorasTrabalhadas() {
        return horasTrabalhadas;
    }

    public void setHorasTrabalhadas(Time horasTrabalhadas) {
        this.horasTrabalhadas = horasTrabalhadas;
    }
    
    
}
