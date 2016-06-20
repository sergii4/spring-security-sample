package com.getman.repository;

import com.getman.config.EmbeddedDbJpaConfig;
import com.getman.config.TestBeanConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

/**
 * @author Sergii Getman
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestBeanConfig.class, EmbeddedDbJpaConfig.class})
@Transactional
public class CustomerRepositoryTest {
    @Autowired
    private CustomerRepository customerRepository;
    

    @Test
    public void testFindByName() throws Exception {

    }

    @Test
    public void testFindByEmail() throws Exception {

    }

    @Test
    public void testFindByPhone() throws Exception {

    }

    @Test
    public void testFindByAddress() throws Exception {

    }

    @Test
    public void testFindByCityRegion() throws Exception {

    }

    @Test
    public void testFindByCcNumber() throws Exception {

    }
}