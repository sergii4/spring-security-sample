package com.getman.repository;

import com.getman.domain.entity.Customer;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Sergii Getman
 */
public interface CustomerRepository extends CrudRepository<Customer, Long> {
    Iterable<Customer> findByName(String name);
    Iterable<Customer> findByEmail(String name);
    Iterable<Customer> findByPhone(String phone);
    Iterable<Customer> findByAddress(String address);
    Iterable<Customer> findByCityRegion(String cityRegion);
    Iterable<Customer> findByCcNumber(String ccNumber);
}
