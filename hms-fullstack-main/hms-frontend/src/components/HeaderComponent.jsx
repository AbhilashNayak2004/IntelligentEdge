import React from 'react';
import { Link } from 'react-router-dom';

const HeaderComponent = () => {
  return (
    <header>
      <nav className="navbar navbar-dark"  style={{ backgroundColor: '#34bdcc' }}>
        <a className="navbar-brand ms-2 fw-semibold" href="/home">Hospital Management System</a>
        <div>
          <Link className="btn btn-outline-light me-2 fw-semibold" to="/">Home</Link>
          <Link className="btn btn-outline-light me-2 fw-semibold" to="/patients">Patient Details</Link>
          <Link className="btn btn-outline-light me-2 fw-semibold" to="/hypertension-details">Hypertension Details</Link>
          <Link className="btn btn-outline-light me-2 fw-semibold" to="/diabetes-details">Diabetes Details</Link>
        </div>
      </nav>
    </header>
  );
}

export default HeaderComponent;

