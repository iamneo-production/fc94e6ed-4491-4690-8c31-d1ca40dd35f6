package com.examly.springapp.service;

import com.examly.springapp.model.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.examly.springapp.repository.PaymentRepository;
import com.examly.springapp.model.Booking;




/*private final PaymentRepository paymentRepository;

    @Autowired
    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public List<Payment> getAllPaymentsForBooking(int bookingId) {
        return paymentRepository.findByBookingId(bookingId);
    }

    public Payment createPaymentForBooking(int bookingId, Payment payment) {
        //payment.setBooking(new Booking(bookingId));
        Booking booking = new Booking();
        booking.setId(bookingId);
        payment.setBooking(booking);
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
    }*/

    

@Service
public class PaymentService {
    private final PaymentRepository paymentRepository;

    @Autowired
    public PaymentService(PaymentRepository paymentRepository) {
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
