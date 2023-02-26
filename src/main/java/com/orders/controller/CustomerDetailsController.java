package com.orders.controller;

import com.orders.dto.CustomerDetailsDTO;
import com.orders.entity.CustomerDetails;
import com.orders.service.CustomerDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerDetailsController {

    @Autowired
    CustomerDetailsService customerDetailsService;

    @PostMapping("/createCustomer")
    public ResponseEntity saveCustomerDetails(@RequestBody CustomerDetailsDTO customerDetailsDTO){
        CustomerDetails customerDetails;

        try{
            if(!ObjectUtils.isEmpty(customerDetailsDTO) ){
                customerDetails = customerDetailsService.saveCustomerDetails(customerDetailsDTO);
                return new ResponseEntity<>( customerDetails, HttpStatus.OK);
            }
            else {
                return new ResponseEntity<>("Customer already exists", HttpStatus.OK);
            }

        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/getCustomerDetails/{emailId}")
    public ResponseEntity getCustomerDetails(@PathVariable String emailId){
        CustomerDetails customerDetails;

        customerDetails = customerDetailsService.getCustomerDetails(emailId);
        return new ResponseEntity<>(customerDetails, HttpStatus.OK);
    }

}
