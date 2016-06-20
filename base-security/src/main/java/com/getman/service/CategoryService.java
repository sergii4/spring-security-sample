package com.getman.service;

import com.getman.domain.entity.Category;
import com.getman.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Sergii Getman
 */
@Service
public class CategoryService {
    @Autowired
    private CategoryRepository repository;

    public Iterable<Category> listCategories() {
        return repository.findAll();
    }

    public Category retrieveCategoryById(Long id) {
        return repository.findOne(id);
    }
}
