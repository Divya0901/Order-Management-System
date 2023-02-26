package com.orders.controller;

import com.orders.dao.CustomerDetailsDao;
import com.orders.dao.OrderDetailsDao;
import com.orders.dao.ProductDetailsDao;
import com.orders.dto.DiscountPercenatgeDTO;
import com.orders.dto.OrderDetailsDTO;
import com.orders.dto.ResponseDTO;
import com.orders.entity.CustomerDetails;
import com.orders.entity.OrderDetails;
import com.orders.entity.ProductDetails;
import com.orders.service.OrderDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.text.ParseException;
import java.util.List;

@RestController
public class OrderDetailsController {

    @Autowired
    OrderDetailsService orderDetailsService;
    @Autowired
    OrderDetailsDao orderDetailsDao;

    @Autowired
    ProductDetailsDao productDetailsDao;

    @Autowired
    CustomerDetailsDao customerDetailsDao;

    @PostMapping("/saveOrderDetails")
    public ResponseEntity<ResponseDTO> saveOrderDetails(@RequestBody OrderDetailsDTO orderDetailsDTO) throws ParseException {
        ResponseDTO responseDTO = new ResponseDTO();

        ProductDetails productDetails = productDetailsDao.findProductDetailsByProductId(orderDetailsDTO.getProductId());
        CustomerDetails customerDetails = customerDetailsDao.findCustomerDetailsByCustomerId(orderDetailsDTO.getCustomerId());
        List<OrderDetails> orderDetailsList = orderDetailsDao.findOrderDetailsByCustomerIdAndProductId(customerDetails,productDetails);
        if(!CollectionUtils.isEmpty(orderDetailsList) && orderDetailsList.size() > 5) {
            responseDTO.setStatus("Success");
            responseDTO.setStatusCode("200");
            responseDTO.setMessage("Order Limit exceeded for this Product by this customerId: " + orderDetailsDTO.getCustomerId());
            return new ResponseEntity<>(responseDTO,HttpStatus.OK);
        }
        OrderDetails orderDetails =  orderDetailsService.saveOrderDetails(orderDetailsDTO);
        responseDTO.setStatus("Success");
        responseDTO.setStatusCode("200");
        responseDTO.setMessage("Data saved successfully");
        responseDTO.setData(orderDetails);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/getDiscountPercenatge")
    public ResponseEntity<List<DiscountPercenatgeDTO>> getDiscountPercenatge(@RequestBody OrderDetailsDTO orderDetailsDTO){
        List<DiscountPercenatgeDTO> discountPercenatgeDTO = orderDetailsService.getDiscountPercenatge(orderDetailsDTO);
    return new ResponseEntity<>(discountPercenatgeDTO,HttpStatus.OK);
    }
}
