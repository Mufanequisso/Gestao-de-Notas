/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.RealizaId;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Paulino
 */
public class RealizaIdDao {
     public RealizaId addRealiza(RealizaId realiza) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();

            // Iniciar transação
            transaction = session.beginTransaction();

            // Salvar a estudante
            session.save(realiza);
            // Commit transação
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return realiza;
    }

    public RealizaId updateRealiza(RealizaId realiza) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();

            transaction = session.beginTransaction();
            session.update(realiza);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return realiza;
    }
    
    public void  removeRealiza (int codigo) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
               
            transaction = session.beginTransaction();
            
            // Carregar a disciplina a ser removida
            RealizaId realiza = (RealizaId) session.get(RealizaId.class, codigo);
            if (realiza != null) {
                session.delete(realiza);
                System.out.println("removido com sucesso!");
            }

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
       
    }
    
     public List<RealizaId> getAllRealizaId() {
        Transaction transaction = null;
        List<RealizaId> realiza = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            
           Query query = session.createQuery("FROM RealizaId");
            realiza = query.list();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return realiza;
    }
     
      public RealizaId getRealizaId(int codigo) {
        Transaction transaction = null;
        RealizaId realiza = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession(); 
            transaction = session.beginTransaction();
            realiza = (RealizaId) session.get(RealizaId.class, codigo);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return realiza;
    }
}
