package ndj.no.controllers;

import ndj.no.models.ShoeModel;
import ndj.no.services.CategoryService;
import ndj.no.services.ShoeService;
import ndj.no.utils.Paging;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController extends BaseController {
    private static final Logger logger = Logger.getLogger(HomeController.class);

    private ShoeService shoeService;
    private CategoryService categoryService;

    @Autowired
    public HomeController(ShoeService shoeService, CategoryService categoryService) {
        this.shoeService = shoeService;
        this.categoryService = categoryService;
    }

    @GetMapping
    public String home(Model model) {
        addSideBarData(model, this.categoryService, shoeService);

        // carousel products
        // the most expensive products
        List<ShoeModel> expensiveProducts = shoeService.sortByPrice(new Paging(3, 1, null, null));

        // new Products
        List<ShoeModel> newProducts1 = shoeService.getAll(new Paging(8, 1, ShoeModel.DATE_CREATED, Paging.DESC));
        List<ShoeModel> newProducts2 = shoeService.getAll(new Paging(3, 1, ShoeModel.DATE_MODIFIED, Paging.DESC));

        // featured products
        // the best sold
        List<ShoeModel> bestSoldProducts = shoeService.getAll(new Paging(3, 1, ShoeModel.QUANTITY_SOLD, Paging.DESC));

        model.addAttribute("expensiveProducts", expensiveProducts);
        model.addAttribute("newProducts1", newProducts1);
        model.addAttribute("newProducts2", newProducts2);
        model.addAttribute("bestSoldProducts", bestSoldProducts);
        return "home";
    }
}
