package db;

import models.Paddock;
import models.Park;
import models.Visitor;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBVisitor {private static Transaction transaction;
    private static Session session;

    public static List<Visitor> allVisitors(Park park){
        session = HibernateUtil.getSessionFactory().openSession();
        List<Visitor> result = null;
        try{
            Criteria cr = session.createCriteria(Visitor.class);
            cr.add(Restrictions.eq("park", park));
            result = cr.list();
        } catch (HibernateException e){
            e.printStackTrace();
        } finally {
            session.close();
        }
        return result;
    }

}
