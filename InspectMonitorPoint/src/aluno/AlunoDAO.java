package aluno;

import javax.swing.JOptionPane;
import util.GenericDAO;

public class AlunoDAO extends GenericDAO<Aluno> {

    public AlunoDAO() {
        super(Aluno.class);
    }
    
    
    public void salvar(Aluno aluno) {
        Object[] options = {"Sim", "Não"};
        if (aluno.getId() == 0) {
            if (adicionar(aluno)) {
                JOptionPane.showMessageDialog(null, "Aluno cadastrado com sucesso!");
            }
        } else if (JOptionPane.showOptionDialog(null, "Deseja mesmo realizar essa edição"
                + "?", "InspectMonitorPoint", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]) == JOptionPane.YES_OPTION) {
            if (atualizar(aluno)) {
                JOptionPane.showMessageDialog(null, "Aluno editada com sucesso!!");
      
            } else {
                JOptionPane.showMessageDialog(null, "A edição foi cancelada!");
            }
        }

    }
}
