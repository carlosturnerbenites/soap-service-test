/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.services;

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
        } catch (Exception e) {
            e.printStackTrace();
        }
        return filmList;
    }
}
