import React, { useState } from "react";
import './LoginReg.css';
import { useNavigate } from "react-router-dom";
//import { withRouter } from "react-router-dom";
import Navbar from "./Navbar";
import './LoginReg.css';


function Login(props) {

    const [email, setEmail] = useState('');
    const [pass, setPass] = useState('');
    const [emailError, setEmailError] = useState('');
    const [passError, setPassError] = useState('');
    
    const user = {
        email,
        pass
    }

    const navigate = useNavigate();
    
    const handleLogin = () => {
        if (email === "admin@gmail.com" && pass=== "admin") {
            console.log("Login successful! Redirecting to admin page...");
            navigate("/admin");
            // Redirect to the admin page
            
        } else {
            //set the user name on the navbar
            //and navigate to rooms page

        }    
    };

    const handleSubmit = (e) => {
        e.preventDefault();

        setEmailError('');
        setPassError('');

        let hasError = false;

        if (email.trim() === '') {
            setEmailError('Email is required.');
            hasError = true;
        } else if (!/^\S+@\S+\.\S+$/.test(email)) {
            setEmailError('Invalid email address.');
            hasError = true;
        }

        if (pass.trim() === '') {
            setPassError('Password is required.');
            hasError = true;
        }

        if (!hasError) {
            console.log('Login successful!');

        }
    }

    return (
        <>
        <Navbar/>
        <div className="auth-form-container">
            <h2>Login</h2>
            <form className="login-form" onSubmit={handleSubmit}>
                <label htmlFor="email">Email</label>
                <input value={email} onChange={(e) => setEmail(e.target.value)} type="email" placeholder="youremail@gmail.com" id="email" name="email" />
                {emailError && <div className="error">{emailError}</div>}

                <label htmlFor="password">Password</label>
                <input value={pass} onChange={(e) => setPass(e.target.value)} type="password" placeholder="**" id="password" name="password" />
                {passError && <div className="error">{passError}</div>}

                <button className="rcb" onClick={handleLogin} type="submit">LogIn</button>
            </form>
            <button className="link-btn" onClick={() => props.onFormSwitch('register')}>Don't have an account? Register here.</button>
            </div>
        </>
    )
}

export default Login