package com.getman.controller;

import com.getman.domain.entity.Customer;
import com.getman.domain.entity.CustomerOrder;
import com.getman.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sergii Getman
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private CustomerRepository customerRepository;

    private String userPath;
    private Customer customer;
    private CustomerOrder order;
    private Iterable<CustomerOrder> orderList = new ArrayList();
    private Iterable<Customer> customerList = new ArrayList();

    @RequestMapping(method = RequestMethod.GET)
    public String viewAdminPage() {
        return "admin/index";
    }

    @RequestMapping(value = "viewCustomers",method = RequestMethod.GET)
    public String viewCustomers(Model model) {
        customerList = customerRepository.findAll();
        model.addAttribute("customerList", customerList);
        return "admin/index";
    }
}
