import React, { useState, useEffect } from 'react';
import axios from 'axios';
//import { Link } from 'react-router-dom';
import RazorpayButton from './RazorpayButton';
import Navbar from './Navbar';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faTimes } from '@fortawesome/free-solid-svg-icons';
import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import { useNavigate } from 'react-router-dom';
//import "./BookingDetails.css";

const BookingDetails = () => {
    const [bookings, setBookings] = useState([]);
    //const [confirm, setCofirm] = useState(false);
    const [showBookings, setShowBookings] = useState(true);
    const [paymentConfirmed, setPaymentConfirmed] = useState(false);
    const id = localStorage.getItem("customerId");
    //const bookingId = localStorage.getItem("bookingId");
    const navigate = useNavigate();
    
    useEffect(() => {
        getData();
    }, []);

    const getData = () => {
        axios
            .get(`http://localhost:8080/api/v1/customers/${id}/bookings`)
            .then((response) => {
                setBookings(response.data);
                
                
            })
            .catch((error) => {
                console.error('Error retrieving bookings:', error);
            });
    };

    const handlePaymentRequest = async (bookingId) => {

        try {

            const paymentDetails = {
                amount: bookings.find((booking) => booking.id === bookingId).room.pricePerNight,
                status: 'success', // Assuming payment is successful; you can change this as needed
            };

            // Make a POST request to your server with the booking ID for payment processing
            await axios.post(`http://localhost:8080/api/v1/bookings/${bookingId}/payments`, paymentDetails);

            // Display a success message or perform any necessary actions
            toast.success('Payment done successfully', {
                position: toast.POSITION.TOP_RIGHT,
                autoClose: 2000, // Close the toast after 3 seconds
            });
            setPaymentConfirmed(true);
            setTimeout(() => {
                navigate('/home');
            }, 1000 );// Navigate to the home page
            console.log('Payment request sent successfully.');
        } catch (error) {
            console.error('Error sending payment request:', error);
        }
    };


    
    /*const handleCancelBooking = async (bookingId) => {
        try {
            // Display a confirmation message
            const confirmed = window.confirm('Are you sure you want to cancel this booking?');

            if (confirmed) {
                // Delete the booking
                await axios.delete(`http://localhost:8282/api/v1/${bookingId}`);

                // Display a success message
                console.log(`Booking with ID ${bookingId} has been cancelled.`);

                // Refresh the bookings data
                getData();
            }
        } catch (error) {
            console.error('Error cancelling booking:', error);
        }
    };*/

    const handleDeleteBooking = async (bookingId) => {
        try {
            const confirmed = window.confirm('Are you sure you want to cancel this booking?');
            if (confirmed) {
                await axios.delete(`http://localhost:8080/api/v1/${bookingId}`);
                console.log(`Booking with ID ${bookingId} has been deleted.`);
                getData(); // Refresh the bookings data
                toast.success('Booking deleted successfully', {
                    position: toast.POSITION.TOP_RIGHT,
                    autoClose: 2000, // Close the toast after 3 seconds
                });
                setShowBookings(false);
                setTimeout(() => {
                    navigate('/home');
                }, 1000);
            }
        } catch (error) {
            console.error('Error deleting booking:', error);
        }
    };

    
    return (
        <>
            <Navbar />
            <ToastContainer />
        <div>
            <h1 style={{padding:"40px"}}>Booking Conformation</h1>
            <p>{id}</p>

            <div>
                <div className='col-md-4 offset-md-1'>
                    {paymentConfirmed ? (
                        <p></p>
                    ) : (
                    
                    bookings.map((booking) => (
                        <div key={booking.id} className='shadow p-3 mb-5 bg-white rounded'>
                            <div
                                style={{
                                    display: 'flex',
                                    justifyContent: 'flex-end',
                                    marginBottom: '-25px',
                                }}
                            >
                                <FontAwesomeIcon
                                    icon={faTimes}
                                    style={{ cursor: 'pointer' }}
                                    onClick={() => handleDeleteBooking(booking.id)}
                                />
                            </div>

                            <p>Check-in Date: {booking.checkInDate}</p>
                            <p>Check-out Date: {booking.checkOutDate}</p>
                            <p>Room Type: {booking.room.roomType}</p>
                            <p>Room Price: {booking.room.pricePerNight}</p>

                            

                            {/* Add more details as needed */}

                            <div className='d-flex justify-content-between'>
                                
                                <RazorpayButton
                                    amount={booking.room.pricePerNight * 100}
                                    currency="INR"
                                    
                                    
                                />
                                
                                {/*<button
                                    className='btn btn-secondary'
                                    style={{ border: 'none' }}
                                    onClick={() => handlePaymentRequest(booking.bookingId)}
                                >
                                    Pay Now
                    </button>*/}
                                {/*<button
                                    className='btn btn-danger'
                                    style={{ border: 'none' }}
                                    onClick={()=> handleCancelBooking(booking.id)}
                                >
                                    Cancel
                                </button>*/}
                                
                            </div>
                            <div style={{ marginTop: '20px' }}>
                                <p>After doing the payment, please click the button below to confirm your payment:</p>
                                <button
                                    className='btn btn-secondary'
                                    style={{ border: 'none' }}
                                    onClick={() => handlePaymentRequest(booking.id)}
                                >
                                    Confirm
                                </button>
                            </div>
                        </div>
                           
                    ))
                )}

                
                </div>
            </div>
            </div>
        </>
    )
};

export default BookingDetails;