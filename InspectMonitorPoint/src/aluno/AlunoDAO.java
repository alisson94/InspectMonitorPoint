package aluno;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import util.HibernateUtil;

public class AlunoDAO {
    Session sessao;
    Transaction transacao;
    
    public void iniciarSessao(){
        sessao = HibernateUtil.getSessionFactory().openSession();
        transacao = sessao.beginTransaction();
    }
    
    public void salvarMonitor(Aluno monitor){
        iniciarSessao();
        sessao.save(monitor);
        transacao.commit();
        sessao.close();
    }
    
    public void editarMonitor(Aluno monitor){
        iniciarSessao();
        sessao.update(monitor);
        transacao.commit();
        sessao.close();
    }
    
    public void exclurMonitor(Aluno monitor){
        iniciarSessao();
        sessao.delete(monitor);
        transacao.commit();
        sessao.close();
    }
    
    public List<Aluno> listarMonitor(){
        iniciarSessao();
        List<Aluno> monitores = sessao.createCriteria(Aluno.class).list();
        sessao.close();
        return monitores;
    }
    
    public Aluno pesquisarMonitorMatricula(int matricula){
        iniciarSessao();
        Aluno monitor = (Aluno) sessao.createCriteria(Aluno.class).add(Restrictions.eq("matricula", matricula)).uniqueResult();
        sessao.close();
        return monitor;
    }
}
