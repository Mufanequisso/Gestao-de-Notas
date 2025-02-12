/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Avaliacao;
import model.Curso;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Paulino
 */
public class CursoDao {
    
    // Método para adicionar um novo curso
    public void addCurso(Curso curso) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
                
            transaction = session.beginTransaction();
            session.save(curso);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    // Método para atualizar um curso existente
    public void updateCurso(Curso curso) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
              
            transaction = session.beginTransaction();
            session.update(curso);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    // Método para remover um curso existente
    public void removeCurso(int codigo) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession(); 
            transaction = session.beginTransaction();
            
            // Carregar o curso a ser removido
            Curso curso = (Curso) session.get(Curso.class, codigo);
            if (curso != null) {
                session.delete(curso);
                System.out.println("Curso removido com sucesso!");
            }

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    // Método para buscar um curso pelo código
    public Curso getCurso(int codigo) {
        Transaction transaction = null;
        Curso curso = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession(); 
            transaction = session.beginTransaction();
            curso = (Curso) session.get(Curso.class, codigo);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return curso;
    }

    // Método para buscar todos os cursos
    public List<Curso> getAllCursos() {
        Transaction transaction = null;
        List<Curso> cursos = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Query query = session.createQuery("FROM Curso");
            cursos = query.list();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return cursos;
    }

    public boolean existsCurso(int codCurso) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession(); 
           Curso curso;
            curso = (Curso) session.get(Curso.class,codCurso);
            return curso != null;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        
    }
    
      public boolean existsCurso(Curso codCurso) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession(); 
           Curso curso;
            curso = (Curso) session.get(Curso.class,codCurso);
            return curso != null;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        
    }
    
}
