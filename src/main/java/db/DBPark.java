package db;

import models.Paddock;
import models.Park;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBPark {

    private static Session session;

    public static List<Paddock> allPaddocks(Park park){
        session = HibernateUtil.getSessionFactory().openSession();
        List<Paddock> result = null;
        try{
            Criteria cr = session.createCriteria(Paddock.class);
            cr.add(Restrictions.eq("id", park.getId()));
            result = cr.list();
        } catch (HibernateException e){
            e.printStackTrace();
        } finally {
            session.close();
        }
        return result;
    }
}
