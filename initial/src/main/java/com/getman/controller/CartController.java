package com.getman.controller;

import com.getman.cart.ShoppingCart;
import com.getman.domain.entity.Product;
import com.getman.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

/**
 * @author Sergii Getman
 */
@Controller
@SessionAttributes({"cart", "selectedCategory"})
public class CartController {
    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/viewCart", method = RequestMethod.GET)
    public String viewCart(Model model, @RequestParam Optional<Boolean> clear) {
        //we have setted cart as session attribute and can access it from model
        ShoppingCart cart;
        if (model.containsAttribute("cart")) {
            if (clear.isPresent() && clear.get()) {
                cart = (ShoppingCart) model.asMap().get("cart");
                cart.clear();
            }
        } else {
            cart = new ShoppingCart();
            model.addAttribute("cart", cart);
        }
        return "view/cart";
    }

    @RequestMapping(value = "/updateCart", method = RequestMethod.POST)
    public String updateCart(Model model, @RequestParam Long productId, @RequestParam Integer quantity) {
        Product product = productService.retrieveProductById(productId);
        ShoppingCart cart = (ShoppingCart) model.asMap().get("cart");
        cart.update(product, quantity);
        return "view/cart";
    }

    @RequestMapping(value = "/addToCart", method = RequestMethod.POST)
    public String addCart(Model model, @RequestParam Long productId) {
        ShoppingCart cart;
        if (model.containsAttribute("cart")) {
            cart = (ShoppingCart) model.asMap().get("cart");
        } else {
            cart = new ShoppingCart();
            model.addAttribute("cart", cart);
        }
        Product product = productService.retrieveProductById(productId);
        cart.addItem(product);
        return "redirect:category";
    }
}
