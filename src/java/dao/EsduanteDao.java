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
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Paulino
 */
public class EsduanteDao {

    
    
    public Estudante addEstudante(Estudante estudante) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();

            // Iniciar transação
            transaction = session.beginTransaction();

            // Salvar a estudante
            session.save(estudante);

            // Commit transação
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return estudante;
    }

    public Estudante updateEstudante(Estudante estudante) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();

            transaction = session.beginTransaction();
            session.update(estudante);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return estudante;
    }
    
    public void removeEstudante(int codigo) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
               
            transaction = session.beginTransaction();
            
            // Carregar a disciplina a ser removida
            Estudante estudante = (Estudante) session.get(Estudante.class, codigo);
            if (estudante != null) {
                session.delete(estudante);
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
    
     public List<Estudante> getAllEstudante() {
        Transaction transaction = null;
        List<Estudante> estudante = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            
           Query query = session.createQuery("FROM Estudante");
            estudante = query.list();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return estudante;
    }
     
      public Estudante getEstudante(int codigo) {
        Transaction transaction = null;
        Estudante estudante = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession(); 
            transaction = session.beginTransaction();
            estudante = (Estudante) session.get(Estudante.class, codigo);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return estudante;
    }
      public boolean existsEstudante(Estudante codigo) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession(); 
           Estudante estudante = (Estudante) session.get(Estudante.class, codigo);
            return estudante != null;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
      }

    public boolean existsEstudante(int nrMatriculaRealiza) {
        
         try {
            Session session = HibernateUtil.getSessionFactory().openSession(); 
           Estudante estudante = (Estudante) session.get(Estudante.class, nrMatriculaRealiza);
            return estudante != null;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        
    }
}
