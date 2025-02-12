/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Paulino
 */
public class HibernateUtil {

    private static SessionFactory factory;

    static {
        try {
            Configuration cfg = null;
            cfg = new Configuration();
            cfg.configure("hibernate.cfg.xml");

            factory = cfg.buildSessionFactory();

        } catch (HibernateException e) {

            e.printStackTrace();

        }

    }

    public static SessionFactory getSessionFactory() {

        return factory;
    }
    public static void closeSessionFactory(){
        if(factory!=null){
            
            factory.close();
        
        }else{
            return;
            
            }
       
        }
     public static void CloseSession(Session session){
         
         if(session!=null){
             
             session.close();
         
         }else{
             return;
         }
     
     }
    
    
}
