import React, { useState} from "react";
import './LoginReg.css';
import axios from "axios";
import { useNavigate } from "react-router-dom";
import Navbar from "./Navbar";
import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import {endpoint} from './config';


function Register(props) {
    const [name, setName] = useState("");
    const [email, setEmail] = useState("");
    const [phone, setPhone] = useState("");
    const [nameError, setNameError] = useState("");
    const [emailError, setEmailError] = useState("");
    const [phoneError, setPhoneError] = useState("");


    const navigate = useNavigate();

    const user = {
        name,
        email,
        phone
    }

    //console.log(user);

    /*const handleRegister = async () => {
        try {
            const apiUrl = "http://localhost:8282/api/v1/customers";
            const data = {
                name,
                email,
                phone
            };

            const response = await axios.post(apiUrl, data);
            console.log("Data posted successfully:", response.data);

            const customerId = response.data.customerId;
            localStorage.setItem("customerId", customerId);
            localStorage.setItem("name", name);

            await toast.promise(
                new Promise((resolve) => setTimeout(resolve)), // Delay for 1 second before resolving the promise
                {
                    pending: 'Registering...',
                    success: 'Registered successfully',
                    position: toast.POSITION.TOP_RIGHT,
                    autoClose: 2000 // Close the toast after 5 seconds
                }
            );

            navigate('/home');
        }
        catch (error) {
            console.error("Error posting data:", error);
        }
    
    };*/

    const handleSubmit = async (e) => {
        e.preventDefault();

        setNameError("");
        setEmailError("");
        setPhoneError("");
        let hasError = false;

        if (name.trim() === "") {
            setNameError("Name is required.");
            hasError = true;
        } else if (!/^[A-Za-z\s]+$/.test(name)) {
            setNameError("Name should only contain alphabets.");
            hasError = true;
        } else if (name.length < 3) {
            setNameError("Name should be at least 3 characters long.");
            hasError = true;
        }

        if (email.trim() === "") {
            setEmailError("Email is required.");
            hasError = true;
        } else if (!/^\S+@\S+\.\S+$/.test(email)) {
            setEmailError("Invalid email address.");
            hasError = true;
        }

        if (phone.trim() === "") {
            setPhoneError("Phone number is required.");
            hasError = true;
        } else if (phone.length < 10) {
            setPhoneError("Phone number should be 10 characters long.");
            hasError = true;
        }

        if (!hasError) {
            console.log("Registration successful!");

            try {
                const apiUrl = `${endpoint.url}/api/v1/customers`;
                const data = {
                    name,
                    email,
                    phone,
                };

                const response = await axios.post(apiUrl, data);
                console.log("Data posted successfully:", response.data);

                const customerId = response.data.customerId;
                localStorage.setItem("customerId", customerId);
                localStorage.setItem("name", name);

                await toast.promise(
                    new Promise((resolve) => setTimeout(resolve)), // Delay for 1 second before resolving the promise
                    {
                        pending: "Registering...",
                        success: "Registered successfully",
                        position: toast.POSITION.TOP_RIGHT,
                        autoClose: 2000, // Close the toast after 5 seconds
                    }
                );

                navigate("/room-types");
            } catch (error) {
                console.error("Error posting data:", error);
            }
        }
    };


    return (
        <>
        <Navbar/>
        <div className="form-container">
            <h2>Register</h2>
            <form className="register-form" onSubmit={handleSubmit}>
                <label htmlFor="name">Name</label>
                <input
                    value={name}
                    name="name"
                    onChange={(e) => setName(e.target.value)}
                    id="name"
                    placeholder="Enter name"
                />
                {nameError && <div className="error">{nameError}</div>}

                <label htmlFor="email">Email</label>
                <input
                    value={email}
                    onChange={(e) => setEmail(e.target.value)}
                    type="email"
                    placeholder="youremail@gmail.com"
                    id="email"
                    name="email"
                />
                {emailError && <div className="error">{emailError}</div>}

                <label htmlFor="phone">Phone</label>
                <input
                    value={phone}
                    onChange={(e) => setPhone(e.target.value.replace(/\D/, ""))}
                    maxLength={10}
                    placeholder="phone"
                    id="password"
                    name="password"
                />
                {phoneError && <div className="error">{phoneError}</div>}

                <button className="rcb" type="submit">Register</button>
            </form>
            <button
                className="link-btn"
                onClick={() => props.onFormSwitch("login")}
            >
                Already have an account? Login here.
            </button>
            </div>
        </>
    );
};

export default Register;