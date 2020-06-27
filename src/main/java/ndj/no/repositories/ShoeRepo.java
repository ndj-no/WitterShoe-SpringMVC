package ndj.no.repositories;

import ndj.no.entities.Shoe;
import ndj.no.repositories.interfaces.GenericRepo;
import ndj.no.utils.Paging;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional
public class ShoeRepo implements GenericRepo<Shoe> {
    SessionFactory sessionFactory;

    @Autowired
    public ShoeRepo(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Shoe> getAllByCategoryId(int categoryId) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Shoe where category.id = :id");
        query.setParameter("id", categoryId);

        List<Shoe> shoe = query.getResultList();
        loadChildList(shoe);

        return shoe;
    }

    public List<Shoe> sortByPrice(Paging page) {
        Session session = sessionFactory.getCurrentSession();
        String sql = "\n" +
                "SELECT \n" +
                "    shoe.id, \n" +
                "    shoe.shoeName, \n" +
                "    shoe.shoeThumbnail, \n" +
                "    shoe.active, \n" +
                "    shoe.quantitySold, \n" +
                "    shoe.viewCount, \n" +
                "    shoe.favouriteCount, \n" +
                "    shoe.dateCreated, \n" +
                "    shoe.shoeDesc, \n" +
                "    shoe.brand_id,\n" +
                "    shoe.category_id,\n" +
                "    shoe.shoeModel,\n" +
                "    shoe.dateModified,\n" +
                "    shoe.image_static,\n" +
                "    avg(detail_shoe.newPrice) as mean_price\n" +
                "FROM \n" +
                "    shoe inner join detail_shoe\n" +
                "       on shoe.id = detail_shoe.shoe_id\n" +
                "WHERE shoe.active = 1\n" +
                "GROUP BY " +
                "    shoe.id, \n" +
                "    shoe.shoeName, \n" +
                "    shoe.shoeThumbnail, \n" +
                "    shoe.active, \n" +
                "    shoe.quantitySold, \n" +
                "    shoe.viewCount, \n" +
                "    shoe.favouriteCount, \n" +
                "    shoe.dateCreated, \n" +
                "    shoe.shoeDesc, \n" +
                "    shoe.brand_id,\n" +
                "    shoe.category_id,\n" +
                "    shoe.shoeModel,\n" +
                "    shoe.dateModified,\n" +
                "    shoe.image_static\n" +
                "ORDER BY mean_price DESC\n" +
                "LIMIT :start_position , :number_result ;";

        Query query = session.createSQLQuery(sql).addEntity(Shoe.class);
        query.setParameter("start_position", page.getStartPosition());
        query.setParameter("number_result", page.getItemPerPage());

        List<Shoe> shoes = query.getResultList();
        loadChildList(shoes);

        return shoes;
    }

    @Override
    public List<Shoe> getAll(Paging page) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Shoe where isActive = true order by :order_by " + page.getSortType());
        query.setParameter("order_by", page.getOrderBy());
        query.setFirstResult(page.getStartPosition());
        query.setMaxResults(page.getItemPerPage());

        List<Shoe> shoes = query.getResultList();
        loadChildList(shoes);

        return shoes;
    }

    @Override
    public Shoe findById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Shoe where id = :id");
        query.setParameter("id", id);

        Shoe shoe = getSingleResult(query);
        loadChildList(shoe);

        return shoe;
    }

    public List<Shoe> findByName(String name, Paging page) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Shoe where isActive = true and name like ?1 order by ?2 " + page.getSortType());
        query.setParameter(1, "%" + name + "%");
        query.setParameter(2, page.getOrderBy());
        query.setMaxResults(page.getItemPerPage());
        query.setFirstResult(page.getStartPosition());

        List<Shoe> shoes = query.getResultList();
        loadChildList(shoes);

        return shoes;
    }

    @Override
    public void save(Shoe obj) {
        Session session = sessionFactory.getCurrentSession();
        session.save(obj);
    }

    @Override
    public void update(Shoe obj) {
        Session session = sessionFactory.getCurrentSession();
        session.update(obj);
    }

    @Override
    public void delete(Shoe obj) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(obj);
    }

    private void loadChildList(Shoe... shoes) {
        for (Shoe shoe : shoes) {
            shoe.getLstImages().size();
            shoe.getLstDetailShoe().size();
        }
    }

    private void loadChildList(List<Shoe> shoes) {
        for (Shoe shoe : shoes) {
            shoe.getLstImages().size();
            shoe.getLstDetailShoe().size();
        }
    }
}
