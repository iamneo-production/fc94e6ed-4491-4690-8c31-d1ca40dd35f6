import React from 'react';
// import Sidebar from './Sidebar';
import { Link } from 'react-router-dom';

const Dashboard = () => {
    

    return (
        <>
            <div style={{ display: 'flex' }}>
                
                <div className="container-fluid" style={{ backgroundColor: "aliceblue" }}>
                    {/* Admin Dashboard Heading */}
                    <h1 className="text-center pt-5 pb-5" style={{ color: "white", backgroundColor: "lightslategrey" }}>Admin Dashboard</h1>

                    {/* Centering Container */}
                    <div className="text-center" style={{ paddingTop: "50px" }}>

                        {/* Registered Users Card */}
                        <div className="col-md-4 mb-4 offset-md-4">
                            <div className="card bg-info">
                                <div className="card-body">
                                    <h5 className="card-title">Registered Users</h5>
                                    
                                    <Link to="/admin/view-users"><button className="btn btn-primary">View details</button></Link>
                                </div>
                            </div>
                        </div>

                        {/* Successful Bookings Card */}
                        <div className="col-md-4 mb-4 offset-md-4">
                            <div className="card bg-success">
                                <div className="card-body">
                                    <h5 className="card-title">Successful Bookings</h5>
                                    
                                    <Link to="/admin/manage-payments"><button className="btn btn-primary">View details</button></Link>
                                </div>
                            </div>
                        </div>

                        {/* Cancelled Bookings Card */}
                        <div className="col-md-4 mb-4 offset-md-4">
                            <div className="card bg-danger">
                                <div className="card-body">
                                    <h5 className="card-title">Cancelled Bookings</h5>
                                    
                                    <Link to="/admin/cancellations"><button className="btn btn-primary">View details</button></Link>
                                </div>
                            </div>
                        </div>

                    </div>

                </div>
            </div>
        </>
    );
};

export default Dashboard;