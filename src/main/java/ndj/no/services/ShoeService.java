package ndj.no.services;

import ndj.no.entities.DetailShoe;
import ndj.no.entities.Image;
import ndj.no.entities.Shoe;
import ndj.no.models.DetailShoeModel;
import ndj.no.models.ImageModel;
import ndj.no.models.ShoeModel;
import ndj.no.repositories.ShoeRepo;
import ndj.no.services.interfaces.GenericService;
import ndj.no.utils.Paging;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShoeService implements GenericService<ShoeModel> {
    private static final Logger logger = Logger.getLogger(ShoeService.class);

    private ShoeRepo shoeRepo;

    @Autowired
    public ShoeService(ShoeRepo shoeRepo) {
        this.shoeRepo = shoeRepo;
    }

    public List<ShoeModel> findRelated(ShoeModel shoeModel) {
        List<Shoe> shoes = shoeRepo.getAllByCategoryId(shoeModel.getCategoryModel().getId());
        List<ShoeModel> shoeModels = toShoeModels(shoes);
        return shoeModels;
    }

    public List<ShoeModel> sortByPrice(Paging page) {
        if (page == null)
            page = new Paging();
        List<Shoe> shoes = shoeRepo.sortByPrice(page);
        List<ShoeModel> shoeModels = shoes.stream().map(ShoeModel::new).collect(Collectors.toList());

        return shoeModels;
    }

    @Override
    public List<ShoeModel> getAll(Paging page) {
        if (page == null)
            page = new Paging();
        List<Shoe> shoes = shoeRepo.getAll(page);
        List<ShoeModel> shoeModels = toShoeModels(shoes);

        return shoeModels;
    }

    @Override
    public ShoeModel findById(int id) {
        Shoe shoe = shoeRepo.findById(id);

        ShoeModel shoeModel = toShoeModels(shoe);

        return shoeModel;
    }

    @Override
    public List<ShoeModel> findByName(String name, Paging page) {
        return null;
    }

    @Override
    public void save(ShoeModel obj) {

    }

    @Override
    public void update(ShoeModel obj) {

    }

    @Override
    public void delete(ShoeModel obj) {

    }


    private ShoeModel toShoeModels(Shoe shoe) {
        ShoeModel shoeModel = new ShoeModel(shoe);

        List<DetailShoe> detailShoes = shoe.getLstDetailShoe();
        List<Image> images = shoe.getLstImages();

        List<DetailShoeModel> detailShoeModels = detailShoes.stream().map(DetailShoeModel::new).collect(Collectors.toList());
        List<ImageModel> imageModels = images.stream().map(ImageModel::new).collect(Collectors.toList());

        shoeModel.setLstDetailShoeModels(detailShoeModels);
        shoeModel.setLstImageModels(imageModels);

//        logger.error(imageModels.size());

        return shoeModel;
    }

    private List<ShoeModel> toShoeModels(List<Shoe> shoes) {
        List<ShoeModel> shoeModels = new ArrayList<>();
        for (Shoe shoe : shoes) {
            shoeModels.add(toShoeModels(shoe));
        }
        return shoeModels;
    }
}
