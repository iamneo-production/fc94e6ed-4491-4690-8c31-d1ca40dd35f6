package com.examly.springapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.examly.springapp.model.*;
public interface BookingRepository extends JpaRepository<Booking, Integer> {

}