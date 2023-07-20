package com.examly.springapp.service.serviceImpl;


import com.examly.springapp.service.RbsBookingService;
import com.examly.springapp.repository.RbsBookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.examly.springapp.repository.RbsRoomRepository;
import com.examly.springapp.repository.RbsCustomerRepository;
import com.examly.springapp.repository.RbsPaymentRepository;
import com.examly.springapp.exception.ResourceNotFoundException;
import com.examly.springapp.model.RbsBooking;
import com.examly.springapp.model.RbsPayment;
import com.examly.springapp.model.RbsCustomer;
import com.examly.springapp.model.RbsRoom;
import com.examly.springapp.payload.RbsBookingDto;
import com.examly.springapp.payload.RbsPaymentDto;
import com.examly.springapp.payload.RbsRoomDto;
import com.examly.springapp.payload.RbsCustomerDto;


import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Date;
import org.springframework.stereotype.Service;


public class RbsBookingServiceImpl implements RbsBookingService{

    @Autowired
    private RbsBookingRepository bookingRepo;
    
    @Autowired
    private RbsCustomerRepository customerRepo;
    
    @Autowired
    private RbsRoomRepository roomRepo;
    
    @Autowired
    private RbsPaymentRepository paymentRepo;


    @Override
    public RbsBookingDto createBooking(RbsBookingDto bookingDto, Integer customerId) {
        
        RbsCustomer customer = this.customerRepo.findById(customerId).orElseThrow();
        RbsBooking booking = this.dtoToBooking(bookingDto);
        booking.setCheckInDate(new Date());
        booking.setCheckOutDate(new Date());
        booking.setCustomer(customer);
        RbsBooking savedBooking = this.bookingRepo.save(booking);
        return this.bookingToDto(savedBooking);
    }
    
    @Override
    public RbsBookingDto createBookingForRoom(RbsBookingDto bookingDto, Integer roomId, Integer customerId) {
        
        RbsRoom room = this.roomRepo.findById(roomId).orElseThrow();
        RbsCustomer customer = this.customerRepo.findById(customerId).orElseThrow();
        RbsBooking booking = this.dtoToBooking(bookingDto);
        booking.setCheckInDate(bookingDto.getCheckInDate());
        booking.setCheckOutDate(bookingDto.getCheckOutDate());
        booking.setCustomer(customer);
        booking.setRoom(room);
        RbsBooking savedBooking = this.bookingRepo.save(booking);
        return this.bookingToDto(savedBooking);
        
    }


    @Override
    public RbsBookingDto updateBooking(RbsBookingDto bookingDto, Integer id) {
        RbsBooking booking = this.bookingRepo.findById(id)
                .orElseThrow();
        booking.setCheckInDate(bookingDto.getCheckInDate());
        booking.setCheckOutDate(bookingDto.getCheckOutDate());
        
        RbsBooking updatedBooking = this.bookingRepo.save(booking);
        return this.bookingToDto(updatedBooking);


    }


    @Override
    public RbsBookingDto getBookingById(Integer id) {
        RbsBooking booking = this.bookingRepo.findById(id).orElseThrow();
        return this.bookingToDto(booking);
    }


    
    @Override
    public List<RbsBookingDto> getAllBookings() {
        List<RbsBooking> bookings = this.bookingRepo.findAll();
        return bookings.stream().map(this::bookingToDto).collect(Collectors.toList());
    }


    @Override
    public void deleteBooking(Integer id) {
        RbsBooking booking = this.bookingRepo.findById(id).orElseThrow();
        this.bookingRepo.delete(booking);
    
    }

    @Override
    public List<RbsBookingDto> findByCustomerCustomerIdAndRoomRoomId(Integer roomId, Integer customerId) {
        List<RbsBooking> bookings = bookingRepo.findByCustomerCustomerIdAndRoomRoomId(customerId, roomId);
        return bookings.stream().map(this::bookingToDto).collect(Collectors.toList());
    }



    @Override
    public List<RbsBooking> searchBookings(String keyword) {
        // TODO Auto-generated method stub
        return null;
    }


    @Override
    public RbsBookingDto updateBookingForCustomerAndRoom(RbsBookingDto bookingDto, Integer customerId, Integer roomId, Integer id) {
        RbsCustomer customer = customerRepo.findById(customerId)
                .orElseThrow();
        RbsRoom room = roomRepo.findById(roomId)
                .orElseThrow();
        RbsBooking booking = bookingRepo.findById(id)
                .orElseThrow();


        // Check if the booking belongs to the specified customer and room
        if (!booking.getCustomer().equals(customer) || !booking.getRoom().equals(room)) {
            throw new ResourceNotFoundException("Booking", "bookingId", id);
        }


        // Update the booking details
        booking.setCheckInDate(bookingDto.getCheckInDate());
        booking.setCheckOutDate(bookingDto.getCheckOutDate());


        // Save the updated booking
        RbsBooking updatedBooking = bookingRepo.save(booking);


        return bookingToDto(updatedBooking);
    }



    @Override
    public RbsBookingDto createSingleBooking(RbsBookingDto bookingDto) {
        RbsBooking booking = this.dtoToBooking(bookingDto);
        RbsBooking savedBooking = this.bookingRepo.save(booking);
        return this.bookingToDto(savedBooking);
    }

    @Override
    public List<RbsBookingDto> getBookingsByCustomer(Integer customerId) {
        RbsCustomer cust = this.customerRepo.findById(customerId).orElseThrow();
        List<RbsBooking> bookings = this.bookingRepo.findByCustomer(cust);
        return bookings.stream().map(this::bookingToDto).collect(Collectors.toList());
        
    }


    @Override
    public RbsPaymentDto createPayment(RbsPaymentDto paymentDto, Integer bookingId) {
        RbsBooking booking = this.bookingRepo.findById(bookingId).orElseThrow();
        RbsPayment payment = this.dtoToPayment(paymentDto);
        payment.setAmount(4000.0);
        payment.setPaymentStatus("success");
        payment.setPaymentDateTime(LocalDateTime.now());
        payment.setBooking(booking);
        RbsPayment savedPayment = this.paymentRepo.save(payment);
        return this.paymentToDto(savedPayment);
        
    }
    
    @Override
    public List<RbsPaymentDto> getAllPaymentsforSpecificBooking(Integer bookingId) {
        RbsBooking booking = this.bookingRepo.findById(bookingId).orElseThrow();
        List<RbsPayment> payments = this.paymentRepo.findByBooking(booking);
        return payments.stream().map(this::paymentToDto).collect(Collectors.toList());
        
    }

    private RbsPaymentDto paymentToDto(RbsPayment payment) {
        RbsPaymentDto paymentDto = new RbsPaymentDto();
        paymentDto.setPaymentId(payment.getPaymentId());
        paymentDto.setAmount(payment.getAmount());
        paymentDto.setPaymentDateTime(payment.getPaymentDateTime());
        paymentDto.setPaymentStatus(payment.getPaymentStatus());


        // Set the booking
        RbsBooking booking = payment.getBooking();
        if (booking != null) {
            RbsBookingDto bookingDto = new RbsBookingDto();
            bookingDto.setId(booking.getId());
            bookingDto.setCheckInDate(booking.getCheckInDate());
            bookingDto.setCheckOutDate(booking.getCheckOutDate());
       
            RbsCustomer customer = booking.getCustomer();
            if (customer != null) {
                RbsCustomerDto customerDto = new RbsCustomerDto();
                customerDto.setCustomerId(customer.getCustomerId());
                customerDto.setName(customer.getName());
                customerDto.setEmail(customer.getEmail());
                customerDto.setPhone(customer.getPhone());
                
                 bookingDto.setCustomer(customerDto);       
            }
            
            RbsRoom room = booking.getRoom();
            if(room != null) {
                RbsRoomDto roomDto = new RbsRoomDto();
                roomDto.setRoomId(room.getRoomId());
                roomDto.setRoomType(room.getRoomType());
                roomDto.setAvailable(room.isAvailable());
                roomDto.setCapacity(room.getCapacity());
                roomDto.setPricePerNight(room.getPricePerNight());
                
                bookingDto.setRoom(roomDto);
            }
            
            paymentDto.setBooking(bookingDto);
        }


        return paymentDto;
    }

    private RbsPayment dtoToPayment(RbsPaymentDto paymentDto) {
        RbsPayment payment = new RbsPayment();
        payment.setPaymentId(paymentDto.getPaymentId());
        payment.setAmount(paymentDto.getAmount());
        payment.setPaymentDateTime(paymentDto.getPaymentDateTime());
        payment.setPaymentStatus(paymentDto.getPaymentStatus());


        // Set the booking
        RbsBookingDto bookingDto = paymentDto.getBooking();
        if (bookingDto != null) {
            RbsBooking booking = new RbsBooking();
            booking.setId(bookingDto.getId());
            
            RbsCustomerDto customerDto = bookingDto.getCustomer();
            if (customerDto != null) {
                RbsCustomer customer = new RbsCustomer();
                customer.setCustomerId(customerDto.getCustomerId());
                customer.setName(customerDto.getName());
                customer.setEmail(customerDto.getEmail());
                customer.setPhone(customerDto.getPhone());
                // Set other customer properties as needed
                booking.setCustomer(customer);
            }
            
            RbsRoomDto roomDto = bookingDto.getRoom();
            if(roomDto != null) {
                RbsRoom room = new RbsRoom();
                room.setRoomId(roomDto.getRoomId());
                room.setRoomType(roomDto.getRoomType());
                room.setAvailable(room.isAvailable());
                room.setCapacity(roomDto.getCapacity());
                room.setPricePerNight(roomDto.getPricePerNight());
                
                booking.setRoom(room);
            }
            
            payment.setBooking(booking);
        }


        return payment;
    }
    
    private RbsBookingDto bookingToDto(RbsBooking booking) {
        RbsBookingDto bookingDto = new RbsBookingDto();
        bookingDto.setId(booking.getId());
        bookingDto.setCheckInDate(booking.getCheckInDate());
        bookingDto.setCheckOutDate(booking.getCheckOutDate());


        // Set the customer
        RbsCustomer customer = booking.getCustomer();
        if (customer != null) {
            RbsCustomerDto customerDto = new RbsCustomerDto();
            customerDto.setCustomerId(customer.getCustomerId());
            customerDto.setName(customer.getName());
            customerDto.setEmail(customer.getEmail());
            customerDto.setPhone(customer.getPhone());
            
            bookingDto.setCustomer(customerDto);
        }
        
        RbsRoom room = booking.getRoom();
        if(room != null) {
            RbsRoomDto roomDto = new RbsRoomDto();
            roomDto.setRoomId(room.getRoomId());
            roomDto.setRoomType(room.getRoomType());
            roomDto.setAvailable(room.isAvailable());
            roomDto.setCapacity(room.getCapacity());
            roomDto.setPricePerNight(room.getPricePerNight());
            
            bookingDto.setRoom(roomDto);
        }
        
        RbsPayment payment = booking.getPayment();
        if(payment != null) {
            RbsPaymentDto paymentDto = new RbsPaymentDto();
            paymentDto.setPaymentId(payment.getPaymentId());
            paymentDto.setAmount(payment.getAmount());
            paymentDto.setPaymentDateTime(payment.getPaymentDateTime());
            paymentDto.setPaymentStatus(payment.getPaymentStatus());
            
            bookingDto.setPayment(paymentDto);
            
        }


        return bookingDto;
    }
    


    private RbsBooking dtoToBooking(RbsBookingDto bookingDto) {
        RbsBooking booking = new RbsBooking();
        booking.setId(bookingDto.getId());
        booking.setCheckInDate(bookingDto.getCheckInDate());
        booking.setCheckOutDate(bookingDto.getCheckOutDate());


        // Set the customer
        RbsCustomerDto customerDto = bookingDto.getCustomer();
        if (customerDto != null) {
            RbsCustomer customer = new RbsCustomer();
            customer.setCustomerId(customerDto.getCustomerId());
            customer.setName(customerDto.getName());
            customer.setEmail(customerDto.getEmail());
            customer.setPhone(customerDto.getPhone());
            // Set other customer properties as needed
            booking.setCustomer(customer);
        }
        
        RbsRoomDto roomDto = bookingDto.getRoom();
        if(roomDto != null) {
            RbsRoom room = new RbsRoom();
            room.setRoomId(roomDto.getRoomId());
            room.setRoomType(roomDto.getRoomType());
            room.setAvailable(room.isAvailable());
            room.setCapacity(roomDto.getCapacity());
            room.setPricePerNight(roomDto.getPricePerNight());
            
            booking.setRoom(room);
        }
        
        RbsPaymentDto paymentDto = bookingDto.getPayment();
        if(paymentDto != null) {
            RbsPayment payment = new RbsPayment();
            payment.setPaymentId(paymentDto.getPaymentId());
            payment.setAmount(paymentDto.getAmount());
            payment.setPaymentDateTime(paymentDto.getPaymentDateTime());
            payment.setPaymentStatus(paymentDto.getPaymentStatus());
            
            booking.setPayment(payment);
            
        }


        return booking;
    }
    
}







