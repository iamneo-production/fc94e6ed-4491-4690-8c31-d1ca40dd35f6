import React, { useState, useEffect } from 'react';
import axios from 'axios';
import './RoomManagement.css';
import { Link } from 'react-router-dom';
import { endpoint } from '../config';
 import Sidebar from './Sidebar';

const RoomManagement = () => {
  const [rooms, setRooms] = useState([]);
  const [newRoom, setNewRoom] = useState({
    roomType: '',
    capacity: 0,
    available: true,
    pricePerNight: 0.0,
  });
  const [roomCounts, setRoomCounts] = useState({});

  useEffect(() => {
    fetchRooms();
  }, []);

  useEffect(() => {
    calculateRoomCounts();
  }, [rooms]);

  const fetchRooms = async () => {
    try {
      const response = await axios.get(`${endpoint.url}api/rooms/`);
      setRooms(response.data);
    } catch (error) {
      console.error('Error fetching rooms:', error);
    }
  };

  const createRoom = async () => {
    try {
      const response = await axios.post(`${endpoint.url}api/rooms/`, newRoom);
      setRooms([...rooms, response.data]);
      setNewRoom({
        roomType: '',
        capacity: 0,
        available: true,
        pricePerNight: 0.0,
      });
    } catch (error) {
      console.error('Error creating room:', error);
    }
  };

  const calculateRoomCounts = () => {
    const counts = {};
    rooms.forEach((room) => {
      counts[room.roomType] = counts[room.roomType] ? counts[room.roomType] + 1 : 1;
    });
    setRoomCounts(counts);
  };

  return (

  <div className='backimg'>
    <div style={{ display: 'flex' }}>
                <Sidebar />
    
    <div className="containor">
      {/* <h1>Room Management</h1> */}
    {/* <Sidebar/> */}
      <div className="main-content">
        <h1>Room Management</h1>
        <div className='Link'>
        <Link to="/AllRoomsPage">
          <button className="custom-button">List Of Rooms</button> 
        </Link>
        </div>

        {/* <h2>Create Room</h2> */}
        <div>
          <label>Room Type:</label>
          <input
            type="text"
            value={newRoom.roomType}
            onChange={(e) => setNewRoom({ ...newRoom, roomType: e.target.value })}
          />
        </div>
        <div>
          <label>Capacity:</label>
          <input
            type="number"
            value={newRoom.capacity}
            onChange={(e) => setNewRoom({ ...newRoom, capacity: parseInt(e.target.value) })}
          />
        </div>
        <div>
          <label>Is Available:</label>
          <input
            type="checkbox"
            checked={newRoom.available}
            onChange={(e) => setNewRoom({ ...newRoom, available: e.target.checked })}
          />
        </div>
        <div>
          <label>Price Per Night:</label>
          <input
            type="number"
            step="0.01"
            value={newRoom.pricePerNight}
            onChange={(e) => setNewRoom({ ...newRoom, pricePerNight: parseFloat(e.target.value) })}
          />
        </div>
        <button onClick={createRoom}>Create</button>
      </div>

      <div className="room-count-sidebar">
        <h3>Room Counts</h3>
        {Object.entries(roomCounts).map(([roomType, count]) => (
          <p key={roomType}>
            {roomType}: {count}
          </p>
        ))}
      </div>
    </div>
    </div>
    </div>
  );
};

export default RoomManagement;