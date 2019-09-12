package professor;

import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import util.GenericDAO;
import util.HibernateUtil;

public class ProfessorDAO extends GenericDAO<Professor>{
    Session sessao;
    Transaction transacao;

    public ProfessorDAO() {
        super(Professor.class);
    }
    
    public void salvar(Professor professor) {
        Object[] options = {"Sim", "Não"};
        if (professor.getId() == 0) {
            if (adicionar(professor)) {
                JOptionPane.showMessageDialog(null, "Professor cadastrado com sucesso!");
            }
        } else if (JOptionPane.showOptionDialog(null, "Deseja mesmo realizar essa edição"
                + "?", "InspectMonitorPoint", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]) == JOptionPane.YES_OPTION) {
            if (atualizar(professor)) {
                JOptionPane.showMessageDialog(null, "Professor editada com sucesso!!");
      
            } else {
                JOptionPane.showMessageDialog(null, "A edição foi cancelada!");
            }
        }

    }
}
