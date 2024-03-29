/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usuario;

import util.GenericDAO;
import util.HibernateUtil;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Everton
 */
public class UsuarioDAO extends GenericDAO<Usuario> {
    
    public UsuarioDAO() {
        super(Usuario.class);
    }
    
    public void salvar(Usuario usuario) {
        Object[] options = {"Sim", "Não"};
        if (usuario.getId()== 0) {
            if (adicionar(usuario)) {
                JOptionPane.showMessageDialog(null, "Usuario cadastrado com sucesso!");
            }
        } else if (JOptionPane.showOptionDialog(null, "Deseja mesmo realizar essa edição"
                + "?", "InspectUsuarioPoint", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]) == JOptionPane.YES_OPTION) {
            if (atualizar(usuario)) {
                JOptionPane.showMessageDialog(null, "Usuario editado com sucesso!!");
      
            } else {
                JOptionPane.showMessageDialog(null, "A edição foi cancelada!");
            }
        }

    }
    
        public Usuario autenticarUsuario(String login, String senha) {
        sessao = HibernateUtil.getSessionFactory().openSession();
        transacao = sessao.beginTransaction();
        Usuario usuario = (Usuario) sessao.createCriteria(Usuario.class).add(Restrictions.eq("senha", senha)).add(Restrictions.eq("login", login)).uniqueResult();
        if (usuario == null) {
            JOptionPane.showMessageDialog(null, "Usuário ou Senha Inválidos!");
        } else {
            sessao.close();
            return usuario;
        }
        return usuario;
    }
}
