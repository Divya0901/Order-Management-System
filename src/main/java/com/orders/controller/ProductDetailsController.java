package com.orders.controller;

import com.orders.dto.ProductDetailsDTO;
import com.orders.dto.ResponseDTO;
import com.orders.entity.ProductDetails;
import com.orders.service.ProductDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductDetailsController {

    @Autowired
    ProductDetailsService productDetailsService;

    @PostMapping("/saveProductDetails")

    public ResponseEntity<ResponseDTO> saveProducts(@RequestBody ProductDetailsDTO productDetailsDTO){
        ResponseDTO responseDTO = new ResponseDTO();
        ProductDetails productDetails = productDetailsService.saveProductDetails(productDetailsDTO);
        responseDTO.setStatus("Success");
        responseDTO.setStatusCode("200");
        responseDTO.setMessage("Product details saved");
        responseDTO.setData(productDetails);
        return new ResponseEntity(responseDTO, HttpStatus.OK);
    }
}
