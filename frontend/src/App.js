import React from 'react'
import {BrowserRouter,Route,Routes} from 'react-router-dom'
import HotelBookingForm from './HotelBookingForm'

import Control from './Control';
import Login from './Login';
import Home from './Home';


function App() {
  return (
    <BrowserRouter>
      <Routes>
      <Route path='/' element = {<div className="hotel-booking-form-container"><HotelBookingForm /></div>}></Route>
      <Route path='/landing' element={<Home/>}></Route>
      <Route path='/register' element={<Control />}></Route>
      <Route path='/login' element={<Login />}></Route>
      </Routes>
    </BrowserRouter>
  );
}

export default App;
