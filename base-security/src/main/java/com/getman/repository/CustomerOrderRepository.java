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
    Iterable<CustomerOrder> findByCustomer(Customer customer);
    Iterable<CustomerOrder> findByAmount(BigDecimal amount);
    Iterable<CustomerOrder> findByDateCreated(Date dateCreated);
    Iterable<CustomerOrder> findByConfirmationNumber(int confirmationNumber);
}
