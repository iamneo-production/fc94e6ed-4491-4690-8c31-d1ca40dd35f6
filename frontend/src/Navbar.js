import React, { useState, useEffect } from "react";
import { Link } from "react-router-dom";
import './Navbar.css';

const Navbar = () => {

    const [userName, setUserName] = useState('');
    const [isLoggedIn, setIsLoggedIn] = useState(false);
    
    //const name = localStorage.getItem("name");

    useEffect(() => {
        // Retrieve the user's name from localStorage
        const storedName = localStorage.getItem('name');
        if (storedName) {
            setUserName(storedName);
        }
    }, [userName]);

    const handleLogout = () => {
        // Clear the user's name from localStorage
        localStorage.removeItem("name");
        setUserName("");
        setIsLoggedIn(false);
    };

    return (
        <>
            <nav className="navbar navbar-expand-lg navbar-light bg-light">
                <div className="container py-2">
                    <Link className="navbar-brand" to="/">Happy Booking</Link>
                    <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                        <span className="navbar-toggler-icon"></span>
                    </button>
                    {/* means */}
                    <div className="collapse navbar-collapse align-middle" id="navbarNav">
                        <ul className="navbar-nav mx-auto nav_ul align-items-center">
                            {/* <li className="nav-item dropdown">
                                <Link className="nav-link dropdown-toggle" to="/about" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                    About
                                </Link>
                                <ul className="dropdown-menu" aria-labelledby="navbarDropdown">
                                    <li><a className="dropdown-item" href="/">Action</a></li>
                                    <li><a className="dropdown-item" href="/">Another action</a></li>
                                    <li><a className="dropdown-item" href="/">Something else here</a></li>
                                </ul>
                            </li> */}
                            <li className="nav-item">
                                <Link className="nav-link" to="/room-types">Home</Link>
                            </li>
                            <li className="nav-item">
                                <Link className="nav-link" to="/bookings">Bookings</Link>
                            </li>
                            <li className="nav-item">
                                <Link className="nav-link" to="/about">About</Link>
                            </li>
                            <li className="nav-item">
                                <Link className="nav-link" to="/contact">Contact</Link>
                            </li>
                            
                            <div className="mx-3">
                                {userName ? (
                                    <span className="user-btn">
                                        {userName}
                                    </span>
                                ) : (
                                    <>
                                        <Link to="/register">
                                            <button type="button" className="btn1 mx-2">
                                                Customer
                                            </button>
                                        </Link>

                                        <Link to="/login">
                                            <button type="button" className="btn3 mx-2">
                                                Admin
                                            </button>
                                        </Link>
                                    </>
                                )}

                                <Link to="/home">
                                    <button type="button" className="logout mx-2" onClick={handleLogout}>
                                        Logout
                                    </button>
                                </Link>
                            </div>
                            
                        </ul>
                    </div>
                    {/* end */}
                </div>
            </nav>
            
        </>
    )
}

export default Navbar