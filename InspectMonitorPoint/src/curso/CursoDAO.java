package curso;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import util.HibernateUtil;

public class CursoDAO {
    Session sessao;
    Transaction transacao;
    
    public void iniciarSessao(){
        sessao = HibernateUtil.getSessionFactory().openSession();
        transacao = sessao.beginTransaction();
    }
    
    public void salvarCurso(Curso curso){
        iniciarSessao();
        sessao.save(curso);
        transacao.commit();
        sessao.close();
    }
    
    public void editarCurso(Curso curso){
        iniciarSessao();
        sessao.update(curso);
        transacao.commit();
        sessao.close();
    }
    
    public void exclurCurso(Curso curso){
        iniciarSessao();
        sessao.delete(curso);
        transacao.commit();
        sessao.close();
    }
    
    public List<Curso> listarCurso(){
        iniciarSessao();
        List<Curso> cursoes = sessao.createCriteria(Curso.class).list();
        sessao.close();
        return cursoes;
    }
    
    public Curso pesquisarCursoId(int id){
        iniciarSessao();
        Curso curso = (Curso) sessao.createCriteria(Curso.class).add(Restrictions.eq("id", id)).uniqueResult();
        sessao.close();
        return curso;
    }
}
