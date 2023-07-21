package com.examly.springapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.examly.springapp.model.Booking;
import com.examly.springapp.model.Payment;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {
    
    List<Payment> findByBooking(Booking booking);
}
