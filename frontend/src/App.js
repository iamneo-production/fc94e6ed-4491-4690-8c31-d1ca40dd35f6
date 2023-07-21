import React from 'react'
import {BrowserRouter,Route,Routes} from 'react-router-dom'
import HotelBookingForm from './HotelBookingForm'

import Control from './Control';
import Login from './Login';
import Home from './Home';
import ContactUs from './ContactUs';
import About from './About';
import Profile from './Profile';
import RoomDetails from './RoomDetails';
import RoomTypes from './RoomTypes';
import Bookings from './Bookings';
import BookingDetails from './BookingDetails';

function App() {
  return (
    <BrowserRouter>
      <Routes>
      <Route path='/' element = {<div className="hotel-booking-form-container"><HotelBookingForm /></div>}></Route>
      <Route path='/landing' element={<Home/>}></Route>
      <Route path='/register' element={<Control />}></Route>
      <Route path='/login' element={<Login />}></Route>
      <Route path='/about' element={<About/>}></Route>
      <Route path='/contact' element={<ContactUs />}></Route>
      <Route path='/profile' element={<Profile/>}></Route>
      <Route path='/room/:roomId' element={<RoomDetails/>}></Route>
      <Route path='/home' element={<Home />}></Route>
      <Route path='/room-types' element={<RoomTypes/>}></Route>
      <Route path="/booking-details" element={<BookingDetails />} />
      <Route path='/bookings' element={<Bookings />}></Route>

      </Routes>
    </BrowserRouter>
  );
}

export default App;
