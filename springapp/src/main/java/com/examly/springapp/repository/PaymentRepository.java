package com.examly.springapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.examly.springapp.model.*;
import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {
    
    List<Payment> findByBookingId(int bookingId);
}
