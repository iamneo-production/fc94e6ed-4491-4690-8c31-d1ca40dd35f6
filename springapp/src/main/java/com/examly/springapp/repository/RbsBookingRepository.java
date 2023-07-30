package com.examly.springapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examly.springapp.model.RbsBooking;
import com.examly.springapp.model.RbsCustomer;
import com.examly.springapp.model.RbsRoom;

public interface RbsBookingRepository extends JpaRepository<RbsBooking, Integer> {

    List<RbsBooking> findByCustomer(RbsCustomer customer);
	List<RbsBooking> findByRoom(RbsRoom room);
	List<RbsBooking> findByCustomerCustomerIdAndRoomRoomId(Integer customerId, Integer roomId);
    
	/*Optional<Booking> findByIdAndCustomerCustomerIdAndRoomRoomId(Integer bookingId, Integer customerId,
			Integer roomId); */
	//List<Payment> findByBookingId(Integer id);
    
}
