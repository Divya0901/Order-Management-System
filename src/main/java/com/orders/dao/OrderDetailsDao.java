package com.orders.dao;

import com.orders.entity.CustomerDetails;
import com.orders.entity.OrderDetails;
import com.orders.entity.ProductDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDetailsDao extends JpaRepository<OrderDetails, Integer> {

    List<OrderDetails> findOrderDetailsByCustomerId(CustomerDetails customerDetails);
    List<OrderDetails> findOrderDetailsByCustomerIdAndProductId(CustomerDetails customerDetails, ProductDetails productDetails);

}
