package com.getman.repository;

import com.getman.config.EmbeddedDbJpaConfig;
import com.getman.config.TestBeanConfig;
import com.getman.domain.entity.Category;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

/**
 * @author Sergii Getman
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestBeanConfig.class, EmbeddedDbJpaConfig.class})
@Transactional
public class CategoryRepositoryTest extends BaseRepositoryTest {

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    public void testCreate() {
        Category createdCategory = createCategory();
        Category foundCategory = categoryRepository.findOne(createdCategory.getId());
        assertEquals(createdCategory.getName(), foundCategory.getName());

    }


    @Test
    public void testDelete() {
        Category createdCategory = createCategory();
        categoryRepository.delete(createdCategory.getId());
        Category foundCategory = categoryRepository.findOne(createdCategory.getId());
        assertNull(foundCategory);
    }

}