import React, { useState } from "react";

import Login from "./Login"; // Update the import path for Login
import Register from "./Register";
import './LoginReg.css';

function Control() {
    const [currentForm, setCurrentForm] = useState('login');

    const toggleForm = (formName) => {
        setCurrentForm(formName);
    }

    return (
        <div className="getIn">
            {
                currentForm === "login" ? <Login onFormSwitch={toggleForm} /> : <Register onFormSwitch={toggleForm} />
            }
        </div>
    );
}

export default Control;