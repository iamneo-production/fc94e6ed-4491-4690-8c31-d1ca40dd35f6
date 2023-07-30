package com.examly.springapp.repository;


import com.examly.springapp.model.RbsCancellation;


import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import com.examly.springapp.model.RbsBooking;


public interface RbsCancellationRepository extends JpaRepository<RbsCancellation, Integer>{


    List<RbsCancellation> findByBooking(RbsBooking booking);
    
}



