package com.examly.springapp.repository;

import com.examly.springapp.model.RbsCancellation;

import org.springframework.data.jpa.repository.JpaRepository;


public interface RbsCancellationRepository extends JpaRepository<RbsCancellation, Integer>{

    //List<RbsCancellation> findByBooking(RbsBooking booking);
    
}
