import React,{Fragment} from 'react';
import ramada from './assets/ramada.jpg';
import Taj from './assets/Taj.jpg';
import jaipur from './assets/jaipur.jpg';
import './About.css';
import Navbar from './Navbar';

const About=()=>{
    
    return(
        <Fragment>
            <Navbar/>
        <section className="about">
            <div children="row">
                <div className="column">
                    <div className='about-img'></div>
                </div>
                <div className="column">
                <div className="tabs">

                    <div className="single-tab active-tab">
                    
                       <h2>About Us</h2>
                    </div>
                </div>

                <div className="tab-content">
                    <div className="content ">
                       
                        <p>Book your Hotel with ease and no hustle!HOTELBOOKING connects you 
                        to India's leading Hotels,brings you to the flexibility and convenience 
                        you should have.Our platform shows the room rates for you to compare and 
                        help you pick your best. If you are a Hotel, wish to be a part of 
                        HOTELBOOKING network. Our advanced application 
                        helps our clients manage guest flow by generating quick stay-in reports with Check-in, 
                        Check-out dates, enabling you to confirm your booking and ease in cancellation.If you are 
                        a customer it will help you to choose hotel according to you ease.For any issue
                        please contact us at :____________@gmail.com. </p>
                    </div>
                    <div className="content">
                                            
                        <div className="skills-row">

                            <div className="skills-column">
                                <div className="progress-wrap">
                                    <h3>UserFriendly-Interface</h3>
                                    <div className="progress">
                                        <div className="progress-bar">
                                            <span>100%</span>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div className="skills-column">
                                <div className="progress-wrap">
                                    <h3>Issue-Assistance</h3>
                                    <div className="progress">
                                        <div className="progress-bar">
                                            <span>99%</span>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div className="skills-column">
                                <div className="progress-wrap">
                                    <h3>Integerated-payment-Gateway</h3>
                                    <div className="progress">
                                        <div className="progress-bar">
                                            <span>100%</span>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div className="skills-column">
                                <div className="progress-wrap">
                                    <h3>Easy-Management</h3>
                                    <div className="progress">
                                        <div className="progress-bar">
                                            <span>88%</span>
                                        </div>
                                    </div>
                                </div>
                            </div>

                        </div>
                    </div>

                    {/* {Experience content} */}
                    <div className="content">
                    <h2>Few of the top rated hotels are: </h2>
                    <div className="exp-column">
                        <h3>Ramada</h3>
                        <img src={ramada} height={250} width={300} />
                        <div >
                            <p>
                                Location: Siliguri<br/> 
                                Rooms:500+ <br/>
                                Parking: 4 Wheeler,2 wheeler<br/>
                                Hospitality:24/7<br/>
                                Compimentary breakfast<br/>
                            </p>
                        </div>
                    </div>   

                    <div className="exp-column">
                        <h3>Golden Tulip</h3>
                        <img src={jaipur} height={250} width={300}  />
                        <p>
                        Location: Jaipur<br/> 
                        Rooms:900+ <br/>
                        Parking: All types of vehicle<br/>
                        Hospitality:24/7<br/>
                        Swimming pool,Lawn<br/>
                        </p>
                    </div>  

                    <div className="exp-column">
                        <h3>Taj Hotel</h3>
                        <img src={Taj} height={250} width={300} />
                        <p>
                        Location: Mumbai<br/> 
                        Rooms:4000+ <br/>
                        Parking: All types of vehicle<br/>
                        Hospitality:24/7<br/>
                        
                        Swimming pool,Cafeteria,Lawn,Conference halls etc. <br/>
                        </p>
                    </div>  

                    </div>

                </div>
            </div>
            </div>
        </section>
        </Fragment>
          
           
         
        
    )
}
export default About