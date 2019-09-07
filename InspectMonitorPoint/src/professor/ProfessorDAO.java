package professor;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import util.HibernateUtil;

public class ProfessorDAO {
    Session sessao;
    Transaction transacao;
    
    public void iniciarSessao(){
        sessao = HibernateUtil.getSessionFactory().openSession();
        transacao = sessao.beginTransaction();
    }
    
    public void salvarProfessor(Professor professor){
        iniciarSessao();
        sessao.save(professor);
        transacao.commit();
        sessao.close();
    }
    
    public void editarProfessor(Professor professor){
        iniciarSessao();
        sessao.update(professor);
        transacao.commit();
        sessao.close();
    }
    
    public void exclurProfessor(Professor professor){
        iniciarSessao();
        sessao.delete(professor);
        transacao.commit();
        sessao.close();
    }
    
    public List<Professor> listarProfessor(){
        iniciarSessao();
        List<Professor> professores = sessao.createCriteria(Professor.class).list();
        sessao.close();
        return professores;
    }
    
    public Professor pesquisarProfessorId(int id){
        iniciarSessao();
        Professor professor = (Professor) sessao.createCriteria(Professor.class).add(Restrictions.eq("id", id)).uniqueResult();
        sessao.close();
        return professor;
    }
}
