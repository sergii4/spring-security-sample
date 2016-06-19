package com.getman.repository;

import com.getman.domain.entity.Customer;
import com.getman.domain.entity.CustomerOrder;
import com.getman.domain.entity.OrderedProduct;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Sergii Getman
 */
public interface CustomerOrderRepository extends CrudRepository<CustomerOrder, Long> {
    Iterable<OrderedProduct> findByCustomer(Customer customer);
    Iterable<OrderedProduct> findByAmount(BigDecimal amount);
    Iterable<OrderedProduct> findByDateCreated(Date dateCreated);
    Iterable<OrderedProduct> findByConfirmationNumber(int confirmationNumber);
}
