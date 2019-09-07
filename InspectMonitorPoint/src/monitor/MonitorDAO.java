package monitor;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import util.HibernateUtil;

public class MonitorDAO {
    Session sessao;
    Transaction transacao;
    
    public void iniciarSessao(){
        sessao = HibernateUtil.getSessionFactory().openSession();
        transacao = sessao.beginTransaction();
    }
    
    public void salvarMonitor(Monitor monitor){
        sessao = HibernateUtil.getSessionFactory().openSession();
        transacao = sessao.beginTransaction();
        sessao.save(monitor);
        transacao.commit();
        sessao.close();
    }
    
    public void editarMonitor(Monitor monitor){
        iniciarSessao();
        sessao.update(monitor);
        transacao.commit();
        sessao.close();
    }
    
    public void exclurMonitor(Monitor monitor){
        iniciarSessao();
        sessao.delete(monitor);
        transacao.commit();
        sessao.close();
    }
    
    public List<Monitor> listarMonitor(){
        iniciarSessao();
        List<Monitor> monitores = sessao.createCriteria(Monitor.class).list();
        sessao.close();
        return monitores;
    }
    
    public Monitor pesquisarMonitorMatricula(int matricula){
        iniciarSessao();
        Monitor monitor = (Monitor) sessao.createCriteria(Monitor.class).add(Restrictions.eq("matricula", matricula)).uniqueResult();
        sessao.close();
        return monitor;
    }
}
