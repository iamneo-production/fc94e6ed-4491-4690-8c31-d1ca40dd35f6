import axios from 'axios';
import React from 'react';
import { Form, Button } from 'semantic-ui-react';
import { useForm } from "react-hook-form";
import "./Profile.css";

export default function FormValidation() {
    const { register, handleSubmit, formState: { errors } } = useForm();
    
 /*const onSubmit = (e) => {
    const result=axios.post("http://localhost:8080/customer/add",e)
    console.log(result);
        console.log("new customer added");
        console.log(e);
    } */
    
    
  
    return (
        /*<div  style={{ 
            backgroundImage: `url(${process.env.PUBLIC_URL + '/bg.jpg'})`,
            backgroundRepeat: 'repeat',
            width:'100%' ,
            height: '100%'
          }}>*/

    
        <div className="form_class">
            <Form >
                <div className="bar">
                    <h3>PROFILE</h3>
                </div>
                <div className="form_body">
                    <Form.Field className="userfield">
                        <label className="form__label" for="firstName"> First Name </label>

                        <input
                            placeholder='First Name'
                            type="text"
                            className="form_input"
                            {...register("firstname", { required: true,
                                pattern:  /^[\w'\-,.][^0-9_!¡?÷?¿/\\+=@#$%ˆ&*(){}|~<>;:[\]]{2,}$/,
                                 maxLength: 20})}
                        />

                    </Form.Field>
                    {errors.firstName && <p className='err-tag'>Please check the First Name</p>}
                    <Form.Field className="userfield">
                        <label className="form__label" for="lastName"> Last Name </label>
                        <input
                            placeholder='Last Name'
                            type="text"
                            className="form_input"
                            {...register("lastname", { required: true, 
                                pattern:  /^[\w'\-,.][^0-9_!¡?÷?¿/\\+=@#$%ˆ&*(){}|~<>;:[\]]{2,}$/,
                                maxLength: 20 })}
                        />
                    </Form.Field>
                    {errors.lastName && <p className='err-tag'>Please check the Last Name</p>}
                    <Form.Field className="userfield">
                        <label className="form__label" for="email"> Email </label>
                        <input
                            placeholder='Email'
                            type="email"
                            className="form_input"
                            {...register("email",
                                {
                                    required: true,
                                    pattern: /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/
                                })}
                        />
                       
                    </Form.Field>
                    {errors.email && <p className='err-tag'>Please check the Email</p>}
                    <Form.Field className="userfield">
                        <label className="form__label" for="age"> Age </label>
                        <input
                            placeholder='Age'
                            type="text"
                            className="form_input"
                            {...register("age", {
                                required: true,
                                maxLength: 2,
                                pattern: /^(0?[1-9]|[1-9][0-9]|[1][1-9][1-9]|200)$/
                            })}
                        />

                    </Form.Field>
                    {errors.age && <p className='err-tag'>Please Check the Age</p>}
                    <Form.Field className="userfield">
                        <label className="form__label" for="gender"> Gender </label>
                        <input
                            type="radio"
                            name="male"
                            value="male"
                            id="male"
                            className="form__input"
                            {...register("gender", )}

                        />
                        Male
                        <input
                            type="radio"
                            name="female"
                            value="female"
                            id="female"
                            className="form__input"
                            {...register("gender", {
                                //required: true,
                            })}
                        />
                        Female
                        <input
                            type="radio"
                            value="others"
                            name="others"
                            id="others"
                            className="form__input"
                            {...register("gender", {
                                //required: true,
                            })}
                        />
                        Others
                    </Form.Field>
                    {errors.gender && <p className='err-tag'>Please Check the Gender</p>}
                    <Form.Field className="userfield">
                        <label className="form__label" for="phone"> Phone number </label>
                        <input
                            placeholder='phone number'
                            type="text"
                            className="form_input"
                            {...register("phonenumber", {
                                required: true,
                                pattern: /(\+\d{1,3}\s?)?((\(\d{3}\)\s?)|(\d{3})(\s|-?))(\d{3}(\s|-?))(\d{4})(\s?(([E|e]xt[:|.|]?)|x|X)(\s?\d+))?/g
                            })}
                        />
                    </Form.Field>
                    {errors.phone && <p className='err-tag'>Please check the phone number</p>}
            
                    <div className="space_class">
                    <Button className='butn' type='submit'>Submit</Button>
                    </div>
                </div>
            </Form >
        </div>
        

    )
}