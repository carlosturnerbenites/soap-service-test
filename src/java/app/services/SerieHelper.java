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
    public List all() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        List<Series> seriesList = null;
        try {
            org.hibernate.Transaction tx = session.beginTransaction();
            Query q = session.createQuery ("from Series");
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
    
    public Series updateById(int id, String name, int year, double rate) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        
        //Add new Employee object
        Query q = session.createQuery ("from Series WHERE id = :id").setParameter("id", id);
        Series emp = (Series)q.uniqueResult();

        emp.setName(name);
        emp.setRate(new BigDecimal(rate));
        emp.setYear(year);
         
        //Save the employee in database
        session.save(emp);
 
        //Commit the transaction
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
    
    public Series create(String name, int year, double rate) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        
        //Add new Employee object
        Series emp = new Series();
        emp.setName(name);
        emp.setRate(new BigDecimal(rate));
        emp.setYear(year);
         
        //Save the employee in database
        session.save(emp);
 
        //Commit the transaction
        session.getTransaction().commit();
        
        return emp;
    }
}
