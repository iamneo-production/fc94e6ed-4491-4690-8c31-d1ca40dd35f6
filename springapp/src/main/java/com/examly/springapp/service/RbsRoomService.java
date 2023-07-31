package com.examly.springapp.service;


import com.examly.springapp.payload.RbsRoomDto;
import java.util.List;


public interface RbsRoomService {


    RbsRoomDto createRoom(RbsRoomDto room);
    
    RbsRoomDto updateRoom(RbsRoomDto room, Integer roomId);
    
    void deleteRoom(Integer roomId);
    
    RbsRoomDto getRoomById(Integer roomId);
    
    List<RbsRoomDto> getAllRooms();
    
}



