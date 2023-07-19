package com.examly.springapp.service;


import com.examly.springapp.payload.RbsCustomerDto;
import java.util.List;


public interface RbsCustomerService {


    RbsCustomerDto createCustomer(RbsCustomerDto customer);
    
    RbsCustomerDto updateCustomer(RbsCustomerDto customer, Integer customerId);
    
    RbsCustomerDto getCustomerById(Integer customerId);
    
    List<RbsCustomerDto> getAllCustomers();
    
    void deleteCustomer(Integer customerId);
    
}
