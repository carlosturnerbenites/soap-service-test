/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.services;

import java.math.BigDecimal;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author kohaku
 */
public class SerieHelper {
    public List all(String fieldSort, String dirSort) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        List<Series> seriesList = null;
        try {
            org.hibernate.Transaction tx = session.beginTransaction();
            Query q = session.createQuery ("from Series order by " + fieldSort + " " + dirSort); // .setParameter("fieldSort", fieldSort).setParameter("dirSort", dirSort);
            System.out.print(q);
            seriesList = (List<Series>) q.list();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
        return seriesList;
    }

    public Series findById(int id) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        Series seriesObject = null;
        try {
            org.hibernate.Transaction tx = session.beginTransaction();
            Query q = session.createQuery ("from Series WHERE id = :id").setParameter("id", id);
            seriesObject = (Series)q.uniqueResult();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
        return seriesObject;
    }
    
    public Series updateById(int id, String name, int rate, int episodes, String malLink, String malImg) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        
        Query q = session.createQuery ("from Series WHERE id = :id").setParameter("id", id);
        Series emp = (Series)q.uniqueResult();

        emp.setName(name);
        emp.setRate(rate);
        emp.setEpisodes(episodes);
        emp.setMalLink(malLink);
        emp.setMalImg(malImg);

        session.save(emp);
 
        session.getTransaction().commit();
        
        return emp;
    }
    
    public Series deleteById(int id) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        
        //Add new Employee object

        Query q = session.createQuery ("from Series WHERE id = :id").setParameter("id", id);
        Series emp = (Series)q.uniqueResult();
        
        session.delete(emp);
 
        //Commit the transaction
        session.getTransaction().commit();
        
        return emp;
    }
    
    public Series create(String name, int rate, int episodes, String malLink, String malImg) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        
        //Add new Employee object
        Series emp = new Series();
        emp.setName(name);
        emp.setRate(rate);
        emp.setEpisodes(episodes);
        emp.setMalLink(malLink);
        emp.setMalImg(malImg);
         
        //Save the employee in database
        session.save(emp);
 
        //Commit the transaction
        session.getTransaction().commit();
        
        return emp;
    }
}
