import React, { useEffect, useState } from 'react';
import { useNavigate, useParams } from 'react-router-dom';
import { createPatient, getPatient, updatePatient } from '../services/PatientService';
import backgroundImage from "../assets/images/mback.jpg";

const PatientComponent = () => {
  const [patient, setPatient] = useState({
    firstName: '',
    lastName: '',
    gender: '',
    birthDate: '',
    age: '',
    bloodGroup: '',
    address: '',
    phone: '',
    email: '',
    height: '',
    weight: '',
    medicalReason: ''
  });

  const [errors, setErrors] = useState({});
  
  const { id } = useParams();
  const navigate = useNavigate();

  useEffect(() => {
    if (id) {
      getPatient(id).then((response) => {
        setPatient(response.data);
      }).catch(error => {
        console.error(error);
      });
    }
  }, [id]);

  useEffect(() => {
    if (patient.birthDate) {
      const birthDate = new Date(patient.birthDate);
      const today = new Date();
      let age = today.getFullYear() - birthDate.getFullYear();
      const monthDifference = today.getMonth() - birthDate.getMonth();
      if (monthDifference < 0 || (monthDifference === 0 && today.getDate() < birthDate.getDate())) {
        age--;
      }
      setPatient((prevState) => ({ ...prevState, age }));
    }
  }, [patient.birthDate]);

  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setPatient(prevState => ({
      ...prevState,
      [name]: value
    }));
  }; 

  const validateForm = () => {
    let valid = true;
    const errorsCopy = {};
    const nameRegex = /^[A-Za-z]+$/;
    const phoneRegex = /^\d{10}$/;

    Object.keys(patient).forEach((key) => {
      let value = patient[key] ? patient[key].toString() : ''; 
      if (key === 'firstName' || key === 'lastName') {
        if (!nameRegex.test(value.trim())) {
          errorsCopy[key] = `${key.charAt(0).toUpperCase() + key.slice(1)} should contain only alphabets`;
          valid = false;
        } else {
          errorsCopy[key] = '';
        }
      } else if (key === 'phone') {
        if (!phoneRegex.test(value.trim())) {
          errorsCopy[key] = 'Phone should contain exactly 10 digits';
          valid = false;
        } else {
          errorsCopy[key] = '';
        }
      } else if (key === 'height' || key === 'weight') {
        if (value.trim() && (isNaN(value) || parseFloat(value) <= 0)) {
          errorsCopy[key] = `${key.charAt(0).toUpperCase() + key.slice(1)} must be a positive number`;
          valid = false;
        } else {
          errorsCopy[key] = '';
        }
      }
      else if (value.trim()) {
        errorsCopy[key] = '';
      } else {
        errorsCopy[key] = `${key.charAt(0).toUpperCase() + key.slice(1)} is required`;
        valid = false;
      }
    });
    setErrors(errorsCopy);
    return valid;
  };

  const saveOrUpdatePatient = (e) => {
    e.preventDefault();
    if (validateForm()) {
      if (id) {
        updatePatient(id, patient).then(() => {
          navigate('/patients');
        }).catch(error => {
          console.error(error);
        });
      } else {
        createPatient(patient).then(() => {
          navigate('/patients');
        }).catch(error => {
          console.error(error);
        });
      }
    }
  };

  const pageTitle = () => (
    <h2 className='text-center'>{id ? 'Update Patient' : 'New Patient Form'}</h2>
  );

  const handleCancel = () => {
    navigate('/patients');
  };

  

  return (
    <div 
    className="container mt-5 mb-5"
      style={{
        backgroundImage: `url(${backgroundImage})`,
        backgroundSize: 'cover',
        backgroundPosition: 'center',
        padding: '20px',
        borderRadius: '10px',
        boxShadow: '0 4px 8px rgba(0, 0, 0, 0.1)'
      }}
      >
      <br />
      <div className="row">
        <div className="card col-md-6 offset-md-3 mb-3"  style={{ backgroundColor: 'rgba(255, 255, 255, 0.6)' }}>
          {pageTitle()}
          <div className="card-body form-container">
            <form onSubmit={saveOrUpdatePatient}>
              <div className="form-group mb-2">
                <label className="form-label fw-semibold">First Name</label>
                <input
                  type="text"
                  placeholder="Enter Patient First Name"
                  name="firstName"
                  value={patient.firstName}
                  className={`form-control ${errors.firstName ? 'is-invalid' : ''}`}
                  onChange={handleInputChange}
                />
                {errors.firstName && <div className="invalid-feedback">{errors.firstName}</div>}
              </div>
              <div className="form-group mb-2">
                <label className="form-label fw-semibold">Last Name</label>
                <input
                  type="text"
                  placeholder="Enter Patient Last Name"
                  name="lastName"
                  value={patient.lastName}
                  className={`form-control ${errors.lastName ? 'is-invalid' : ''}`}
                  onChange={handleInputChange}
                />
                {errors.lastName && <div className="invalid-feedback">{errors.lastName}</div>}
              </div>
              <div className="form-group mb-2">
                <label className="form-label fw-semibold">Gender</label>
                <select
                  name="gender"
                  value={patient.gender}
                  className={`form-control ${errors.gender ? 'is-invalid' : ''}`}
                  onChange={handleInputChange}
                >
                  <option value="">Select Gender</option>
                  <option value="M">Male</option>
                  <option value="F">Female</option>
                  <option value="Other">Other</option>
                </select>
                {errors.gender && <div className="invalid-feedback">{errors.gender}</div>}
              </div>
              <div className="form-group mb-2">
                <label className="form-label fw-semibold">Birth Date</label>
                <input
                  type="date"
                  name="birthDate"
                  value={patient.birthDate}
                  className={`form-control ${errors.birthDate ? 'is-invalid' : ''}`}
                  onChange={handleInputChange}
                />
                {errors.birthDate && <div className="invalid-feedback">{errors.birthDate}</div>}
              </div>
              <div className="form-group mb-2">
                <label className="form-label fw-semibold">Age</label>
                <input
                  type="number"
                  name="age"
                  value={patient.age}
                  className={`form-control ${errors.age ? 'is-invalid' : ''}`}
                  readOnly
                />
                {errors.age && <div className="invalid-feedback">{errors.age}</div>}
              </div>
              <div className="form-group mb-2">
                <label className="form-label fw-semibold">Blood Group</label>
                <select
                  name="bloodGroup"
                  value={patient.bloodGroup}
                  className={`form-control ${errors.bloodGroup ? 'is-invalid' : ''}`}
                  onChange={handleInputChange}
                >
                  <option value="">Select Blood Group</option>
                  <option value="A+">A+</option>
                  <option value="A-">A-</option>
                  <option value="B+">B+</option>
                  <option value="B-">B-</option>
                  <option value="AB+">AB+</option>
                  <option value="AB-">AB-</option>
                  <option value="O+">O+</option>
                  <option value="O-">O-</option>
                </select>
                {errors.bloodGroup && <div className="invalid-feedback">{errors.bloodGroup}</div>}
              </div>
              <div className="form-group mb-2">
                <label className="form-label fw-semibold">Address</label>
                <input
                  type="text"
                  placeholder="Enter Patient Address"
                  name="address"
                  value={patient.address}
                  className={`form-control ${errors.address ? 'is-invalid' : ''}`}
                  onChange={handleInputChange}
                />
                {errors.address && <div className="invalid-feedback">{errors.address}</div>}
              </div>
              <div className="form-group mb-2">
                <label className="form-label fw-semibold">Phone</label>
                <input
                  type="text"
                  placeholder="Enter Patient Phone"
                  name="phone"
                  value={patient.phone}
                  className={`form-control ${errors.phone ? 'is-invalid' : ''}`}
                  onChange={handleInputChange}
                />
                {errors.phone && <div className="invalid-feedback">{errors.phone}</div>}
              </div>
              <div className="form-group mb-2">
                <label className="form-label fw-semibold">Email</label>
                <input
                  type="email"
                  placeholder="Enter Patient Email"
                  name="email"
                  value={patient.email}
                  className={`form-control ${errors.email ? 'is-invalid' : ''}`}
                  onChange={handleInputChange}
                />
                {errors.email && <div className="invalid-feedback">{errors.email}</div>}
              </div>
              <div className="form-group mb-2">
                <label className="form-label fw-semibold">Height (cm)</label>
                <input
                  type="number"
                  placeholder="Enter Patient Height"
                  name="height"
                  value={patient.height}
                  className={`form-control ${errors.height ? 'is-invalid' : ''}`}
                  onChange={handleInputChange}
                />
                {errors.height && <div className="invalid-feedback">{errors.height}</div>}
              </div>
              <div className="form-group mb-2">
                <label className="form-label fw-semibold">Weight (kg)</label>
                <input
                  type="number"
                  placeholder="Enter Patient Weight"
                  name="weight"
                  value={patient.weight}
                  className={`form-control ${errors.weight ? 'is-invalid' : ''}`}
                  onChange={handleInputChange}
                />
                {errors.weight && <div className="invalid-feedback">{errors.weight}</div>}
              </div>
              <div className="form-group mb-2">
                <label className="form-label fw-semibold">Medical Reason</label>
                <select
                  type="text"
                  placeholder="Enter Medical Reason"
                  name="medicalReason"
                  value={patient.medicalReason}
                  className={`form-control ${errors.medicalReason ? 'is-invalid' : ''}`}
                  onChange={handleInputChange}
                >
                <option value="">Select Medical Reason</option>
                  <option value="Hypertension">Hypertension</option>
                  <option value="Diabetes">Diabetes</option>
                  <option value="Hypertension & Diabetes">Hypertension & Diabetes</option>
                </select>
                {errors.medicalReason && <div className="invalid-feedback">{errors.medicalReason}</div>}
              </div>
              <button type="submit" className="btn btn-outline-success btn-long fw-bold">Submit</button>
              <button type="submit" className="mx-3 btn btn-outline-warning btn-long fw-bold" onClick={handleCancel}>Cancel</button>
            </form>
            
          </div>
        </div>
      </div>
    </div>
  );
};

export default PatientComponent;
