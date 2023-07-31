import React from 'react'
import bg from './assets/background-Image.jpg'
import './Home.css';
import Navbar from './Navbar';

const Home = () => {
  return (
      <>
          <Navbar/>
          <div className='container' my-5 py-5>
              <div className='row align-items-center'>
                  <div className='img-text' >
                      <div className='home'>
                        <h2 >It's Time For Booking</h2>
                          <p >In today’s world, reading is basic to everyday
                            life. As children we learn to read, and as adults,
                              we read to learn.
                          </p>
                          <button type='button' className='btn'>Book Now</button>
                          
                      </div>
                      <div>
                          <div className='home'>
                              <img src={bg} alt="there is an image"className='img-fluid' />
                              
                          </div>
                          
                      </div>
                      
                  </div>
                  
              </div>
              
          </div>
      </>
  )
}

export default Home
