package com.getman.repository;

import com.getman.domain.entity.Product;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.NamedQuery;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Sergii Getman
 */
public interface ProductRepository extends CrudRepository<Product, Long> {
    Iterable<Product> findByCategoryId(Long id);
    Iterable<Product> findByName(String name);
    Iterable<Product> findByPrice(BigDecimal price);
    Iterable<Product> findByLastUpdate(Date lastUpdate);
}
