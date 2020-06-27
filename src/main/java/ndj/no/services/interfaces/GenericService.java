package ndj.no.services.interfaces;

import com.sun.istack.NotNull;
import com.sun.istack.Nullable;
import ndj.no.utils.Paging;

import java.util.List;

public interface GenericService<T> {

    List<T> getAll(@NotNull Paging page);

    @Nullable
    T findById(int id);

    @Nullable
    List<T> findByName(String name, @NotNull Paging page);

    void save(T obj);

    void update(T obj);

    void delete(T obj);
}
