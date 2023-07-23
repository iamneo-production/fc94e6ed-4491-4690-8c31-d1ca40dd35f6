package com.examly.springapp.service;

import com.examly.springapp.model.*;


import java.util.List;


public interface PaymentService {
    List<Payment> getAllPaymentsForBooking(int bookingId);

    Payment createPaymentForBooking(int bookingId, Payment payment);

    Payment updatePaymentForBooking(int bookingId, int paymentId, Payment payment);

    void deletePaymentForBooking(int bookingId, int paymentId);
}




