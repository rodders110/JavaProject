package db;

import com.sun.xml.internal.ws.handler.HandlerException;
import models.Dinosaur;
import models.Paddock;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import javax.persistence.Id;
import javax.persistence.OrderBy;
import java.util.List;

public class DBDino {

    private static Session session;

    public static List<Dinosaur> allDinosInPaddock (Paddock paddock){
        session = HibernateUtil.getSessionFactory().openSession();
        List<Dinosaur> results = null;
        try{
            Criteria cr = session.createCriteria(Dinosaur.class);
            cr.add(Restrictions.eq("id", paddock.getId()));
            cr.addOrder(Order.desc("id"));
            results = cr.list();
        } catch(HandlerException e){
            e.printStackTrace();
        } finally {
            session.close();
        }
        return results;
    }
}
