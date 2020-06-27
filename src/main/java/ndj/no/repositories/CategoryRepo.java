package ndj.no.repositories;

import ndj.no.entities.Category;
import ndj.no.repositories.interfaces.GenericRepo;
import ndj.no.utils.Paging;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional
public class CategoryRepo implements GenericRepo<Category> {

    private static final Logger logger = Logger.getLogger(CategoryRepo.class);

    SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Category> getAll(Paging page) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Category ").getResultList();
    }

    @Override
    public Category findById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Category c where c.id = :id");
        query.setParameter("id", id);
        List<Category> list = query.getResultList();
        if (list.size() > 0)
            return list.get(0);
        else
            return null;
    }

    public List<Category> findByName(String name, Paging page) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Category where name like ?1 order by ?2 ?3");
        query.setParameter(1, "%" + name + "%");
        query.setParameter(2, page.getOrderBy());
        query.setParameter(3, page.getSortType());
        return query.getResultList();
    }

    @Override
    public void save(Category obj) {
        sessionFactory.getCurrentSession().save(obj);
    }

    @Override
    public void update(Category obj) {
        sessionFactory.getCurrentSession().update(obj);
    }

    @Override
    public void delete(Category obj) {
        sessionFactory.getCurrentSession().delete(obj);
    }
}
