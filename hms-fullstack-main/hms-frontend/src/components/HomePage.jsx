import React from 'react';
import '../componentsCSS/HomePage.css';

const HomePage = () => {
  return (
    <div className="homepage-container">
      <div className="overlay">
        <div className="container mt-3">
          <div className="row">
            <div className="col-md-12 text-center text-white">
              <h1 className='fw-bold'>Welcome to the Hospital Management System</h1>
              <p className="lead fw-semibold">Ensuring the best care for our patients.</p>
            </div>
          </div>
          <div className="row mt-4">
            <div className="col-md-6">
              <blockquote className="blockquote text-white">
                <p className="mb-0 fw-semibold">"To keep the body in good health is a duty... otherwise we shall not be able to keep our mind strong and clear."</p>
                <footer className="blockquote-footer mt-2 text-white">Buddha</footer>
              </blockquote>
            </div>
            <div className="col-md-6">
              <blockquote className="blockquote text-white">
                <p className="mb-0 fw-semibold">"The best way to find yourself is to lose yourself in the service of others."</p>
                <footer className="blockquote-footer mt-2 text-white">Mahatma Gandhi</footer>
              </blockquote>
            </div>
          </div>
          <div className="row mt-4">
            <div className="col-md-6">
              <blockquote className="blockquote text-white">
                <p className="mb-0 fw-semibold">"Health is a state of complete harmony of the body, mind, and spirit."</p>
                <footer className="blockquote-footer mt-2 text-white">B.K.S. Iyengar</footer>
              </blockquote>
            </div>
            <div className="col-md-6">
              <blockquote className="blockquote text-white">
                <p className="mb-0 fw-semibold">"The greatest wealth is health."</p>
                <footer className="blockquote-footer mt-2 text-white">Virgil</footer>
              </blockquote>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}

export default HomePage;
