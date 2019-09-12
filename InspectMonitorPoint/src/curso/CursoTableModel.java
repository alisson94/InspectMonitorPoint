package curso;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class CursoTableModel extends AbstractTableModel {

    private List<Curso> cursos = new ArrayList<>();
    private String[] colunas = {"Id", "Nome"};

    public CursoTableModel(List<Curso> usuarios) {
        this.cursos = usuarios;
    }

    @Override
    public int getRowCount() {
        return cursos.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Curso curso = cursos.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return curso.getId();
            case 1:
                return curso.getNome();

        }
        return null;
    }

    public String getColumnName(int index) {
        switch (index) {
            case 0:
                return colunas[0];
            case 1:
                return colunas[1];

        }
        return null;
    }

}
