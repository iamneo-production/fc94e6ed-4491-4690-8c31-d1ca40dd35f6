import React, { useRef } from 'react';
import emailjs from '@emailjs/browser';
import './ContactUs.css';
import Navbar from './Navbar';


export const ContactUs = () => {
const form = useRef();

const sendEmail = (e) => {
    e.preventDefault(); 
    emailjs.sendForm('service_l2fecgo', 'template_f0poqe7', form.current, 'HBJ7ldrCQ0NGFuja6')
      .then((result) => {
          console.log(result.text);
      }, (error) => {
          console.log(error.text);
      });
};
const diffToast=()=>{
    alert("Email sent");
}


    return (
        <>
            <Navbar/>
    <form ref={form} onSubmit={sendEmail}>
        <h1>Contact<span> Us</span></h1>
        <label>Name</label> 
        <input type="text" name="user_name"  placeholder='Enter name' required/>
        <label>Email</label>
        <input type="email" name="user_email" placeholder='abc@gmail.com' required/>
        <label>Message</label>
        <textarea name="message" cols="30" rows="10" placeholder='Type here' required></textarea> 
        <button type="submit" onClick={diffToast} >Send</button>
    </form>
    </>
  
  )
};
export default ContactUs