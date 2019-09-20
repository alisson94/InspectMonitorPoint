/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ponto;

import javax.swing.JOptionPane;
import monitor.Monitor;
import util.GenericDAO;

/**
 *
 * @author Everton
 */
public class PontoDAO extends GenericDAO<Object>{
    
    public PontoDAO() {
        super(Ponto.class);
    }
    
}
