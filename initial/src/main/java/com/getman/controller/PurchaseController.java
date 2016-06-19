package com.getman.controller;

import com.getman.cart.ShoppingCart;
import com.getman.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.Map;

/**
 * @author Sergii Getman
 */
@Controller
@RequestMapping("/purchase")
@SessionAttributes({"cart"})
public class PurchaseController {
    @Autowired
    private OrderService orderService;

    @RequestMapping(method = RequestMethod.POST)
    public String purchase(Model model, @RequestParam String name, @RequestParam String email, @RequestParam String phone,
                           @RequestParam String address, @RequestParam String cityRegion, @RequestParam String creditcard) {
        ShoppingCart cart = (ShoppingCart) model.asMap().get("cart");
        long orderId = orderService.placeOrder(name, email, phone, address, cityRegion, creditcard, cart);
        // get order details
        Map orderMap = orderService.getOrderDetails(orderId);

        // place order details in request scope
        model.addAttribute("customer", orderMap.get("customer"));
        model.addAttribute("products", orderMap.get("products"));
        model.addAttribute("orderRecord", orderMap.get("orderRecord"));
        model.addAttribute("orderedProducts", orderMap.get("orderedProducts"));

        return "view/confirmation";
    }
}
