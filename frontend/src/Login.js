
import React, { useState } from "react";
//import './LoginReg.css';
import { useNavigate } from "react-router-dom";
//import { withRouter } from "react-router-dom";
import Navbar from "./Navbar";



function Login(props) {

    const [email, setEmail] = useState('')
    const [password, setPassword] = useState('')
    const navigate = useNavigate();
    
    const user = {
        email,
        password
    }

    
    

    const handleLogin = () => {
        if (email === "admin@gmail.com" && password === "admin") {
            console.log("Login successful! Redirecting to admin page...");
            navigate("/admin/admin-home");
            // Redirect to the admin page
            
        } else {
            //set the user name on the navbar
            //and navigate to rooms page

        }    
    };

    return (
        <>
            <Navbar/>
        <div className="row-justify-content-center align-items-center mt-5 center-content">
            <div className="col-md-5 login-container">
                <div>
                    <h2>Login</h2>
                    
                    <input type="text" className="form-control" placeholder="email" value={email}
                        onChange={(e) => { setEmail(e.target.value) }} />

                    <input type="text" className="form-control" placeholder="password" value={password}
                        onChange={(e) => { setPassword(e.target.value) }} />

                    <button className="btn-btn-primary login-button" style={{ padding: "3px 5px" }} onClick={handleLogin}>Login</button>
                    <button className="link-btn" onClick={() => props.onFormSwitch('register')}>Don't have an account? Register here.</button>
                </div>

            </div>
            </div>
        </>
    )


}

export default Login 