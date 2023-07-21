import React, { useState, useEffect } from 'react';
import { useParams } from 'react-router-dom';
import axios from 'axios';
import { useNavigate } from "react-router-dom";
import './RoomDetails.css'
import Navbar from './Navbar';
import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import image1 from './assets/im1.jpg';
import image2 from './assets/image2.jpg';
import image3 from './assets/image3.jpg';
import image4 from './assets/im6.jpg';
import image5 from './assets/image4.jpg';
import image6 from './assets/image5.jpg';
import image7 from './assets/im8.jpg';
import image8 from './assets/image6.jpg';
import image9 from './assets/image7.jpg';
import image10 from './assets/im17.jpg';
import image11 from './assets/image8.jpg';
import image12 from './assets/image9.jpg';
import image13 from './assets/im15.jpg';
import image14 from './assets/image10.jpg';
import image15 from './assets/image11.jpg';

const RoomDetails = () => {
    const { roomId } = useParams();
    const [room, setRoom] = useState(null);
    const [roomCounts, setRoomCounts] = useState({});
    const [bookingForm, setBookingForm] = useState({
        mobileNumber: '',
        checkIn: '',
        checkOut: '',
        price: 0,
        capacity: 0,
    });

    const id = localStorage.getItem("customerId");
    const navigate = useNavigate();
    

    useEffect(() => {
        fetchRoom(roomId);
    }, [roomId]);

    useEffect(() => {
        calculateRoomCounts();
    }, [room]);

    useEffect(() => {
        // Retrieve the roomCounts from localStorage
        const storedRoomCounts = localStorage.getItem('roomCounts');
        if (storedRoomCounts) {
            setRoomCounts(JSON.parse(storedRoomCounts));
        }
    }, []);


    const calculateRoomCounts = async () => {
        try {
            const response = await axios.get('http://localhost:8080/api/rooms/');
            const rooms = response.data;
            if (room && room.roomType) {
                const counts = { ...roomCounts };
                counts [room.roomType]= 0 ;
                rooms.forEach((r) => {
                    if (r.roomType === room.roomType) {
                        counts[room.roomType]++;
                    }
                });
                setRoomCounts(counts);
                localStorage.setItem('roomCounts', JSON.stringify(counts));

            }
        } catch (error) {
            console.error('Error fetching rooms:', error);
        }
    };

    

    const fetchRoom = async (roomId) => {
        try {
            const response = await axios.get(`http://localhost:8080/api/rooms/${roomId}`);
            if (response.data) {
                setRoom(response.data);
                setBookingForm({
                    ...bookingForm,
                    price: response.data.pricePerNight,
                    capacity: response.data.capacity,
                });
            } else {
                // Handle the case when the response data is null or undefined
                console.error('Room not found');
            }
        }
        catch (error) {
            console.error('Error fetching room:', error);
        }
    };

    

    const handleBookingFormChange = (e) => {
        setBookingForm({
            ...bookingForm,
            [e.target.name]: e.target.value,
        });
    };

    const handleBooking = async () => {
        try {
            // Create a new room booking
            const roomBookingData = {
                roomId: room.roomId,
                checkInDate: bookingForm.checkIn, // Include the checkInDate value
                checkOutDate: bookingForm.checkOut,
                
                
            };
           const res =  await axios.post(`http://localhost:8080/api/v1/customers/${id}/rooms/${roomId}/bookings`, roomBookingData);
            console.log("booking done", res.data);
            
            
            // Update the room count
            
            setRoomCounts(prevCounts => ({
                ...prevCounts,
                [room.roomType]: prevCounts[room.roomType] - 1
            }));

            toast.success('Booked successfully', {
                position: toast.POSITION.TOP_RIGHT,
                autoClose: 2000, // Close the toast after 5 seconds
                onClose: () => {
                    navigate('/booking-details');
                }
            });
           
        } catch (error) {
            console.error('Error booking room:', error);
        }
    };

    if (!room) {
        return null;
    }

    let description, facilities, images;

    switch (room.roomType) {
        case 'Single basic':
            description =
                'The Single Rooms Basic are about 20 m² in size, provide space for up to two persons and have a small east-facing balcony in direction to the village.';
            facilities = [
                'Facility 1: Single bed, a bed couch and a bathroom with shower and toilet.',
                'Facility 2: Moreover, the Single Rooms have a wooden floor and feature TV, Wi-Fi, telephone, mini-fridge, safe, and a hairdryer',
            ];
            images = [image1, image2, image3];
            break;
        case 'Single economy':
            description = 'Room which offers comfort with. Single bed, ideal for people. travelling for work or to enjoy their. vacation.';
            facilities = ['Facility 1:  Coffee & Tea Maker', 'Facility 4: Slippers, Wake Up Service'];
            images = [image4, image5, image6];
            break;
        case 'Double Economy':
            description = 'Economy Double Rooms are perfect for guests who want a comfortable stay, but are on a budget.';
            facilities = ['Facility 1: Walk-in rain shower,Coffee, Private Balcony', 'Facility 2: Luxury Bath Amenities & necessities,Hairdryer '];
            images = [image7, image8, image9];
            break;
        case 'Deluxe':
            description = ' Deluxe rooms are usually larger than their standard counterparts, may include a bathtub and a shower in the bathroom';
            facilities = ['Facility 1: King or twin beds,Individual climate control,Mini-bar ', 'Facility 2: Shower,Hair-dryer '];
            images = [image13, image14, image15];
            break;
        case 'Family Suite':
            description = 'Our Family Suite Room features the largest and most luxurious among other room categories is ideal for families';
            facilities = ['Facility 1:  living area, pantry, private balcony ', 'Facility 2: extra guests amenities '];
            images = [image10, image11, image12];
            break;
        default:
            description = 'Room Description Not Available';
            facilities = [];
            images = [];
    }

    return (
        <>
            <Navbar />
            <ToastContainer />
        <div className="pagesize">
            <h2>{room.roomType}</h2>
            <div className="room-details">
               <div className="room-images">
                    {images.map((image, index) => (
                        <img key={index} src={image} alt={`Room ${room.roomType} Image ${index}`} />
                    ))}
                </div>
                <div className="room-info">
                    <p>Description: {description}</p>
                    <p>Capacity: {room.capacity}</p>
                    <p>Price: {room.pricePerNight}</p>
                    <p>Count: {roomCounts[room.roomType] || 0}</p>
                    <ul>
                        {facilities.map((facility, index) => (
                            <li key={index}>{facility}</li>
                        ))}
                    </ul>
                </div>
            </div>
            <div className="booking-form">
                <h3>Booking Form</h3>
                {/* <div>
                    <label>Mobile Number:</label>
                    <input
                        type="text"
                        name="mobileNumber"
                        value={bookingForm.mobileNumber}
                        onChange={handleBookingFormChange}
                    />
                        </div>*/}
                <div>
                    <label>Check-in:</label>
                    <input
                        type='Date'
                        
                        name="checkIn"
                        value={bookingForm.checkIn}
                        onChange={handleBookingFormChange}
                    />
                </div>
                <div>
                    <label>Check-out:</label>
                    <input
                        type='Date'
                        
                        name="checkOut"
                        value={bookingForm.checkOut}
                        onChange={handleBookingFormChange}
                    />
                </div>
                {/*<div>
                    <label>Price:</label>
                    <input
                        type="number"
                        name="price"
                        value={bookingForm.price}
                        readOnly
                    />
                    </div>
                <div>
                    <label>Capacity:</label>
                    <input
                        type="number"
                        name="capacity"
                        value={bookingForm.capacity}
                        readOnly
                    />
                    </div>*/}
                <button onClick={handleBooking}>Book Now</button>
            </div>

            <div className="hotel-rules">
                <h2>House Rules</h2>
                <p>
                    {room.roomType}, a Luxury Collection Room
                </p>
                <div className="rule">
                    <h3>Check-in</h3>
                    <p>From 15:00</p>
                    <p>Guests are required to show a photo identification and credit card upon check-in.</p>
                </div>
                <div className="rule">
                    <h3>Check-out</h3>
                    <p>Until 12:00</p>
                </div>
                <div className="rule">
                    <h3>Cancellation/Prepayment</h3>
                    <p>
                        Cancellation and prepayment policies vary according to accommodation type. Please enter the dates of your stay
                        and check the conditions of your required room.
                    </p>
                </div>
                <div className="rule">
                    <h4>Child Policies</h4>
                    <p>Children of any age are welcome.</p>
                    <p>
                        To see correct prices and occupancy information, please add the number of children in your group and their ages
                        to your search.
                    </p>
                    <p>The number of extra beds and cots allowed is dependent on the option you choose. Please check your selected option for more information.</p>
                    <p>All cots and extra beds are subject to availability.</p>
                </div>
                <div className="rule">
                    <h3>Age Restriction</h3>
                    <p>The minimum age for check-in is 18.</p>
                </div>
                <div className="rule">
                    <h3>Pets</h3>
                    <p>Pets are allowed. Charges may be applicable.</p>
                </div>
                <div className="rule">
                    <h3>Groups</h3>
                    <p>When booking more than 9 rooms, different policies and additional supplements may apply.</p>
                </div>
            </div>

            </div>
            <ToastContainer position={toast.POSITION.TOP_RIGHT} />
        </>
    );
};

export default RoomDetails;