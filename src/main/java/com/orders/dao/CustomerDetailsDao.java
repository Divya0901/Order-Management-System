package com.orders.dao;


import com.orders.dto.CustomerDetailsDTO;
import com.orders.entity.CustomerDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDetailsDao extends JpaRepository<CustomerDetails, Integer> {

    CustomerDetails findCustomerDetailsByCustomerId(Integer id);

    CustomerDetails findCustomerDetailsByEmailId(String emailId);

}
