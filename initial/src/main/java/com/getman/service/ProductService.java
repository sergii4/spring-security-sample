package com.getman.service;

import com.getman.domain.entity.Product;
import com.getman.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Sergii Getman
 */
@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    public Iterable<Product> listProductsByCategory(Long id) {
        return repository.findByCategoryId(id);
    }

    public Product retrieveProductById(Long productId) {
        return repository.findOne(productId);
    }
}
