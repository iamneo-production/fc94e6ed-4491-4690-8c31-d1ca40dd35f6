package com.examly.springapp.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.examly.springapp.model.RbsRoom;


public interface RbsRoomRepository extends JpaRepository<RbsRoom, Integer> {
    
}

