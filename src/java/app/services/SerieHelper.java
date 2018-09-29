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

    Session session = null;

    public SerieHelper() {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }

    public List all() {
        List<Series> filmList = null;
        try {
            org.hibernate.Transaction tx = session.beginTransaction();
            Query q = session.createQuery ("from Series");
            filmList = (List<Series>) q.list();
            System.out.print(filmList);
            // session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
        finally {
            // HibernateUtil.getSessionFactory().getCurrentSession().close();
        }
        return filmList;
    }
    
    public Series create(String name, int year, double rate) {
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
