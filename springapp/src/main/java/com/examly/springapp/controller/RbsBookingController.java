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
import org.springframework.web.bind.annotation.CrossOrigin;
import java.util.List;
import java.util.Date;
import com.examly.springapp.payload.ApiResponse;


import com.examly.springapp.service.RbsBookingService;


import com.examly.springapp.service.RbsPaymentService;
import com.examly.springapp.payload.RbsBookingDto;


@CrossOrigin(origins="*")
@RestController
@RequestMapping("api/v1")



public class RbsBookingController {
    @PutMapping("/{id}")
    public ResponseEntity<RbsBookingDto> updateBooking(
            @RequestBody RbsBookingDto bookingDto, 
            @PathVariable Integer id){
        
        RbsBookingDto updatedBooking = this.bookingService.updateBooking(bookingDto, id);
        return ResponseEntity.ok(updatedBooking);
        
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteBooking(@PathVariable ("id") Integer bid){
            this.bookingService.deleteBooking(bid);
            return new ResponseEntity<>(new ApiResponse(), HttpStatus.OK);
    }
    
    @GetMapping
    public ResponseEntity<List<RbsBookingDto>> getAllBookings(){
        return ResponseEntity.ok(this.bookingService.getAllBookings());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<RbsBookingDto> getSingleBooking(@PathVariable Integer id){
        return ResponseEntity.ok(this.bookingService.getBookingById(id));
    }
    
    
    
    
    
    
}




    
}
