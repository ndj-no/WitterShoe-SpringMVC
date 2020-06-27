package ndj.no.controllers.client;

import ndj.no.controllers.BaseController;
import ndj.no.models.ShoeModel;
import ndj.no.services.CategoryService;
import ndj.no.services.ShoeService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/products")
public class DetailProductController extends BaseController {
    private static final Logger logger = Logger.getLogger(DetailProductController.class);

    private static final String DETAIL_PAGE = "client/detail_product";

    private ShoeService shoeService;
    private CategoryService categoryService;

    @Autowired
    public DetailProductController(ShoeService shoeService, CategoryService categoryService) {
        this.shoeService = shoeService;
        this.categoryService = categoryService;
    }

    @GetMapping("/{product_id}")
    public String detailProduct(@PathVariable("product_id") String id, Model model) {
        addSideBarData(model, categoryService, shoeService);

        ShoeModel product = shoeService.findById(Integer.parseInt(id));
        List<ShoeModel> relatedProducts = shoeService.findRelated(product);

        model.addAttribute("product", product);
        model.addAttribute("relatedProducts", relatedProducts);

        return DETAIL_PAGE;
    }


}
