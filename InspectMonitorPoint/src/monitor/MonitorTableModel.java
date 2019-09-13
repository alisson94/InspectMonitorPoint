package monitor;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class MonitorTableModel extends AbstractTableModel {

    private List<Monitor> monitors = new ArrayList<>();
    private String[] colunas = {"Matrícula", "Nome", "Professor", "Curso", "Disciplina"};

    public MonitorTableModel(List<Monitor> usuarios) {
        this.monitors = usuarios;
    }

    @Override
    public int getRowCount() {
        return monitors.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Monitor monitor = monitors.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return monitor.getAluno().getMatricula();
            case 1:
                return monitor.getAluno().getNome();
            case 2:
                return monitor.getProfessor().getNome();
            case 3:
                return monitor.getCurso().getNome();
            case 4:
                return monitor.getDisciplina().getNome();
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
