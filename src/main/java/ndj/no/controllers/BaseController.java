package ndj.no.controllers;

import ndj.no.models.CategoryModel;
import ndj.no.models.ShoeModel;
import ndj.no.services.CategoryService;
import ndj.no.services.ShoeService;
import ndj.no.utils.Paging;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Map;

public abstract class BaseController {
    public Map<String, Object> getHeaderData() {
        return null;
    }

    /**
     * 3 products sort by favorite count
     *
     * @param model
     * @param categoryService
     * @param shoeService
     */
    public void addSideBarData(Model model, CategoryService categoryService, ShoeService shoeService) {
        List<CategoryModel> sidebar_categories = categoryService.getAll(new Paging());
        List<ShoeModel> sidebar_shoes = shoeService.getAll(
                new Paging(3, 1, ShoeModel.FAVOURITE_COUNT, Paging.DESC)
        );
        model.addAttribute("sidebar_categories", sidebar_categories);
        model.addAttribute("sidebar_shoes", sidebar_shoes);
    }
}
