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
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Paulino
 */
public class DisciplinaDao {

    public void addDisciplina(Disciplina disciplina) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();

            // Iniciar transação
            transaction = session.beginTransaction();

            // Salvar a disciplina
            session.save(disciplina);

            // Commit transação
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void updateDisciplina(Disciplina disciplina) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();

            transaction = session.beginTransaction();
            session.update(disciplina);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
    
    public void removeDisciplina(int codigo) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
               
            transaction = session.beginTransaction();
            
            // Carregar a disciplina a ser removida
            Disciplina disciplina = (Disciplina) session.get(Disciplina.class, codigo);
            if (disciplina != null) {
                session.delete(disciplina);
                System.out.println("Disciplina removida com sucesso!");
            }

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
    
     public List<Disciplina> getAllDisciplinas() {
        Transaction transaction = null;
        List<Disciplina> disciplinas = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            
           Query query = session.createQuery("FROM Disciplina");
            disciplinas = query.list();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return disciplinas;
    }
            // Método para buscar um avaliacao pelo código
    public Disciplina getDisciplina(int codigo) {
        Transaction transaction = null;
       Disciplina disciplina = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession(); 
            transaction = session.beginTransaction();
            disciplina = (Disciplina) session.get(Disciplina.class, codigo);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return disciplina;
    }
 public boolean existsDisciplina (int codigo) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession(); 
           Disciplina  disciplina;
            disciplina = (Disciplina) session.get(Disciplina.class,codigo);
            return disciplina != null;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        
    }
    
       public boolean existsDisciplina (Disciplina codigo) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession(); 
           Disciplina  disciplina;
            disciplina = (Disciplina) session.get(Disciplina.class,codigo);
            return disciplina != null;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        
    }

}
