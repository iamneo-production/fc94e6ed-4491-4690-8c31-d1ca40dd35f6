import React, { useState } from 'react';
import './HotelBookingForm.css';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';

const HotelBookingForm = () => {
  const [hotelsData, setHotelsData] = useState([])
  const [destination, setDestination] = useState('')
  const [currentPage, setCurrentPage] = useState(1)
  

  const hotelsPerPage = 4;
  const indexOfLastHotel = currentPage * hotelsPerPage;
  const indexOfFirstHotel = indexOfLastHotel - hotelsPerPage;
  const currentHotels = hotelsData.slice(indexOfFirstHotel, indexOfLastHotel);

  const handleSearch = async (e) => {
    e.preventDefault();
    const response = await axios.get('http://localhost:8081/hotels', {
      params: {
        cityName: destination,
      },
    });
    console.log(response.data);
    setHotelsData(response.data);
    setCurrentPage(1);
    console.log('Search:', destination);
  };

  const navigate = useNavigate();

  const handleButtonClick = (location) => {
    navigate(`/${location}`);
  };

  const handleNextPage = () => {
    setCurrentPage(currentPage + 1);
  };

  const handlePreviousPage = () => {
    setCurrentPage(currentPage - 1);
  };
  

  return (
    <div>
        <div className="container">
        
        <form className="search-form" onSubmit={handleSearch}>
          <input
            type="text"
            placeholder="Destination"
            value={destination}
            onChange={(e) => setDestination(e.target.value)}
          />

          <button type="submit">Search</button>
        </form>
        <h2 style={{textAlign:'center', color:'blue'}}>ENTER LOCATION TO VIEW LIST OF HOTELS</h2>
        <p style={{textAlign:'center',color:'blue'}}>(Chennai,Bangalore,Mumbai,Delhi)</p>
        <div className="hotel-list">
          {currentHotels.map((hotel) => (
            <div className="hotels-item" key={hotel.id}>
            <h1 className="hotel-name" >{hotel.name}</h1>
            <h2 className="hotel-price">Price: {hotel.price}</h2>
            <h2 className="hotel-city">City: {hotel.cityName}</h2>
            <h2 className="hotel-city">Rating: {hotel.rating}</h2>
              <img
                src={hotel.imageUrl}
                style={{
                  float: 'right',
                  height: '150px',
                  width: '230px',
                  marginTop: '-130px',
                }}
              />
            </div>
          ))}
        </div> 

        <div className="pagination">
          {currentPage > 1 && (
            <button onClick={handlePreviousPage}>Previous</button>
          )}
          {hotelsData.length > indexOfLastHotel && (
            <button onClick={handleNextPage}>Next</button>
          )}
        </div>
      </div>
      <h2 style={{textAlign:'center',color:'blue'}}>(Please click the location for hotel booking)</h2>
      <h2>POPULAR DESTINATION</h2>
      <div className="popular-destinations">
        <div className="destination-box chennai">
          <button onClick={() => handleButtonClick('Chennai')}>
            <h3>Chennai</h3>
          </button>
          <p>Explore the vibrant culture and beautiful beaches.</p>
        </div>
        <div className="destination-box bangalore">
          <button onClick={() => handleButtonClick('Bangalore')}>
            <h3>Bangalore</h3>
          </button>
          <p>Discover the tech hub and lush green gardens.</p>
        </div>
        <div className="destination-box delhi">
          <button onClick={() => handleButtonClick('Delhi')}>
            <h3>Delhi</h3>
          </button>
          <p>Experience the historical monuments and delicious street food.</p>
        </div>
        <div className="destination-box mumbai">
          <button onClick={() => handleButtonClick('Mumbai')}>
            <h3>Mumbai</h3>
          </button>
          <p>Enjoy the Bollywood charm and bustling city life.</p>
        </div>
      </div>
      </div>
  );
};

export default HotelBookingForm;
