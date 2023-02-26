package com.orders.service;

import com.orders.dao.CustomerDetailsDao;
import com.orders.dao.OrderDetailsDao;
import com.orders.dao.ProductDetailsDao;
import com.orders.dto.DiscountPercenatgeDTO;
import com.orders.dto.OrderDetailsDTO;
import com.orders.entity.CustomerDetails;
import com.orders.entity.OrderDetails;
import com.orders.entity.ProductDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.*;


@Service
public class OrderDetailsService {

    @Autowired
    OrderDetailsDao orderDetailsDao;

    @Autowired
    ProductDetailsDao productDetailsDao;

    @Autowired
    CustomerDetailsDao customerDetailsDao;


    public OrderDetails saveOrderDetails(OrderDetailsDTO orderDetailsDTO) throws ParseException {
        OrderDetails orderDetails = new OrderDetails();
        List<OrderDetails> orderDetailsList;

        ProductDetails productDetails = productDetailsDao.findProductDetailsByProductId(orderDetailsDTO.getProductId());
        CustomerDetails customerDetails = customerDetailsDao.findCustomerDetailsByCustomerId(orderDetailsDTO.getCustomerId());

//        orderDetails.setDateOfOrder(new SimpleDateFormat("dd/MM/yyyy").parse(orderDetailsDTO.getOrderedDate()));
        orderDetails.setDateOfOrder(new Date());

        orderDetails.setCustomerId(customerDetails);
        orderDetails.setProductId(productDetails);

        orderDetails.setProductOriginalPrice(productDetails.getPrice());

        orderDetailsList = orderDetailsDao.findOrderDetailsByCustomerId(customerDetails);

        int count = orderDetailsList.size();
        if((count >= 10) && (count < 20)) {
            customerDetails.setCategory("Gold");
            BigDecimal disPrice = productDetails.getPrice().divide(BigDecimal.valueOf(10));
            orderDetails.setProductDiscountedPrice(productDetails.getPrice().subtract(disPrice));
        }
        else if(count >= 20) {
            customerDetails.setCategory("Platinum");
            BigDecimal disPrice = productDetails.getPrice().divide(BigDecimal.valueOf(20));
            orderDetails.setProductDiscountedPrice(productDetails.getPrice().subtract(disPrice));
        }
         else
             orderDetails.setProductDiscountedPrice(productDetails.getPrice());


        orderDetailsDao.save(orderDetails);
        return orderDetails;

    }

    public List<DiscountPercenatgeDTO> getDiscountPercenatge(OrderDetailsDTO orderDetailsDTO){
    
        List<DiscountPercenatgeDTO> discountPercenatgeDTOList = new ArrayList<>();
        CustomerDetails customerDetails;
        ProductDetails productDetails;
        Integer productId = orderDetailsDTO.getProductId();
        productDetails = productDetailsDao.findProductDetailsByProductId(productId);
        Integer customerId = orderDetailsDTO.getCustomerId();
        customerDetails = customerDetailsDao.findCustomerDetailsByCustomerId(customerId);

        List<OrderDetails> orderDetailsList = orderDetailsDao.findOrderDetailsByCustomerIdAndProductId(customerDetails,productDetails);

        Map<Integer, String> map = new HashMap<>();
        map.put(1, "First");
        map.put(2, "Second");
        map.put(3, "Third");
        map.put(4, "Fourth");
        map.put(5, "Fifth");

        int i = 1;

        for(OrderDetails orderDetails : orderDetailsList) {
            BigDecimal orginalPrice = orderDetails.getProductOriginalPrice();
            BigDecimal discountPrice = orderDetails.getProductDiscountedPrice();
            BigDecimal discountPercentage = ((orginalPrice.subtract(discountPrice)).multiply(BigDecimal.valueOf(100))).divide(orginalPrice);
            DiscountPercenatgeDTO discountPercenatgeDTO = new DiscountPercenatgeDTO();
            discountPercenatgeDTO.setDiscountPercentage(discountPercentage);
            discountPercenatgeDTO.setOrderId("Your " + map.get(i++)+ " order");
            discountPercenatgeDTO.setCustomerId(orderDetailsDTO.getCustomerId());
            discountPercenatgeDTO.setProductId(orderDetailsDTO.getProductId());
            discountPercenatgeDTOList.add(discountPercenatgeDTO);
        }

        return discountPercenatgeDTOList;
    }
}
