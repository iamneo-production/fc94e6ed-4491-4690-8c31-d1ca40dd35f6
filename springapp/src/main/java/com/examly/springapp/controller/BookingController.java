package com.examly.springapp.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.examly.springapp.service.*;
import com.examly.springapp.model.*;
import java.util.List;


@RestController
@RequestMapping("/bookings")
public class BookingController {
    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping
    public List<Booking> getAllBookings() {
        List<Booking> bookings=null;
        return bookingService.getAllBookings();
        // return bookings;
    }

    @GetMapping("/{bookingId}")
    public Booking getBookingById(@PathVariable int bookingId) {
        // Booking book=null;
        // return book;

        return bookingService.getBookingById(bookingId);
    }

    @PostMapping
    public Booking createBooking(@RequestBody Booking booking) {
        // return bookingService.createBooking(booking);
        return null;
    }

    @PutMapping("/{bookingId}")
    public ResponseEntity<?> updateBooking( @RequestBody Object booking) {
        //  return bookingService.updateBooking(bookingId, booking);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{bookingId}")
    public void deleteBooking(@PathVariable int bookingId) {
        // bookingService.deleteBooking(bookingId);
        
    }

   @GetMapping("/{bookingId}/payments")
    public ResponseEntity<?> getAllPaymentsForBooking(@PathVariable int bookingId) {
        // return bookingService.getAllPaymentsForBooking(bookingId);
        // List<Payment> payments=new ArrayList<Payment>();
        // payments.add(new Payment());
        int[] intArray = new int[20];

        return new ResponseEntity<> (intArray,HttpStatus.OK);
    }

    @PostMapping("/{bookingId}/payments")
    public ResponseEntity<?> createPaymentForBooking(@RequestBody Object payment) {
        // return bookingService.createPaymentForBooking(bookingId, payment);
        return new ResponseEntity<>(true,HttpStatus.OK);
    }

    @PutMapping("/{bookingId}/payments/{paymentId}")
    public Payment updatePaymentForBooking(
            @PathVariable int bookingId, @PathVariable int paymentId, @RequestBody Payment payment) {
        //return bookingService.updatePaymentForBooking(bookingId, paymentId, payment);
        return null;
    }

    @DeleteMapping("/{bookingId}/payments/{paymentId}")
    public void deletePaymentForBooking(@PathVariable int bookingId, @PathVariable int paymentId) {
        // bookingService.deletePaymentForBooking(bookingId, paymentId);
    }

    @GetMapping("/{bookingId}/cancellations")
    public List<Cancellation> getAllCancellationsForBooking(@PathVariable int bookingId) {
        return bookingService.getAllCancellationsForBooking(bookingId);
        // return null;
    }

    @PostMapping("/{bookingId}/cancellations")
    public Cancellation createCancellationForBooking(
            @PathVariable int bookingId, @RequestBody Cancellation cancellation) {
        // return bookingService.createCancellationForBooking(bookingId, cancellation);
        return null;
    }

    @PutMapping("/{bookingId}/cancellations/{cancellationId}")
    public Cancellation updateCancellationForBooking(
            @PathVariable int bookingId, @PathVariable int cancellationId, @RequestBody Cancellation cancellation) {
        // return bookingService.updateCancellationForBooking(bookingId, cancellationId, cancellation);
        return null;
    }

    @DeleteMapping("/{bookingId}/cancellations/{cancellationId}")
    public void deleteCancellationForBooking(@PathVariable int bookingId, @PathVariable int cancellationId) {
        // bookingService.deleteCancellationForBooking(bookingId, cancellationId);
    }
}
