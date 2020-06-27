package ndj.no.services;

import ndj.no.entities.Category;
import ndj.no.models.CategoryModel;
import ndj.no.repositories.CategoryRepo;
import ndj.no.services.interfaces.GenericService;
import ndj.no.utils.Paging;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService implements GenericService<CategoryModel> {

    private static final Logger logger = Logger.getLogger(CategoryService.class);

    private CategoryRepo categoryRepo;

    @Autowired
    public CategoryService(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    @Override
    public List<CategoryModel> getAll(Paging page) {
        List<Category> categories = categoryRepo.getAll(page);
        List<CategoryModel> categoryModels = categories.stream().map(CategoryModel::new).collect(Collectors.toList());

        return categoryModels;
    }

    @Override
    public CategoryModel findById(int id) {

        return null;
    }

    public List<CategoryModel> findByName(String name, Paging page) {
        return null;
    }

    @Override
    public void save(CategoryModel obj) {

    }

    @Override
    public void update(CategoryModel obj) {

    }

    @Override
    public void delete(CategoryModel obj) {

    }
}
