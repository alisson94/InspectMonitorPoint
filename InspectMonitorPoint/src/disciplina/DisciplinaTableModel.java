package disciplina;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class DisciplinaTableModel extends AbstractTableModel {

    private List<Disciplina> disciplinas = new ArrayList<>();
    private String[] colunas = {"id", "nome", "curso", "professor"};

    public DisciplinaTableModel(List<Disciplina> usuarios) {
        this.disciplinas = usuarios;
    }

    @Override
    public int getRowCount() {
        return disciplinas.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Disciplina disciplina = disciplinas.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return disciplina.getId();
            case 1:
                return disciplina.getNome();
            case 2:
                return disciplina.getCurso();
            case 3:
                return disciplina.getProfessor();

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
