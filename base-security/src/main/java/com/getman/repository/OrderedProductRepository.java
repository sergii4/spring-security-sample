package com.getman.repository;

import com.getman.domain.entity.OrderedProduct;
import com.getman.domain.entity.OrderedProductPK;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Sergii Getman
 */
public interface OrderedProductRepository extends CrudRepository<OrderedProduct, OrderedProductPK> {
    Iterable<OrderedProduct> findByCustomerOrderId(Long id);
    Iterable<OrderedProduct> findByProductId(Long id);
    Iterable<OrderedProduct> findByQuantity(Integer quantity);
}
