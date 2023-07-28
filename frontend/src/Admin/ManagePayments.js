import React, { useEffect, useState } from 'react';
import axios from 'axios';
//import AdminNavbar from './AdminNavbar';
import Sidebar from './Sidebar';
import { endpoint } from '../config';

const ManagePayments = () => {

    const [paymentData, setPaymentdata] = useState([]);
    const [filterData, setFilterData] = useState([]);
    const [query, setQuery] = useState([]);
    const [payments, setPayments] = useState([]);

    useEffect(() => {
        const getPaymentdata = async () => {
            const reqData = await fetch(`${endpoint.url}api/v1/bookings/payments`);
            console.log(reqData);
            const resData = await reqData.json();
            //console.log(resData);
            setPaymentdata(resData);
            setFilterData(resData);

        }
        getPaymentdata();
    }, []);

    const handleSearch = (event) => {
        const getSearch = event.target.value.trim().toLowerCase();
        //console.log(getSearch);
        if (getSearch.length > 0) {
            const searchdata = filterData.filter((item) =>
                item.paymentId.toString().includes(getSearch)||
                item.booking.customer.customerId === parseInt(getSearch) ||
                item.booking.id.toString().includes(getSearch) ||
                item.amount.toString().includes(getSearch) ||
                item.paymentDateTime.toString().includes(getSearch) 
            );
            setPaymentdata(searchdata);
        }
        else {
            setPaymentdata(filterData);
        }

        setQuery(getSearch);

    }

    const deletePayment = async (paymentId) => {
        try {
            await axios.delete(`${endpoint.url}api/${paymentId}`);
            setPaymentdata(paymentData.filter((payment) => payment.paymentId !== paymentId));
            setPayments(payments.filter((payment) => payment.paymentId !== paymentId));
        } catch (error) {
            console.error('Error deleting booking:', error);
        }
    };

    const count = paymentData.length;

    return (
        <>
            <div style={{ display: 'flex' }}>
                <Sidebar />
        <React.Fragment>
                    <div className="container" style={{ backgroundColor: "aliceblue" }}>
                        <h1 className="text-center pt-5 pb-5" style={{ color: "white", backgroundColor: "lightslategrey" }}>Admin Dashboard</h1>
                <div className="row">
                    <div className="col-md-12">
                        <h2 className="mt-5">All Payments</h2>
                        <div className='col-md-6 mt-3'>
                            <input type='text' name='name' value={query}
                                className='form-control' onChange={(e) => handleSearch(e)}
                                placeholder='search...'
                            />

                        </div>
                        <h5 className='mt-3'>Number of Records: {count}</h5>
                        <table className="table table-bordered table-striped mt-5">
                            <thead className="">
                                <tr>
                                    <th>Payment Id</th>
                                    <th>Customer Id</th>
                                    <th>Booking Id</th>
                                    <th>Total Amount</th>
                                    <th>Payment Date</th>
                                    <th>Status</th>
                                    

                                </tr>
                            </thead>
                            <tbody>
                                {paymentData.map((payment, paymentId) => (

                                    <tr key={paymentId}>
                                        <td>{ payment.paymentId}</td>
                                        <td>{payment.booking.customer.customerId}</td>
                                        <td>{payment.booking.id}</td>
                                        <td>{payment.amount}</td>
                                        <td>{payment.paymentDateTime}</td>
                                        <td>{payment.paymentStatus }</td>
                                        
                                        
                                    </tr>
                                ))
                                }
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>

                </React.Fragment>
        </div>
        </>
    )

    
}

export default ManagePayments;