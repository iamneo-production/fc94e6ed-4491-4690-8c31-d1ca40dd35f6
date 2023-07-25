import React, { useState, useEffect } from 'react';
import axios from 'axios';
import './AllRoomsPage.css';
import {endpoint} from '../config';

const AllRoomsPage = () => {
  const [rooms, setRooms] = useState([]);
  const [updateRoom, setUpdateRoom] = useState(null);
  const [newRoom, setNewRoom] = useState({
    roomType: '',
    capacity: 0,
    available: true || false,
    pricePerNight: 0.0,
  });
  useEffect(() => {
    fetchRooms();
  }, []);

  const fetchRooms = async () => {
    try {
      const response = await axios.get(`${endpoint.url}/api/rooms/`);
      setRooms(response.data);
    } catch (error) {
      console.error('Error fetching rooms:', error);
    }
  };

  const createRoom = async () => {
    try {
      const response = await axios.post(`${endpoint.url}/api/rooms/`, newRoom);
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

  const deleteRoom = async (roomId) => {
    try {
      await axios.delete(`${endpoint.url}/api/rooms/${roomId}`);
      setRooms(rooms.filter((room) => room.roomId !== roomId));
    } catch (error) {
      console.error('Error deleting room:', error);
    }
  };

  const updateRoomDetails = async () => {
    try {
      const response = await axios.put(`${endpoint.url}/api/rooms/${updateRoom.roomId}`, updateRoom);
      const updatedRooms = rooms.map((room) =>
        room.roomId === response.data.roomId ? response.data : room
      );
      setRooms(updatedRooms);
      setUpdateRoom(null);
    } catch (error) {
      console.error('Error updating room:', error);
    }
  };


  return (
    <div>
      <h2>All Rooms</h2>
      <table>
        <thead>
          <tr>
            <th>Room ID</th>
            <th>Room Type</th>
            <th>Capacity</th>
            <th>Is Available</th>
            <th>Price Per Night</th>
          </tr>
        </thead>
        <tbody>
          {rooms.map((room) => (
            <tr key={room.roomId}>
              <td>{room.roomId}</td>
              <td>{room.roomType}</td>
              <td>{room.capacity}</td>
              <td>{room.available ? 'Yes' : 'No'}</td>
              <td>{room.pricePerNight}</td>
              <td>
                  <button onClick={() => setUpdateRoom(room)}>Edit</button>
                  <button onClick={() => deleteRoom(room.roomId)}>Delete</button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>

      {updateRoom && (
        <div>
          <h2>Update Room Details</h2>
          <div>
            <label>Room Type:</label>
            <input
              type="text"
              value={updateRoom.roomType}
              onChange={(e) => setUpdateRoom({ ...updateRoom, roomType: e.target.value })}
            />
          </div>
          <div>
            <label>Capacity:</label>
            <input
              type="number"
              value={updateRoom.capacity}
              onChange={(e) => setUpdateRoom({ ...updateRoom, capacity: parseInt(e.target.value) })}
            />
          </div>
          <div>
            <label>Is Available:</label>
            <input
              type="checkbox"
              checked={updateRoom.available}
              onChange={(e) => setUpdateRoom({ ...updateRoom, available: e.target.checked })}
            />
          </div>
          <div>
            <label>Price Per Night:</label>
            <input
              type="number"
              step="0.01"
              value={updateRoom.pricePerNight}
              onChange={(e) => setUpdateRoom({ ...updateRoom, pricePerNight: parseFloat(e.target.value) })}
            />
          </div>
          <button onClick={updateRoomDetails}>Update</button>
        </div>
      )}
    </div>
  );
};

export default AllRoomsPage;