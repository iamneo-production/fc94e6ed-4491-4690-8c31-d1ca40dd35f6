/*import React, { useState, useEffect } from 'react';
import { Link } from 'react-router-dom';
import axios from 'axios';
import RoomDetails from './RoomDetails';
import './RoomTypes.css';
import Navbar from './Navbar';
import { endpoint } from './config';

const RoomTypes = () => {
    const [rooms, setRooms] = useState([]);
    const [roomCounts, setRoomCounts] = useState({});

    useEffect(() => {
        fetchRooms();
    }, []);

    useEffect(() => {
        calculateRoomCounts();
    }, [rooms]);

    const fetchRooms = async () => {
        try {
            const response = await axios.get(`${endpoint.url}/api/rooms/`);
            setRooms(response.data);
        } catch (error) {
            console.error('Error fetching rooms:', error);
        }   
    };

    const calculateRoomCounts = () => {
        const counts = {};
        rooms.forEach((room) => {
            counts[room.roomType] = counts[room.roomType] ? counts[room.roomType] + 1 : 1;
        });
        setRoomCounts(counts);
    };

    const uniqueRoomTypes = [...new Set(rooms.map((room) => room.roomType))];

    return (
        <>
            <Navbar/>
        <div>
            <h2>Room Types</h2>
            <div className="room-types">
                {uniqueRoomTypes.map((roomType) => {
                    const room = rooms.find((room) => room.roomType === roomType);
                    return (
                        <div key={room.roomId} className="room-type">
                            
                            <Link to={`/room/${room.roomId}`}><h3>{room.roomType}</h3></Link>    
                                <p>Capacity: {room.capacity}</p>
                                <p>Price: {room.pricePerNight}</p>
                                <p>Count: {roomCounts[room.roomType] || 0}</p>
                            
                        </div>
                    );
                })}
            </div>
            {/*<RoomDetails
                roomCounts={roomCounts}
                updateRoomCount={(roomType, count) => setRoomCounts(prevCounts => ({ ...prevCounts, [roomType]: count }))}
            />
            </div>
        </>
        
    );
};

export default RoomTypes;*/

import React, { useState, useEffect } from 'react';
import { Link } from 'react-router-dom';
import axios from 'axios';
import RoomDetails from './RoomDetails';
import './RoomTypes.css';
import Navbar from './Navbar';
import { endpoint } from './config';
import image2 from './assets/image2.jpg';
import image5 from './assets/image5.jpg';
import image7 from './assets/image7.jpg';
import image9 from './assets/image9.jpg';
import image11 from './assets/image11.jpg';
import image6 from './assets/image6.jpg';
import image8 from './assets/image8.jpg';
import image10 from './assets/image10.jpg';

const roomTypeImages = {
    'Single basic': image2,
    'Single economy': image5,
    'Double Economy': image7,
    'Deluxe': image11,
    'Family Suite': image9,
    'Twin':image6,
    'King':image8,
    'Queen':image10,
  };
  
  const RoomTypes = () => {
    const [rooms, setRooms] = useState([]);
    const [roomCounts, setRoomCounts] = useState({});
  
    useEffect(() => {
      fetchRooms();
    }, []);
  
    useEffect(() => {
      calculateRoomCounts();
    }, [rooms]);
  
    const fetchRooms = async () => {
      try {
        const response = await axios.get(`${endpoint.url}/api/rooms/`);
        setRooms(response.data);
      } catch (error) {
        console.error('Error fetching rooms:', error);
      }   
    };
  
    const calculateRoomCounts = () => {
      const counts = {};
      rooms.forEach((room) => {
        counts[room.roomType] = counts[room.roomType] ? counts[room.roomType] + 1 : 1;
      });
      setRoomCounts(counts);
    };
  
    const uniqueRoomTypes = [...new Set(rooms.map((room) => room.roomType))];
  
    return (
      <>
        <Navbar />
        <div>
          <h2>Room Types</h2>
          <div className="room-types">
            {uniqueRoomTypes.map((roomType) => {
              const room = rooms.find((room) => room.roomType === roomType);
              const roomImage = roomTypeImages[roomType];
  
              return (
                <div key={room.roomId} className="room-type">
                  <Link to={`/room/${room.roomId}`}>
                    {/* Render the image from the room type image mapping */}
                    {roomImage && <img src={roomImage} alt={`Room ${room.roomType}`} />}
                    <h3>{room.roomType}</h3></Link>
                    <p>Capacity: {room.capacity}</p>
                    <p>Price: {room.pricePerNight}</p>
                    <p>Count: {roomCounts[room.roomType] || 0}</p>
                  
                </div>
              );
            })}
          </div>
          {/* <RoomDetails
            roomCounts={roomCounts}
            updateRoomCount={(roomType, count) => setRoomCounts(prevCounts => ({ ...prevCounts, [roomType]: count }))}
          /> */}
        </div>
      </>
    );
  };
  
  export default RoomTypes;