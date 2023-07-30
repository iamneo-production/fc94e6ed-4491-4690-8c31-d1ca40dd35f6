import React from 'react';
import { Link } from 'react-router-dom';

const Sidebar = () => {
    return (
        <div id="sidebar-wrapper" style={{ backgroundColor: "lightslategrey" , height:"100vh"}}>
            <div className="sidebar-heading text-center py-4 primary-text fs-2 fw-bold text-uppercase border-bottom" style={{ color: "white" }}>
                <i className="fas fa-user-secret me-2"></i>Admin Panel
            </div>
            <div className="list-group list-group-flush my-3">
                <Link to="/admin/dashboard" className="list-group-item list-group-item-action bg-transparent second-text fw-bold" style={{ color: "white" }}>
                    <i class="fa fa-asterisk me-2" aria-hidden="true"></i>Dashboard
                </Link>
                {/*<Link className="list-group-item list-group-item-action bg-transparent second-text fw-bold" style={{ color: "white" }}>
                    <i className="fas fa-chart-line me-2"></i>Analytics
                </Link>
                <Link className="list-group-item list-group-item-action bg-transparent second-text fw-bold" style={{ color: "white" }}>
                    <i className="fas fa-paperclip me-2"></i>Reports
                </Link>*/}
                <Link to="/admin/view-users" className="list-group-item list-group-item-action bg-transparent second-text fw-bold" style={{ color: "white" }}>
                    <i className="fa fa-users me-2" aria-hidden="true"></i>View Users
                </Link>
                <Link to="/admin/manage-rooms" className="list-group-item list-group-item-action bg-transparent second-text fw-bold" style={{ color: "white" }}>
                    <i className="fa fa-building me-2" aria-hidden="true"></i>Manage Rooms
                </Link>
                <Link to="/admin/manage-bookings"className="list-group-item list-group-item-action bg-transparent second-text fw-bold" style={{ color: "white" }}>
                    <i className="fa fa-bed me-2" aria-hidden="true"></i>Manage Bookings
                </Link>
                <Link to="/admin/manage-payments" className="list-group-item list-group-item-action bg-transparent second-text fw-bold" style={{ color: "white" }}>
                    <i className="fa fa-info me-2" aria-hidden="true"></i>Manage Payments
                </Link>
                <Link to="/admin/cancellations" className="list-group-item list-group-item-action bg-transparent second-text fw-bold" style={{ color: "white" }}>
                    <i class="fa fa-times-circle me-2" aria-hidden="true"></i>Cancellations
                </Link>
                <Link to="/"className="list-group-item list-group-item-action bg-transparent  fw-bold" style={{ color: "black" }}>
                    <i className="fas fa-power-off me-2"></i>Logout
                </Link>
            </div>
        </div>
    );
};

export default Sidebar;