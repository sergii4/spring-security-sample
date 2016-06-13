package com.getman.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Sergii Getman
 */
@Controller
@RequestMapping("/purhase")
public class PurchaseController {
    @RequestMapping(method = RequestMethod.POST)
    public String purchase(@RequestParam String name, @RequestParam String email, @RequestParam String phone,
                           @RequestParam String address, @RequestParam String cityRegion, @RequestParam String creditcard) {
        return "";
    }
}
