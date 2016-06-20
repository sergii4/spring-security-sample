package com.getman.repository;

import com.getman.config.EmbeddedDbJpaConfig;
import com.getman.config.TestBeanConfig;
import com.getman.domain.entity.Category;
import com.getman.domain.entity.Product;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Sergii Getman
 */
public class BaseRepositoryTest {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ProductRepository productRepository;

    protected Category createCategory() {
        Category category = new Category("dairy");
        return categoryRepository.save(category);
    }

    protected Product createProduct() {
        Category createdCategory = createCategory();
        Product product = new Product("milk");
        product.setCategory(createdCategory);
        return productRepository.save(product);
    }
}
