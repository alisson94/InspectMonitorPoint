package monitor;

import javax.swing.JOptionPane;
import util.GenericDAO;

/**
 *
 * @author Alisson
 */
public class MonitorDAO extends GenericDAO<Monitor>{
    
    public MonitorDAO() {
        super(Monitor.class);
    }
    
    public void salvar(Monitor monitor) {
        Object[] options = {"Sim", "Não"};
        if (monitor.getId() == 0) {
            if (adicionar(monitor)) {
                JOptionPane.showMessageDialog(null, "Monitor cadastrado com sucesso!");
            }
        } else if (JOptionPane.showOptionDialog(null, "Deseja mesmo realizar essa edição"
                + "?", "InspectMonitorPoint", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]) == JOptionPane.YES_OPTION) {
            if (atualizar(monitor)) {
                JOptionPane.showMessageDialog(null, "Monitor editado com sucesso!!");
      
            } else {
                JOptionPane.showMessageDialog(null, "A edição foi cancelada!");
            }
        }

    }
}
