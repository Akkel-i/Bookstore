package hh.sof3.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hh.sof3.bookstore.domain.Book;
import hh.sof3.bookstore.domain.Category;
import hh.sof3.bookstore.domain.CategoryRepository;

@Controller
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    // http://localhost:8080/categorylist
    @RequestMapping(value = "/categorylist", method = RequestMethod.GET)
    public String getCategories(Model model) {

        model.addAttribute("categories", categoryRepository.findAll());

        return "categorylist"; // categorylist.html
    }

    // http:localhost:8080/addcategory
    @RequestMapping(value = "/newcategory", method = RequestMethod.GET)
    public String getNewCategoryForm(Model model) {

        // luo tyhjä uusi category-olio hakemukselle
        model.addAttribute("category", new Category());

        return "addcategory"; // addcategory.html
    }

    @RequestMapping(value = "/savecategory", method = RequestMethod.POST)
    public String saveNewCategory(Category newCategory, Model model) {

        // tallentaa uuden Book DB
        categoryRepository.save(newCategory);
        // palaa endpoint/categorylist (GET)
        return "redirect:/categorylist";
    }
}
