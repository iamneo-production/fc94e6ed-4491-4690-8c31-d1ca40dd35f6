package com.examly.springapp.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.examly.springapp.payload.RbsRoomDto;
import com.examly.springapp.service.RbsRoomService;
import java.util.List;
import com.examly.springapp.payload.ApiResponse;


@RestController
@RequestMapping("/api/rooms")
public class RbsRoomController {


    @Autowired
    private RbsRoomService roomService;
    
    @PostMapping("/")
    public ResponseEntity<RbsRoomDto> createRoom(@RequestBody RbsRoomDto roomDto){
        RbsRoomDto createRoomDto = this.roomService.createRoom(roomDto);
        return new ResponseEntity<>(createRoomDto, HttpStatus.CREATED);
        
    }
    
    @PutMapping("/{roomId}")
    public ResponseEntity<RbsRoomDto> updateRoom(@RequestBody RbsRoomDto roomDto, @PathVariable Integer roomId){
        
        RbsRoomDto updatedRoom = this.roomService.updateRoom(roomDto, roomId);
        return ResponseEntity.ok(updatedRoom);
        
    }
    
    @DeleteMapping("/{roomId}")
    public ResponseEntity<ApiResponse> deleteRoom(@PathVariable ("roomId") Integer rid){
            this.roomService.deleteRoom(rid);
            return new ResponseEntity<ApiResponse>(new ApiResponse(), HttpStatus.OK);
    }
    
    @GetMapping("/")
    public ResponseEntity<List<RbsRoomDto>> getAllRooms(){
        return ResponseEntity.ok(this.roomService.getAllRooms());
    }
    
    @GetMapping("/{roomId}")
    public ResponseEntity<RbsRoomDto> getSingleRoom(@PathVariable Integer roomId){
        return ResponseEntity.ok(this.roomService.getRoomById(roomId));
    }
    


    
    
}



