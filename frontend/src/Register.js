import React, { useState} from "react";
//import './LoginReg.css';
import axios from "axios";
//import { useNavigate } from "react-router-dom";
import Navbar from "./Navbar";
import { endpoint } from "./config";

function Register(props) {
    const [name, setName] = useState('')
    const [email, setEmail] = useState('')
    const [phone, setPhone] = useState('')

    //const navigate = useNavigate();

    const user = {
        name,
        email,
        phone
    }

    //console.log(user);

    const handleRegister = async (e) => {
        e.preventDefault();
        // Assuming you have the API endpoint URL
        //const apiUrl = "https://8080-effbafacedeffdcaedcdebafccffbfbfaeedd.project.examly.io/api/v1/customers";
        const apiUrl = `${endpoint.url}api/v1/customers`
        
        // Create an object with the data to be sent to the API
        const data = {
            name,
            email,
            phone
        };

        // Send a POST request to the API
        try {
            const response = await axios.post(apiUrl, data);
            console.log("Data posted successfully:", response.data);
            const customerId = response.data.customerId;
            console.log(customerId);
            localStorage.setItem("customerId", customerId);
            localStorage.setItem("name", name);
            //navigate(`/home`);
          } catch (error) {
            console.error("Error posting data:", error);
          }
        };

    
    return (
        <>
            <Navbar/>
        <div className="row-justify-content-center align-items-center mt-5 center-content">
            <div className="col-md-5 register-container">
                <div>
                    <h2>Register</h2>
                    <input type="text" className="form-control" placeholder="name" value={name}
                        onChange={(e) => { setName(e.target.value) }} />
                    
                    <input type="text" className="form-control" placeholder="email" value={email}
                        onChange={(e) => { setEmail(e.target.value) }} />
                    
                    <input type="text" className="form-control" placeholder="phone" value={phone}
                        onChange={(e) => { setPhone(e.target.value) }} />
                    
                    <button className="btn-btn-primary login-button" style={{ padding: "3px 5px" }} onClick={handleRegister}>Register</button>
                    <button className="link-btn register-button" onClick={() => props.onFormSwitch("login")}>
                        Already have an account? Login here.
                    </button>
                </div>

            </div>
            </div>
        </>
    )


}

export default Register;