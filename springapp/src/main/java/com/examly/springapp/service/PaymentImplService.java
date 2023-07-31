package com.examly.springapp.service;

import com.examly.springapp.model.*;
import org.springframework.stereotype.Service;
import java.util.List;
import com.examly.springapp.repository.*;

@Service
public class PaymentImplService implements PaymentService {
    private PaymentRepository paymentRepository;

    public PaymentImplService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public List<Payment> getAllPaymentsForBooking(int bookingId) {
        return paymentRepository.findByBookingId(bookingId);
    }

    public Payment createPaymentForBooking(int bookingId, Payment payment) {
        // Set the booking for the payment
        Booking booking = new Booking();
        booking.setId(bookingId);
        payment.setBooking(booking);
        return paymentRepository.save(payment);
    }

    public Payment updatePaymentForBooking(int bookingId, int paymentId, Payment payment) {
        // Check if the payment exists
        Payment existingPayment = paymentRepository.findById(paymentId).orElse(null);
        if (existingPayment != null) {
            // Update the payment details
            existingPayment.setAmount(payment.getAmount());
            existingPayment.setPaymentDateTime(payment.getPaymentDateTime());
            existingPayment.setPaymentStatus(payment.getPaymentStatus());
            return paymentRepository.save(existingPayment);
        }
        return null;
    }

    public void deletePaymentForBooking(int bookingId, int paymentId) {
        // Check if the payment exists
        Payment existingPayment = paymentRepository.findById(paymentId).orElse(null);
        if (existingPayment != null) {
            paymentRepository.delete(existingPayment);
        }
    }
}

