package com.examly.springapp.model;


import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table
public class RbsCustomer {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerId;
    
    @Column(length = 255)
    private String name;
    
    @Column(length = 255)
    private String email;
    
    @Column(length = 10)
    private String phone;
    
    @OneToMany(mappedBy="customer")
    private List<RbsBooking> bookings;
    
    public RbsCustomer() {
        super();
        
    }
    
    public RbsCustomer(int customerId, String name, String email, String phone) {
        super();
        this.customerId = customerId;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }


    public int getCustomerId() {
        return customerId;
    }


    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public String getPhone() {
        return phone;
    }


    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    
}