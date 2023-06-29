import React from 'react'
import {BrowserRouter,Route,Routes} from 'react-router-dom'
import HotelBookingForm from './HotelBookingForm'

function App() {
  return (
    <BrowserRouter>
      <Routes>
      <Route path='/' element = {<div className="hotel-booking-form-container"><HotelBookingForm /></div>}></Route>
      </Routes>
    </BrowserRouter>
  );
}

export default App;
