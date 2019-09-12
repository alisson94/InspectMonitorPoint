package curso;

import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import util.GenericDAO;
import util.HibernateUtil;

public class CursoDAO extends GenericDAO<Curso>{
    
    public CursoDAO() {
        super(Curso.class);
    }
    
    public void salvar(Curso curso) {
        Object[] options = {"Sim", "Não"};
        if (curso.getId() == 0) {
            if (adicionar(curso)) {
                JOptionPane.showMessageDialog(null, "Curso cadastrado com sucesso!");
            }
        } else if (JOptionPane.showOptionDialog(null, "Deseja mesmo realizar essa edição"
                + "?", "InspectMonitorPoint", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]) == JOptionPane.YES_OPTION) {
            if (atualizar(curso)) {
                JOptionPane.showMessageDialog(null, "Curso editada com sucesso!!");
      
            } else {
                JOptionPane.showMessageDialog(null, "A edição foi cancelada!");
            }
        }

    }
}
