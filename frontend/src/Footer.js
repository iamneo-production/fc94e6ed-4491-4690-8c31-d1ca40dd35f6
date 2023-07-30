import React from 'react'
import './Footer.css'
import { Link } from 'react-router-dom'


const Footer = () => {
  
    return (
        <>
            <div className="Footer">
                <div className="container">
                    <div className="row">
                        <div className="col-md-6 col-lg-5 col-12 ft-1">
                            <h3><span>Happy</span>Booking</h3>
                <p>In today’s world, reading is basic to everyday
                  life. As children we learn to read, and as adults,
                  we read to learn. We read to learn about the news,
                  to learn about rules, and to learn about how to do things.
                  We also use reading to learn English.</p>
                            <div className="footer-icons">
                                <i class="fa-brands fa-facebook"></i>
                                <i class="fa-brands fa-twitter"></i>
                                <i class="fa-brands fa-instagram"></i>
                                <i class="fa-brands fa-linkedin-in"></i>
                            </div>
                        </div>
                        <div className="col-md-6 col-lg-3 col-12 ft-2">
                            <h5>Quick Links</h5>
                            <ul>
                                <li className="nav-item">
                                    <Link to="/support">Support</Link>
                                </li>
                                
                                <li className="nav-item">
                                    <Link to="/contact">Contact Us</Link>
                                </li>
                                
                            </ul>
                        </div>
                        <div className="col-md-6 col-lg-4 col-12 ft-3">
                            <h5>Quick Links</h5>
                            <p><i class="fa-solid fa-phone-volume"></i> +91 9876543210</p>
                            <p><i class="fa-solid fa-envelope"></i> xyz@gmail.com</p>
                            
                        </div>
                    </div>
                </div>
            </div>
            <div className='Last-footer'>
              <p>Design By Team-30</p>
              <p>©copy rights reserved</p>
        
            </div>
        </>
    )
}

  export default Footer;
