package com.orders.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "order_details", schema = "orders")
public class OrderDetails implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private int orderId;

    @Column(name = "date_of_order")
    private Date dateOfOrder;

    @Column(name = "product_original_price")
    private BigDecimal productOriginalPrice;

    @Column(name = "product_discounted_price")
    private BigDecimal productDiscountedPrice;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private CustomerDetails customerId;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductDetails productId;


    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Date getDateOfOrder() {
        return dateOfOrder;
    }

    public void setDateOfOrder(Date dateOfOrder) {
        this.dateOfOrder = dateOfOrder;
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

    public CustomerDetails getCustomerId() {
        return customerId;
    }

    public void setCustomerId(CustomerDetails customerId) {
        this.customerId = customerId;
    }

    public ProductDetails getProductId() {
        return productId;
    }

    public void setProductId(ProductDetails productId) {
        this.productId = productId;
    }
}
