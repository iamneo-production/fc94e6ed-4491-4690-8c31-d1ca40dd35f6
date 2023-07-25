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
import Dashboard from './Admin/Dashboard';
// import ViewUsers from './Admin/ViewUsers';
import RoomManagement from './Admin/RoomManagement';
import AllBookings from './Admin/AllBookings';
// import ManagePayments from './Admin/ManagePayments';
// import Cancellations from './Admin/Cancellations';
import AllRoomsPage from './Admin/AllRoomsPage';

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

           <Route path='/admin' element={<Dashboard/>}/>
          <Route path='/admin/dashboard' element={<Dashboard/>} /> 
           {/* <Route path='/admin/view-users' element={<ViewUsers/>} /> */}
          <Route path='/admin/manage-rooms' element={<RoomManagement/>}/>
          <Route path='/admin/manage-bookings' element={<AllBookings />} />
          {/* <Route path='/admin/manage-payments' element={<ManagePayments />} />
  <Route path='/admin/cancellations' element={<Cancellations/>}></Route> */}
          <Route path='/AllRoomsPage' element={<AllRoomsPage/>}></Route>

      </Routes>
    </BrowserRouter>
  );
}

export default App;
