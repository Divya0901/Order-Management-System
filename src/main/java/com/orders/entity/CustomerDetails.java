package com.orders.entity;



import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "customer_details", schema = "orders")
public class CustomerDetails implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private int customerId;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column(name = "email_id", unique = true, length = 20, nullable = false)
    private String emailId;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "user_name", nullable = false)
    private String userName;

    @Column(name = "category")
    private String category;

    @Column(name = "phone_number", unique = true, length = 15, nullable = false)
    private String phoneNumber;

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
