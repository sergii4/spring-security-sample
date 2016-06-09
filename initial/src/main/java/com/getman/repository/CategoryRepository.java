package com.getman.repository;

import com.getman.domain.entity.Category;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Sergii Getman
 */
public interface CategoryRepository extends CrudRepository<Category, Long> {
}
