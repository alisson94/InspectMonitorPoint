package disciplina;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import util.HibernateUtil;

public class DisciplinaDAO {
    Session sessao;
    Transaction transacao;
    
    public void iniciarSessao(){
        sessao = HibernateUtil.getSessionFactory().openSession();
        transacao = sessao.beginTransaction();
    }
    
    public void salvarDisciplina(Disciplina disciplina){
        iniciarSessao();
        sessao.save(disciplina);
        transacao.commit();
        sessao.close();
    }
    
    public void editarDisciplina(Disciplina disciplina){
        iniciarSessao();
        sessao.update(disciplina);
        transacao.commit();
        sessao.close();
    }
    
    public void exclurDisciplina(Disciplina disciplina){
        iniciarSessao();
        sessao.delete(disciplina);
        transacao.commit();
        sessao.close();
    }
    
    public List<Disciplina> listarDisciplina(){
        iniciarSessao();
        List<Disciplina> disciplinaes = sessao.createCriteria(Disciplina.class).list();
        sessao.close();
        return disciplinaes;
    }
    
    public Disciplina pesquisarDisciplinaId(int id){
        iniciarSessao();
        Disciplina disciplina = (Disciplina) sessao.createCriteria(Disciplina.class).add(Restrictions.eq("id", id)).uniqueResult();
        sessao.close();
        return disciplina;
    }
}
