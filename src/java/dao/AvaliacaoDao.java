/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Avaliacao;
import model.Curso;
import model.Disciplina;
import model.Estudante;
import model.Realiza;
import model.RealizaId;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Paulino
 */
public class AvaliacaoDao {
    
     public void addAvaliacao(Avaliacao avaliacao) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();

            // Iniciar transação
            transaction = session.beginTransaction();

            // Salvar a estudante
            session.save(avaliacao);

            // Commit transação
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
     
         // Método para buscar um avaliacao pelo código
    public Avaliacao getAvaliacao(int codigo) {
        Transaction transaction = null;
        Avaliacao avaliacao = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession(); 
            transaction = session.beginTransaction();
            avaliacao = (Avaliacao) session.get(Avaliacao.class,codigo);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return avaliacao;
    }

    public void updateAvaliacao(Avaliacao avaliacao) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();

            transaction = session.beginTransaction();
            session.update(avaliacao);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
    
    public void removeAvaliacao(int codigo) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
               
            transaction = session.beginTransaction();
            
            // Carregar a disciplina a ser removida
            Avaliacao avaliacao = (Avaliacao) session.get(Avaliacao.class, codigo);
            if (avaliacao!= null) {
                session.delete(avaliacao);
                System.out.println("disciplina removida com sucesso!");
            }

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
    
     public List<Avaliacao> getAllavaliacao() {
        Transaction transaction = null;
        List<Avaliacao> avaliacao = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            
           Query query = session.createQuery("FROM Avaliacao");
            avaliacao = query.list();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return avaliacao;
    }
    
     public boolean existsAvaliacao(Avaliacao codigo) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession(); 
           Avaliacao avaliacao;
            avaliacao = (Avaliacao) session.get(Avaliacao.class, codigo);
            return avaliacao != null;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean existsAvaliacao(int codigoAvaliacaoRealiza) {
        
           try {
            Session session = HibernateUtil.getSessionFactory().openSession(); 
           Avaliacao avaliacao;
            avaliacao = (Avaliacao) session.get(Avaliacao.class, codigoAvaliacaoRealiza);
            return avaliacao != null;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        
    }
    
}
