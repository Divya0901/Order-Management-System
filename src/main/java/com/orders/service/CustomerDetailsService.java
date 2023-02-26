package com.orders.service;

import com.orders.dao.CustomerDetailsDao;
import com.orders.dao.OrderDetailsDao;
import com.orders.dto.CustomerDetailsDTO;
import com.orders.entity.CustomerDetails;
import com.orders.entity.OrderDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerDetailsService {

    @Autowired
    CustomerDetailsDao customerDetailsDao;

    @Autowired
    OrderDetailsDao orderDetailsDao;

    public CustomerDetails saveCustomerDetails(CustomerDetailsDTO customerDetailsDTO){
        CustomerDetails customerDetails = new CustomerDetails();
            OrderDetails orderDetails = new OrderDetails();
            customerDetails.setFullName(customerDetailsDTO.getFullName());
            customerDetails.setEmailId(customerDetailsDTO.getEmailId());
            customerDetails.setPhoneNumber(customerDetailsDTO.getPhoneNumber());
            customerDetails.setUserName(customerDetailsDTO.getUserName());
            customerDetails.setAddress(customerDetailsDTO.getAddress());

//            Integer customerId = customerDetailsDTO.getCustomerId();
//            Integer count = orderDetailsDao.countOrderDetailsByCustomerId(customerDetails.getCustomerId());
//            if(count == 10)
//                customerDetails.setCategory("Gold");
//            else if(count == 20)
//                customerDetails.setCategory("Platinum");
//            else
            customerDetails.setCategory("Regular");
           customerDetails = customerDetailsDao.save(customerDetails);
        return customerDetails;
    }


    public CustomerDetails getCustomerDetails(String emailId){
        CustomerDetails customerDetails;
        customerDetails = customerDetailsDao.findCustomerDetailsByEmailId(emailId);
        return  customerDetails;
    }
}
