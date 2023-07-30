import React, { useEffect, useState } from 'react';
import axios from 'axios';
//import AdminNavbar from './AdminNavbar';
import Sidebar from './Sidebar';
import { endpoint } from '../config';

const Cancellations = () => {

    const [cacellationData, setCancellationData] = useState([]);
    const [filterData, setFilterData] = useState([]);
    const [query, setQuery] = useState([]);
    //const [cancellations, setCancellations] = useState([]);

    useEffect(() => {
        const getCancellationdata = async () => {
            const reqData = await fetch(`${endpoint.url}/api/v1/cancellations`);
            console.log(reqData);
            const resData = await reqData.json();
            //console.log(resData);
            setCancellationData(resData);
            setFilterData(resData);
        }
        getCancellationdata();
    }, []);

    const handleSearch = (event) => {
        const getSearch = event.target.value.trim().toLowerCase();
        //console.log(getSearch);
        if (getSearch.length > 0) {
            const searchdata = filterData.filter((item) =>
                item.cancellationId.toString().includes(getSearch) ||
                item.booking.id.toString().includes(getSearch) ||
                item.booking.customer.customerId === parseInt(getSearch) ||
                item.dateCancelled.toString().includes(getSearch) 
            );
            setCancellationData(searchdata);
        }
        else {
            setCancellationData(filterData);
        }

        setQuery(getSearch);

    }

   /* const deletePayment = async (paymentId) => {
        try {
            await axios.delete(`http://localhost:8282/api/${paymentId}`);
            setPaymentdata(paymentData.filter((payment) => payment.paymentId !== paymentId));
            setPayments(payments.filter((payment) => payment.paymentId !== paymentId));
        } catch (error) {
            console.error('Error deleting booking:', error);
        }
    };*/

    const count = cacellationData.length;

    return (
        <>
            <div style={{ display: 'flex' }}>
                
            <React.Fragment>
                <Sidebar/>
                    <div className="container" style={{ backgroundColor: "aliceblue" }}>
                    <h1 className="text-center pt-5 pb-5" style={{ color: "white", backgroundColor: "lightslategrey" }}>Admin Dashboard</h1>
                    <div className="row">
                        <div className="col-md-12">
                            <h2 className="mt-5">All Cancellations</h2>
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
                                        <th>Cancellation Id</th>
                                        <th>Booking Id</th>
                                        <th>Customer Id</th>
                                        <th>Cancelled Date</th>
                                        <th>Reason</th>
                                        <th>Amount Paid</th>
                                        

                                    </tr>
                                </thead>
                                <tbody>
                                    {cacellationData.map((cancellation, cancellationId) => (

                                        <tr key={cancellationId}>
                                            <td>{cancellation.cancellationId}</td>
                                            <td>{cancellation.booking.id}</td>
                                            <td>{cancellation.booking.customer.customerId}</td>
                                            <td>{cancellation.dateCancelled}</td>
                                            <td>{cancellation.reason}</td>
                                            <td>{cancellation.booking.room.pricePerNight}</td>

                                            
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

export default Cancellations;