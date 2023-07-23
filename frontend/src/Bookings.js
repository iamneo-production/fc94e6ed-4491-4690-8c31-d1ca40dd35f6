import axios from 'axios';
import React, { useEffect, useState } from 'react';
import Navbar from './Navbar';
import { toast } from 'react-toastify';
import { useNavigate } from "react-router-dom";

function Bookings() {
  const [bookings, setBookings] = useState([]);
  const id = localStorage.getItem("customerId");
 
  const navigate = useNavigate();
 
  useEffect(() => {
    getData();
  }, []);

  function getData() {
    
    axios.get(`http://localhost:8080/api/v1/customers/${id}/bookings`)
  
      .then(response => {
        setBookings(response.data);
      })
      .catch(error => {
        console.error("Error retrieving bookings:", error);
      });
  };

  const handleCancelBooking = async (bookingId) => {
    const reason = prompt("Enter cancellation reason:");
    if (reason) {
      try {
        const apiUrl = `http://localhost:8080/api/v1/bookings/${bookingId}/cancellations`;
        const data = {
          reason,
          dateCancelled: new Date().toISOString()
        };

        const response = await axios.post(apiUrl, data);
        console.log("Cancellation request sent successfully:", response.data);

        setBookings(prevBookings => prevBookings.filter(booking => booking.id !== bookingId));
        toast.success('You have cancelled your booking.');

        // Navigate to home page after a delay
        setTimeout(() => {
          navigate('/home');
        }, 2000); // Delay in milliseconds (e.g., 2000 for 2 seconds)
      

      } catch (error) {
        console.error("Error sending cancellation request:", error);
      }
    }
  };


  return (
    <>
      <Navbar/>
    <div>
      <h1>My Bookings</h1>
      <p>{id}</p>

      <div>
        <div className='col-md-4 offset-md-1'>
          
          {bookings && bookings.map(booking => (
            <div key={booking.id} className='shadow p-3 mb-5 bg-white rounded'>
              
              <p>Check-in Date: {new Date(booking.checkInDate).toLocaleDateString()}</p>
              <p>Check-out Date: {new Date(booking.checkOutDate).toLocaleDateString()}</p>
              <p>Room Type: {booking.room.roomType}</p>
              <p>Room Price: {booking.room.pricePerNight}</p>
              <p>Boking Status : Booked</p>
              

              <div className='text-right'>
                <button className='btn btn-secondary' style={{ border: ' none' }} onClick={() => handleCancelBooking(booking.id)}>CANCEL BOOKING</button>
              </div>
            </div>
          ))}

        </div>
      </div>
      </div>
    </>
  )
}

export default Bookings;