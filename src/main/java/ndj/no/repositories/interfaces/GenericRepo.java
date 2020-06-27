package ndj.no.repositories.interfaces;

import com.sun.istack.NotNull;
import ndj.no.utils.Paging;

import javax.persistence.Query;
import java.util.List;

public interface GenericRepo<T> {

    List<T> getAll(@NotNull Paging page);

    T findById(int id);

    void save(T obj);

    void update(T obj);

    void delete(T obj);

    default T getSingleResult(Query query) {
        List<T> listResult = query.getResultList();
        if (listResult.size() > 0)
            return listResult.get(0);
        else
            return null;
    }
}
