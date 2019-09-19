package ponto;


import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class PontoTableModel extends AbstractTableModel {

    private List<Ponto> pontos = new ArrayList<>();
    private String[] colunas = {"IDPonto", "Monitor","DataPonto", "HoraEntradaPonto", "HoraSaidaPonto", };

    public PontoTableModel(List<Ponto> usuarios) {
        this.pontos = usuarios;
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
                return ponto.getIdPonto();

            case 1:
                return ponto.getMonitor();

            case 2:
                return ponto.getDataPonto();

            case 3:
                return ponto.getHoraEntradaPonto();

            case 4:
                return ponto.getHoraSaidaPonto();

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
            case 4:
                return colunas[4];

        }
        return null;
    }

}
