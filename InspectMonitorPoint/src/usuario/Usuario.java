/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usuario;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author Adriano Lima
 */
@Entity
public class Usuario {
    
    @Id
    @GeneratedValue
    private int idUsuario;
    
    @Column(length = 100, nullable = false)
    private String nomeUsuario;
    
    @Column(length = 100, nullable = false)
    private String loginUsuario;
    
    @Column(length = 100, nullable = false)
    private String senhaUsuario;
    
    @Column(length = 100, nullable = false)
    private String tipoDeAcessoUsuario;

    
    
    /**
     * @return the idUsuario
     */
    public int getIdUsuario() {
        return idUsuario;
    }

    /**
     * @param idUsuario the idUsuario to set
     */
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    /**
     * @return the nomeUsuario
     */
    public String getNomeUsuario() {
        return nomeUsuario;
    }

    /**
     * @param nomeUsuario the nomeUsuario to set
     */
    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    /**
     * @return the loginUsuario
     */
    public String getLoginUsuario() {
        return loginUsuario;
    }

    /**
     * @param loginUsuario the loginUsuario to set
     */
    public void setLoginUsuario(String loginUsuario) {
        this.loginUsuario = loginUsuario;
    }

    /**
     * @return the senhaUsuario
     */
    public String getSenhaUsuario() {
        return senhaUsuario;
    }

    /**
     * @param senhaUsuario the senhaUsuario to set
     */
    public void setSenhaUsuario(String senhaUsuario) {
        this.senhaUsuario = senhaUsuario;
    }

    /**
     * @return the tipoDeAcessoUsuario
     */
    public String getTipoDeAcessoUsuario() {
        return tipoDeAcessoUsuario;
    }

    /**
     * @param tipoDeAcessoUsuario the tipoDeAcessoUsuario to set
     */
    public void setTipoDeAcessoUsuario(String tipoDeAcessoUsuario) {
        this.tipoDeAcessoUsuario = tipoDeAcessoUsuario;
    }


    
}
