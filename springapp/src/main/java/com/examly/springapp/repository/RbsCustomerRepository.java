package com.examly.springapp.repository;


import org.springframework.data.jpa.repository.JpaRepository;


import com.examly.springapp.model.RbsCustomer;


public interface RbsCustomerRepository extends JpaRepository<RbsCustomer, Integer> {
    
}
