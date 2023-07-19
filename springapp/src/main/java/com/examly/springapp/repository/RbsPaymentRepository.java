package com.examly.springapp.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.examly.springapp.model.RbsPayment;
import java.util.List;
import com.examly.springapp.model.RbsBooking;


public interface RbsPaymentRepository extends JpaRepository<RbsPayment, Integer>{


    List<RbsPayment> findByBooking(RbsBooking booking);
    
}


