package com.orders.dto;

import com.orders.entity.CustomerDetails;
import com.orders.entity.ProductDetails;

import java.math.BigDecimal;
import java.util.Date;

public class OrderDetailsDTO {

    private Integer customerId;
    private Integer productId;
    private String orderedDate;
    private BigDecimal productOriginalPrice;
    private BigDecimal productDiscountedPrice;

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public BigDecimal getProductOriginalPrice() {
        return productOriginalPrice;
    }

    public void setProductOriginalPrice(BigDecimal productOriginalPrice) {
        this.productOriginalPrice = productOriginalPrice;
    }

    public BigDecimal getProductDiscountedPrice() {
        return productDiscountedPrice;
    }

    public void setProductDiscountedPrice(BigDecimal productDiscountedPrice) {
        this.productDiscountedPrice = productDiscountedPrice;
    }


    public String getOrderedDate() {
        return orderedDate;
    }

    public void setOrderedDate(String orderedDate) {
        this.orderedDate = orderedDate;
    }
}
