package pl.s13302.mas.manager;

import org.hibernate.Query;
import org.hibernate.Session;
import pl.s13302.mas.base.BaseObject;
import pl.s13302.mas.utils.HibernateUtil;

import java.util.List;

public interface Manager<T extends BaseObject> {

    String className();

    default List<T> list() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List<T> result = session.createQuery("from " + className()).list();
        session.getTransaction().commit();
        return result;
    }

    default T getById(Long id) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("from " + className() + " item WHERE item.id = :id");
        query.setParameter("id", id);
        T result = (T) query.uniqueResult();
        session.getTransaction().commit();
        return result;
    }

    default void save(T entity) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(entity);
        session.getTransaction().commit();
    }

}
