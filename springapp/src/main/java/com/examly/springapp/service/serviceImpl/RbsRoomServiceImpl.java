package com.examly.springapp.service.serviceImpl;


import com.examly.springapp.service.RbsRoomService;
import com.examly.springapp.repository.RbsRoomRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.examly.springapp.exception.ResourceNotFoundException;


import com.examly.springapp.model.RbsRoom;


import com.examly.springapp.payload.RbsRoomDto;


import java.util.List;
import java.util.stream.Collectors;


@Service
public class RbsRoomServiceImpl implements RbsRoomService{


    
    @Autowired
    private RbsRoomRepository roomRepo;
    
    /*@Autowired
    private ModelMapper modelMapper;*/


    @Override
    public RbsRoomDto createRoom(RbsRoomDto roomDto) {
        RbsRoom room = this.dtoToRoom(roomDto);
        RbsRoom savedRoom = this.roomRepo.save(room);
        return this.roomToDto(savedRoom);
    }


    


    @Override
    public RbsRoomDto updateRoom(RbsRoomDto roomDto, Integer roomId) {
        RbsRoom room = this.roomRepo.findById(roomId).orElseThrow(()-> new ResourceNotFoundException("Room", "Id", roomId));
        room.setRoomType(roomDto.getRoomType());
        room.setPricePerNight(roomDto.getPricePerNight());
        room.setAvailable(roomDto.isAvailable());
        room.setCapacity(roomDto.getCapacity());
        
        RbsRoom updatedRoom = this.roomRepo.save(room);
        RbsRoomDto roomDto1 = this.roomToDto(updatedRoom);
        return roomDto1;
        
        
    }


    @Override
    public void deleteRoom(Integer roomId) {
        RbsRoom room = this.roomRepo.findById(roomId).orElseThrow(()-> new ResourceNotFoundException("Room", "Id", roomId));
        this.roomRepo.delete(room);
        
    }


    @Override
    public RbsRoomDto getRoomById(Integer roomId) {
        RbsRoom room = this.roomRepo.findById(roomId).orElseThrow(()-> new ResourceNotFoundException("Room", "Id", roomId));
        return this.roomToDto(room);
    }


    @Override
    public List<RbsRoomDto> getAllRooms() {
        List<RbsRoom> rooms = this.roomRepo.findAll();
        List<RbsRoomDto> roomDtos = rooms.stream().map(room -> this.roomToDto(room)).collect(Collectors.toList());
        
        return roomDtos;
    }
    
    public RbsRoomDto getBookingsByRoom(Integer roomId) {
        RbsRoom room = this.roomRepo.findById(roomId).orElseThrow(()-> new ResourceNotFoundException("Room", "Id", roomId));
        return this.roomToDto(room);
        
    }
    
    
    
    private RbsRoomDto roomToDto(RbsRoom room) {
        RbsRoomDto roomDto = new RbsRoomDto();
        roomDto.setRoomId(room.getRoomId());
        roomDto.setRoomType(room.getRoomType());
        roomDto.setPricePerNight(room.getPricePerNight());
        roomDto.setAvailable(room.isAvailable());
        roomDto.setCapacity(room.getCapacity());
        return roomDto;
    }


    private RbsRoom dtoToRoom(RbsRoomDto roomDto) {
        RbsRoom room = new RbsRoom();
        room.setRoomId(roomDto.getRoomId());
        room.setRoomType(roomDto.getRoomType());
        room.setPricePerNight(roomDto.getPricePerNight());
        room.setAvailable(roomDto.isAvailable());
        room.setCapacity(roomDto.getCapacity());
        return room;
    }
    
    


}

