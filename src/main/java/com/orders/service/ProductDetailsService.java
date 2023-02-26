package com.orders.service;

import com.orders.dao.ProductDetailsDao;
import com.orders.dto.ProductDetailsDTO;
import com.orders.entity.ProductDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductDetailsService {

    @Autowired
    ProductDetailsDao productDetailsDao;

    public ProductDetails saveProductDetails(ProductDetailsDTO productDetailsDTO){

        ProductDetails productDetails = new ProductDetails();
            productDetails.setProductName(productDetailsDTO.getProductName());
            productDetails.setPrice(productDetailsDTO.getPrice());
            productDetailsDao.save(productDetails);
        return productDetails;
    }
}
