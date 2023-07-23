package com.examly.springapp.service;


import com.examly.springapp.repository.*;
import java.util.List;
import org.springframework.stereotype.Service;

import com.examly.springapp.model.*;
@Service
public class PaymentImplService implements PaymentService{

    private final PaymentRepository paymentRepository;


    public PaymentImplService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public List<Payment> getAllPaymentsForBooking(int bookingId) {
        return paymentRepository.findByBookingId(bookingId);
    }

    public Payment createPaymentForBooking(int bookingId, Payment payment) {
        payment.setBooking(new Booking(bookingId, null, null, null, null, null, null));
        return paymentRepository.save(payment);
    }

    public Payment updatePaymentForBooking(int bookingId, int paymentId, Payment payment) {
        Payment existingPayment = paymentRepository.findById(paymentId).orElse(null);
        if (existingPayment != null) {
            existingPayment.setAmount(payment.getAmount());
            existingPayment.setPaymentDateTime(payment.getPaymentDateTime());
            existingPayment.setPaymentStatus(payment.getPaymentStatus());
            return paymentRepository.save(existingPayment);
        }
        return null;
    }

    public void deletePaymentForBooking(int bookingId, int paymentId) {
        Payment existingPayment = paymentRepository.findById(paymentId).orElse(null);
        if (existingPayment != null) {
            paymentRepository.delete(existingPayment);
        }
    }
}

