/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ponto;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class PontoTableModelRegistro extends AbstractTableModel {

    private List<Ponto> pontos = new ArrayList<>();
    private String[] colunas = {"Monitor", "Hora", "Turno", "Tipo Registro"};
    SimpleDateFormat formatarHora = new SimpleDateFormat("HH:mm:ss");

    public PontoTableModelRegistro(List<Ponto> ponto) {
        this.pontos = ponto;
    }

    @Override
    public int getRowCount() {
        return pontos.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Ponto ponto = pontos.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return ponto.getMonitor().getAluno().getNome();
            case 1:
                if (ponto.getHoraSaidaPonto() == null) {
                    return ponto.getHoraEntradaPonto();
                } else {
                    return ponto.getHoraSaidaPonto();
                }
            case 2:
                return ponto.getTurnoPonto();
            case 3:
                if (ponto.getHoraSaidaPonto() == null) {
                    return "Entrada";
                } else {
                    return "Saída";
                }
        }
        return null;
    }

    public String getColumnName(int index) {
        switch (index) {
            case 0:
                return colunas[0];
            case 1:
                return colunas[1];
            case 2:
                return colunas[2];
            case 3:
                return colunas[3];

        }
        return null;
    }

}
