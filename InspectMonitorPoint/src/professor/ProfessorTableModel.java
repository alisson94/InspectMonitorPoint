package professor;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ProfessorTableModel extends AbstractTableModel {

    private List<Professor> professores = new ArrayList<>();
    private String[] colunas = {"id", "nome", "curso"};

    public ProfessorTableModel(List<Professor> usuarios) {
        this.professores = usuarios;
    }

    @Override
    public int getRowCount() {
        return professores.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Professor professor = professores.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return professor.getId();
            case 1:
                return professor.getNome();
            case 2:
                return professor.getCurso();

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

        }
        return null;
    }

}
