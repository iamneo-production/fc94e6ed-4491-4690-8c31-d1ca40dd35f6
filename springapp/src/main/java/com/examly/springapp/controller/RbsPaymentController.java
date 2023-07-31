package com.examly.springapp.controller;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


import com.examly.springapp.payload.RbsPaymentDto;
import com.examly.springapp.service.RbsPaymentService;
import com.examly.springapp.payload.ApiResponse;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("api/v1/bookings")
public class RbsPaymentController{


    @Autowired
    private RbsPaymentService paymentService;
    
    @PostMapping("/{id}/payments")
    public ResponseEntity<RbsPaymentDto> createPayment(@RequestBody RbsPaymentDto paymentDto, @PathVariable Integer id){
        RbsPaymentDto createPaymentDto = this.paymentService.createPayment(paymentDto, id);
        return new ResponseEntity<RbsPaymentDto>(createPaymentDto, HttpStatus.CREATED);
    }
    
    //get payments for specific booking
    
    @GetMapping("/{id}/payments")
    public ResponseEntity<List<RbsPaymentDto>>getAllPaymentsforSpecificBooking(@PathVariable Integer id){
        List<RbsPaymentDto> payments = this.paymentService.getAllPaymentsforSpecificBooking(id);
        return new ResponseEntity<List<RbsPaymentDto>>(payments, HttpStatus.OK);
        
    }
    
    //get payments by id
    @GetMapping("/payments/{paymentId}")
    public ResponseEntity<RbsPaymentDto>getPaymentById(@PathVariable Integer paymentId){
        RbsPaymentDto paymentDto = this.paymentService.getPaymentById(paymentId);
        return new ResponseEntity<RbsPaymentDto>(paymentDto, HttpStatus.OK);
        
    }
    
    @PutMapping("/{id}/payments/{paymentId}")
    public ResponseEntity<RbsPaymentDto> updatePaymentForSpecificBooking(@RequestBody RbsPaymentDto paymentDto,
                                                                      @PathVariable Integer id,
                                                                      @PathVariable Integer paymentId) {
        RbsPaymentDto updatedPaymentDto = paymentService.updatePaymentForSpecificBooking(paymentDto, id);
        return new ResponseEntity<>(updatedPaymentDto, HttpStatus.OK);
    }
    
    
    @DeleteMapping("/{id}/payments/{paymentId}")
    public ResponseEntity<Void> deletePaymentForSpecificBooking(@PathVariable Integer id,
                                                                @PathVariable Integer paymentId) {
        paymentService.deletePaymentForSpecificBooking(id, paymentId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
     
    // get all payments
    @GetMapping("/payments")
    public ResponseEntity<List<RbsPaymentDto>>getAllPayments(){
        List<RbsPaymentDto> allPayments = this.paymentService.getAllPayments();
        return new ResponseEntity<List<RbsPaymentDto>>(allPayments, HttpStatus.OK);
        
    }
    
    @DeleteMapping("/{paymentId}")
    public ResponseEntity<ApiResponse> deletePayment(@PathVariable ("paymentId") Integer pid){
            this.paymentService.deletePayment(pid);
            return new ResponseEntity<ApiResponse>(new ApiResponse(), HttpStatus.OK);
    }
    
    
    
}



