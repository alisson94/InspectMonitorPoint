package disciplina;

import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import util.GenericDAO;
import util.HibernateUtil;

public class DisciplinaDAO extends GenericDAO<Disciplina>{
    
    public DisciplinaDAO() {
        super(Disciplina.class);
    }
    
    public void salvar(Disciplina disciplina) {
        Object[] options = {"Sim", "Não"};
        if (disciplina.getId() == 0) {
            if (adicionar(disciplina)) {
                JOptionPane.showMessageDialog(null, "Disciplina cadastrado com sucesso!");
            }
        } else if (JOptionPane.showOptionDialog(null, "Deseja mesmo realizar essa edição"
                + "?", "InspectMonitorPoint", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]) == JOptionPane.YES_OPTION) {
            if (atualizar(disciplina)) {
                JOptionPane.showMessageDialog(null, "Disciplina editada com sucesso!!");
      
            } else {
                JOptionPane.showMessageDialog(null, "A edição foi cancelada!");
            }
        }

    }
}
