package com.orders.dao;

import com.orders.entity.ProductDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDetailsDao extends JpaRepository<ProductDetails, Integer> {

    ProductDetails findProductDetailsByProductId(Integer id);
}
