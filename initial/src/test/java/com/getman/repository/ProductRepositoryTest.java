package com.getman.repository;

import com.getman.config.EmbeddedDbJpaConfig;
import com.getman.config.TestBeanConfig;
import com.getman.domain.entity.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * @author Sergii Getman
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestBeanConfig.class, EmbeddedDbJpaConfig.class})
public class ProductRepositoryTest extends BaseRepositoryTest{
    @Autowired
    private ProductRepository productRepository;

    @Test
    public void testCreate() {
        Product createdProduct = createProduct();
        Product foundProduct = productRepository.findOne(createdProduct.getId());
        assertEquals(createdProduct.getName(), foundProduct.getName());

    }

    @Test
    public void testDelete() {
        Product createdProduct = createProduct();
        productRepository.delete(createdProduct.getId());
        Product foundCategory = productRepository.findOne(createdProduct.getId());
        assertNull(foundCategory);
    }

    @Test
    public void testFindByCategoryId() {
        Product createdProduct = createProduct();
        Product foundProduct = productRepository.findByCategoryId(createdProduct.getCategory().getId()).iterator().next();
        assertEquals(createdProduct.getName(), foundProduct.getName());
    }
}