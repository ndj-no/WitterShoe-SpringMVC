package ndj.no.repositories;

import ndj.no.entities.User;
import ndj.no.repositories.interfaces.GenericRepo;
import ndj.no.utils.Paging;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public class UserRepo implements GenericRepo<User> {

    SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<User> getAll(Paging page) {
        return null;
    }

    @Override
    public User findById(int id) {
        return null;
    }

    public List<User> findByName(String name, Paging page) {
        return null;
    }

    @Override
    public void save(User obj) {

    }

    @Override
    public void update(User obj) {

    }

    @Override
    public void delete(User obj) {

    }
}
