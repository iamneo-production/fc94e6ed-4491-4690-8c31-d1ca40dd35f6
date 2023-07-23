package com.examly.springapp.controller;

import com.examly.springapp.payload.PaymentDto;
import com.examly.springapp.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.examly.springapp.payload.ApiResponse;
import com.examly.springapp.payload.PaymentDto;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/bookings")
public class PaymentController {

   /*private final PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

   @GetMapping
    public List<Payment> getAllPaymentsForBooking(@PathVariable int bookingId) {
        return paymentService.getAllPaymentsForBooking(bookingId);
    }

    @PostMapping
    public Payment createPaymentForBooking(@PathVariable int bookingId, @RequestBody Payment payment) {
        return paymentService.createPaymentForBooking(bookingId, payment);
    }

    @PutMapping("/{paymentId}")
    public Payment updatePaymentForBooking(
            @PathVariable int bookingId, @PathVariable int paymentId, @RequestBody Payment payment) {
        return paymentService.updatePaymentForBooking(bookingId, paymentId, payment);
    }

    @DeleteMapping("/{paymentId}")
    public void deletePaymentForBooking(@PathVariable int bookingId, @PathVariable int paymentId) {
        paymentService.deletePaymentForBooking(bookingId, paymentId);
    }*/

    @Autowired
	private PaymentService paymentService;
	
	@PostMapping("/{id}/payments")
	public ResponseEntity<PaymentDto> createPayment(@RequestBody PaymentDto paymentDto, @PathVariable Integer id){
		PaymentDto createPaymentDto = this.paymentService.createPayment(paymentDto, id);
		return new ResponseEntity<PaymentDto>(createPaymentDto, HttpStatus.CREATED);
	}
	
	//get payments for specific booking
	
	@GetMapping("/{id}/payments")
	public ResponseEntity<List<PaymentDto>>getAllPaymentsforSpecificBooking(@PathVariable Integer id){
		List<PaymentDto> payments = this.paymentService.getAllPaymentsforSpecificBooking(id);
		return new ResponseEntity<List<PaymentDto>>(payments, HttpStatus.OK);
		
	}
	
	/*//get payments by id
	@GetMapping("/{paymentId}")
	public ResponseEntity<PaymentDto>getPaymentById(@PathVariable Integer paymentId){
		PaymentDto paymentDto = this.paymentService.getPaymentById(paymentId);
		return new ResponseEntity<PaymentDto>(paymentDto, HttpStatus.OK);
		
	}*/
	
	@PutMapping("{id}/payments/{paymentId}")
    public ResponseEntity<PaymentDto> updatePaymentForSpecificBooking(@RequestBody PaymentDto paymentDto,
                                                                      @PathVariable Integer id,
                                                                      @PathVariable Integer paymentId) {
        PaymentDto updatedPaymentDto = paymentService.updatePaymentForSpecificBooking(paymentDto, id);
        return new ResponseEntity<>(updatedPaymentDto, HttpStatus.OK);
    }
	
	
	@DeleteMapping("{id}/payments/{paymentId}")
    public ResponseEntity<Void> deletePaymentForSpecificBooking(@PathVariable Integer id,
                                                                @PathVariable Integer paymentId) {
        paymentService.deletePaymentForSpecificBooking(id, paymentId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
	
	 
	// get all payments
	/*@GetMapping("/payments")
	public ResponseEntity<List<PaymentDto>>getAllPayments(){
		List<PaymentDto> allPayments = this.paymentService.getAllPayments();
		return new ResponseEntity<List<PaymentDto>>(allPayments, HttpStatus.OK);
		
	}
	
	@DeleteMapping("/{paymentId}")
	public ResponseEntity<ApiResponse> deletePayment(@PathVariable ("paymentId") Integer pid){
			this.paymentService.deletePayment(pid);
			return new ResponseEntity<ApiResponse>(new ApiResponse(), HttpStatus.OK);
	}*/
}
