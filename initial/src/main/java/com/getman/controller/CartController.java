package com.getman.controller;

import com.getman.cart.ShoppingCart;
import com.getman.domain.entity.Product;
import com.getman.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Sergii Getman
 */
@Controller
@SessionAttributes("cart")
public class CartController {
    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/viewCart", method = RequestMethod.GET)
    public String viewCart() {
        return "view/cart";
    }

    @RequestMapping(value = "/updateCart", method = RequestMethod.POST)
    public String updateCart() {
        return "view/cart";
    }

    @RequestMapping(value = "/addToCart", method = RequestMethod.POST)
    public ModelAndView addCart(@ModelAttribute ShoppingCart cart, @RequestParam Long productId) {
        ModelAndView modelAndView = new ModelAndView("view/cart");
        if (cart == null) {
            cart = new ShoppingCart();
        }
        Product product = productService.retrieveProductById(productId);
        cart.addItem(product);
        modelAndView.addObject("cart", cart);
        return modelAndView;
    }
}
