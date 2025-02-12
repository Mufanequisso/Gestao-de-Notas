/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Avaliacao;
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
public class RealizaDao {
     public void addRealiza(Realiza realiza) {
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
        
    }

    public Realiza updateRealiza(Realiza realiza) {
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
            Realiza realiza = (Realiza) session.get(Realiza.class, codigo);
            if (realiza != null) {
                session.delete(realiza);
                System.out.println("estudnTE removida com sucesso!");
            }

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
       
    }
    
     public List<Realiza> getAllRealiza() {
        Transaction transaction = null;
        List<Realiza> realiza = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            
           Query query = session.createQuery("FROM Realiza");
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
     
      public Realiza getRealiza(int codigo) {
        Transaction transaction = null;
        Realiza realiza = null;
        
        try {
            Session session = HibernateUtil.getSessionFactory().openSession(); 
            transaction = session.beginTransaction();
            realiza = (Realiza) session.get(Estudante.class, codigo);
            
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return realiza;
    }
      
      
      public boolean existsRealiza(RealizaId realiza) {
        try {
            
            Session session = HibernateUtil.getSessionFactory().openSession(); 
            realiza = (RealizaId) session.get(RealizaId.class, realiza);
            return realiza != null;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean getRealiza (Realiza realiza) {
        
     try {
            
            Session session = HibernateUtil.getSessionFactory().openSession(); 
            realiza = (Realiza) session.get(Realiza.class, realiza);
            return realiza != null;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        
    }

    public void removeRealiza(RealizaId realiza) {
        
         Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
               
            transaction = session.beginTransaction();
            
            // Carregar a disciplina a ser removida
            realiza = (RealizaId) session.get(RealizaId.class, realiza);
            if (realiza != null) {
                session.delete(realiza);
                System.out.println("estudnTE removida com sucesso!");
            }

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        
    }
}