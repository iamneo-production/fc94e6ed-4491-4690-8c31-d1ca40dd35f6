import React, { useEffect, useState } from 'react'
//import AdminNavbar from './AdminNavbar';
//import { Link } from "react-router-dom";
import Sidebar from './Sidebar';

import { endpoint } from '../config';

const ViewUsers = () => {
    const [userData, setUserdata] = useState([]); 
    const [dataCounts, setDataCounts] = useState({
        totalRegisteredUsers: 0,
        totalSuccessfulPayments: 0,
        totalCancellations: 0,
    });
    useEffect( ()=>{
        const getUserdata= async()=>{
            const reqData= await fetch(`${endpoint.url}/api/v1/customers/`);
            const resData= await reqData.json();
            setUserdata(resData);
           // console.log(resData);
        }
        getUserdata();
    }, []);
    
    const count = userData.length;
    return (
        <>
            <div style={{ display: 'flex' }}>
                <Sidebar/>
                
    <React.Fragment>
                    <div className="container" style={{ backgroundColor: "aliceblue" }}>
                    <h1 className="text-center pt-5 pb-5" style={{ color: "white", backgroundColor: "lightslategrey" }}>Admin Dashboard</h1>     
                <div className="row">
                    <div className="col-md-12">
                    <h2 className="mt-5">Customer Data</h2>
                      <h5 className='mt-3 mb-3'>Number of Records: {count}</h5>
                       <table className="table table-bordered table-striped">
                        <thead>
                        <tr>
                        <th>Customer Id</th>
                        <th>Name</th>
                        <th>Email</th>
                        <th>Phone No</th>
                        
                        </tr>
                        </thead>
                        <tbody>
                         { userData.map( (userData, userId)=>(                           
                        <tr key={userId}>
                        <td>{userData.customerId} </td>
                        <td>{ userData.name } </td>
                        <td>{ userData.email } </td>
                        <td>{ userData.phone } </td>
                        
                        
                        {/*<td>
                         <Link to={"/editUser/"+userData.userId} className="btn btn-success mx-2">Edit</Link>
                         <Link to="/deleteUser" className="btn btn-danger">Delete</Link>
                         </td>*/}
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

export default ViewUsers