package com.getman.service;

import com.getman.cart.ShoppingCart;
import com.getman.cart.ShoppingCartItem;
import com.getman.domain.entity.Customer;
import com.getman.domain.entity.CustomerOrder;
import com.getman.domain.entity.OrderedProduct;
import com.getman.domain.entity.OrderedProductPK;
import com.getman.domain.entity.Product;
import com.getman.repository.CustomerOrderRepository;
import com.getman.repository.CustomerRepository;
import com.getman.repository.OrderedProductRepository;
import com.getman.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * @author Sergii Getman
 */
@Service
public class OrderService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CustomerOrderRepository customerOrderRepository;
    @Autowired
    private OrderedProductRepository orderedProductRepository;
    @Autowired
    private CustomerRepository customerRepository;

    @Transactional
    public long placeOrder(String name, String email, String phone, String address, String cityRegion, String ccNumber, ShoppingCart cart) {
        Customer customer = addCustomer(name, email, phone, address, cityRegion, ccNumber);
        CustomerOrder order = addOrder(customer, cart);
        addOrderedItems(order, cart);
        return order.getId();

    }

    private Customer addCustomer(String name, String email, String phone, String address, String cityRegion, String ccNumber) {

        Customer customer = new Customer();
        customer.setName(name);
        customer.setEmail(email);
        customer.setPhone(phone);
        customer.setAddress(address);
        customer.setCityRegion(cityRegion);
        customer.setCcNumber(ccNumber);

        return customerRepository.save(customer);
    }

    private CustomerOrder addOrder(Customer customer, ShoppingCart cart) {

        // set up customer order
        CustomerOrder order = new CustomerOrder();
        order.setCustomer(customer);
        order.setAmount(BigDecimal.valueOf(cart.getTotal()));

        // create confirmation number
        Random random = new Random();
        int i = random.nextInt(999999999);
        order.setConfirmationNumber(i);

        return customerOrderRepository.save(order);
    }

    private void addOrderedItems(CustomerOrder order, ShoppingCart cart) {

        List<ShoppingCartItem> items = cart.getItems();

        // iterate through shopping cart and create OrderedProducts
        for (ShoppingCartItem scItem : items) {

            long productId = scItem.getProduct().getId();

            // set up primary key object
            OrderedProductPK orderedProductPK = new OrderedProductPK();
            orderedProductPK.setCustomerOrderId(order.getId());
            orderedProductPK.setProductId(productId);

            // create ordered item using PK object
            OrderedProduct orderedItem = new OrderedProduct(orderedProductPK);

            // set quantity
            orderedItem.setQuantity(scItem.getQuantity());

            orderedProductRepository.save(orderedItem);
        }
    }

    public Map getOrderDetails(long orderId) {

        Map orderMap = new HashMap();

        // get order
        CustomerOrder order = customerOrderRepository.findOne(orderId);

        // get customer
        Customer customer = order.getCustomer();

        // get all ordered products
        Iterable<OrderedProduct> orderedProducts = orderedProductRepository.findByCustomerOrderId(orderId);

        // get product details for ordered items
        List<Product> products = new ArrayList<Product>();

        for (OrderedProduct op : orderedProducts) {

            Product p = (Product) productRepository.findOne(op.getOrderedProductPK().getProductId());
            products.add(p);
        }

        // add each item to orderMap
        orderMap.put("orderRecord", order);
        orderMap.put("customer", customer);
        orderMap.put("orderedProducts", orderedProducts);
        orderMap.put("products", products);

        return orderMap;
    }
}
