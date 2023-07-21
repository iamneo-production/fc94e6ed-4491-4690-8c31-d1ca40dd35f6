import React, { useState, useEffect } from 'react';
import { Link } from 'react-router-dom';
import axios from 'axios';
import RoomDetails from './RoomDetails';
import './RoomTypes.css';
import Navbar from './Navbar';

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
            const response = await axios.get('http://localhost:8080/api/rooms/');
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
            />*/}
            </div>
        </>
        
    );
};

export default RoomTypes;