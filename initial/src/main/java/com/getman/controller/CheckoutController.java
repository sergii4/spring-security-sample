package com.getman.controller;

import com.getman.cart.ShoppingCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;

/**
 * @author Sergii Getman
 */
@Controller
@RequestMapping("/checkout")
@SessionAttributes({"cart"})
public class CheckoutController {

    @Autowired
    ServletContext context;

    @Value("${deliverySurcharge}")
    private String surcharge;

    @PostConstruct
    public void init() {
        context.setAttribute("deliverySurcharge", surcharge);
    }

    @RequestMapping(method = RequestMethod.GET)
    public String checkout(Model model) {
        ShoppingCart cart;
        if (model.containsAttribute("cart")) {
            cart = (ShoppingCart) model.asMap().get("cart");
            cart.calculateTotal(surcharge);
        } else {
            cart = new ShoppingCart();
            model.addAttribute("cart", cart);
        }
        return "view/checkout";
    }
}
