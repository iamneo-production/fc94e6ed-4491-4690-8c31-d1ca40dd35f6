import React, { useEffect, useState } from 'react';
//import { Link } from "react-router-dom";
import axios from 'axios';
import Sidebar from './Sidebar';
import {endpoint} from '../config';

const AllBookings = () => {

  const [bookingData, setBookingdata] = useState([]); 
  const [filterData, setFilterData] = useState([]);
  const [query, setQuery] = useState('');
  const [bookings, setbookings] = useState([]);
  
    useEffect( ()=>{
        const getBookingdata= async()=>{
        try {
          const response = await axios.get(`${endpoint.url}/api/v1/`);
          console.log(response)
          const data = response.data;
          console.log(data)
          setBookingdata(data);
          setFilterData(data);
        } catch (error) {
          console.error('Error fetching booking data:', error);
        }
      };
      getBookingdata();
    }, []);
  
  const handleSearch = (event) => {
    const getSearch = event.target.value.trim().toLowerCase();
    console.log(getSearch); // Check the search query
    if (getSearch.length > 0) {
      const searchdata = filterData.filter((item) =>
        
        item.checkInDate.toString().includes(getSearch) ||
        item.checkOutDate.toLowerCase().includes(getSearch) ||
        item.room.roomType.toLowerCase().includes(getSearch)
      );
      console.log(searchdata); // Check the filtered data
      setBookingdata(searchdata);
    } else {
      setBookingdata(filterData);
    }

    setQuery(getSearch);
  };

  const count = bookingData.length;

  const deleteBooking = async (id) => {
    try {
      await axios.delete(`${endpoint.url}/api/v1/${id}`);
      setBookingdata(bookingData.filter((booking) => booking.id !== id));
      setbookings(bookings.filter((booking) => booking.id !== id));
      console.log("booked data deleted")
    } catch (error) {
      console.error('Error deleting booking:', error);
    }
  };

 
  
  
  return (
    
    
      <React.Fragment>
      <div style={{ display: 'flex' }}>
        <Sidebar />
        <div className="container" style={{ backgroundColor: "aliceblue" }}>
          <h1 className="text-center pt-5 pb-5" style={{ color: "white", backgroundColor: "lightslategrey" }}>Admin Dashboard</h1>     
                <div className="row">
                    <div className="col-md-12">
                    <h2 className="mt-5">All Bookings</h2>
                      <div className='col-md-6 mt-3'>
                        <input type='text' name='name' value={query}
                          className='form-control' onChange={(e)=>handleSearch(e)}
                            placeholder='search...'
                        />
              
                      </div>
                      <h5 className='mt-3'>Number of Records: {count}</h5> {/* Display the count */}
                       <table className="table table-bordered table-striped mt-5">
                        <thead>
                        <tr>
                        <th>Booking Id</th>
                        
                        <th>CheckIn</th>
                        <th>CheckOut</th>
                        <th>Room Type</th>
                        <th>Price</th>
                        <th>Status</th>
                        <th>Actions</th>
                        
                        
                      </tr>
                        </thead>
                        <tbody>
                {bookingData && bookingData.map((booking, id) => (
                  
                   <tr key={id}>
                    <td>{booking.id}</td>
                    
                    <td>{new Date(booking.checkInDate).toLocaleDateString()}</td>
                    <td>{new Date(booking.checkOutDate).toLocaleDateString()}</td>
                    <td>{ booking.room.roomType}</td> 
                    <td>{booking.room.pricePerNight}</td>
                    <td>booked</td>    
                        <td>
                          <button onClick={() => deleteBooking(booking.id)} className="btn btn-danger">Cancel</button>
                         </td>
                        </tr>
                        ))
                        }
                        </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div> 
       
      </React.Fragment>
    
  )
  
}

export default AllBookings


