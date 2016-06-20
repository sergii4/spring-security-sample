package com.getman.controller;

import com.getman.service.ProductService;
import com.getman.domain.entity.Category;
import com.getman.domain.entity.Product;
import com.getman.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;
import java.util.Optional;

/**
 * @author Sergii Getman
 */
@Controller
@RequestMapping("/category")
@SessionAttributes({"categories", "selectedCategory", "products", "cart"})
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductService productService;

    @Autowired
    ServletContext context;

    @ModelAttribute("categories")
    public Iterable<Category> getCategories(){
        return categoryService.listCategories();
    }

    @PostConstruct
    public void init() {
        context.setAttribute("categories", getCategories());
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView showCategory(@RequestParam(value = "id", required = false) Optional<Long> id) {
        ModelAndView modelAndView = new ModelAndView("view/category");
        if (id.isPresent()) {
            Iterable<Product> products = productService.listProductsByCategory(id.get());
            Category selectedCategory = categoryService.retrieveCategoryById(id.get());
            modelAndView.addObject("selectedCategory", selectedCategory);
            modelAndView.addObject("products", products);
        }
        return modelAndView;
    }

}
