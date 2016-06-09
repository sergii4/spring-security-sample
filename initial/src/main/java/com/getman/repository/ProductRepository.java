package com.getman.repository;

import com.getman.domain.entity.Product;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Sergii Getman
 */
public interface ProductRepository extends CrudRepository<Product, Long> {
    Iterable<Product> findByCategoryId(Long id);
}
