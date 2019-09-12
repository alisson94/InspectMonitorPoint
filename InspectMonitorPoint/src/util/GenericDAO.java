package util;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

@SuppressWarnings("unchecked")
public abstract class GenericDAO<T> {

    /*
     * Essa classe possui operações comuns a todas as classes persistentes
     * para utilizar-la deverá criar uma classe DAO específica para a classe
     * persistente e extends GenericDAO<T> onde T é a classe Persistente 
     */
    public Session sessao;
    public Transaction transacao;
    private Class classe;

    public GenericDAO(Class classe) {
        this.classe = classe;
    }

    public boolean adicionar(T entity) {
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());
            this.getSessao().save(entity);
            this.getTransacao().commit();

        } catch (HibernateException e) {
            JOptionPane.showMessageDialog(null, "Não foi possível executar essa operação" + entity.getClass()
                    + ". Erro: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        } finally {
            getSessao().close();

        }
        return true;
    }

    public boolean atualizar(T entity) {
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());
            this.getSessao().merge(entity);
            this.getTransacao().commit();

        } catch (HibernateException e) {
            JOptionPane.showMessageDialog(null, "Não foi possível executar essa operação" + entity.getClass()
                    + ". Erro: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        } finally {
            getSessao().close();

        }
        return true;
    }

    public boolean remover(T entity) {
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());
            this.getSessao().delete(entity);
            this.getTransacao().commit();
        } catch (HibernateException e) {
            JOptionPane.showMessageDialog(null, "Não foi possível executar essa operação" + entity.getClass()
                    + ". Erro: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        } finally {
            getSessao().close();

        }
        return true;
    }

    public List<T> listar() {
        List<T> lista = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            setTransacao(getSessao().beginTransaction());
            lista = this.getSessao().createCriteria(classe).list();
            //sessao.close();
        } catch (Throwable e) {
            if (getTransacao().isActive()) {
                getTransacao().rollback();
            }
            JOptionPane.showMessageDialog(null, "Não foi possível executar essa operação"
                    + ". Erro: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
        return lista;
    }

    /*
     * ao passar uma chave primária
     * ele retorna um objeto referente a chave primária
     */
    public T carregaChavePrimaria(int chavePrimaria) {
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            Object o = sessao.load(classe, chavePrimaria);
            return (T) o;
        } catch (HibernateException e) {
            JOptionPane.showMessageDialog(null, "Não foi possível executar essa operação"
                    + ". Erro: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            sessao.close();
        }
        return null;
    }

    public List<T> checkExists(String campo, String valor) {
        List<T> lista = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            setTransacao(getSessao().beginTransaction());
            lista = this.getSessao().createCriteria(classe).add(Restrictions.ilike(campo, valor, MatchMode.ANYWHERE)).list();
            sessao.close();
        } catch (Throwable e) {
            if (getTransacao().isActive()) {
                getTransacao().rollback();
            }
            JOptionPane.showMessageDialog(null, "Não foi possível executar essa operação"
                    + ". Erro: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
        return lista;

    }
    /**
     * @return the sessao
     */
    public Session getSessao() {
        return sessao;
    }

    /**
     * @param sessao the sessao to set
     */
    public void setSessao(Session sessao) {
        this.sessao = sessao;
    }

    /**
     * @return the transacao
     */
    public Transaction getTransacao() {
        return transacao;
    }

    /**
     * @param transacao the transacao to set
     */
    public void setTransacao(Transaction transacao) {
        this.transacao = transacao;
    }

}
