import React, { useState } from 'react';
import { useNavigate, useParams } from 'react-router-dom';
import { addMedicalDetail } from '../services/PatientService';
import backgroundImage from "../assets/images/mback.jpg";

const AddMedicalDetail = () => {
  const { id, diseaseId } = useParams();
  const navigate = useNavigate();
  const [formData, setFormData] = useState({
    diseaseId: parseInt(diseaseId),
    fbg: '',
    ppbg: '',
    rbg: '',
    systolic: '',
    diastolic: '',
    isActive: true,
    patientId: parseInt(id),
    updatedDate: new Date().toISOString().slice(0, 10)
  });

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData(prevState => ({
      ...prevState,
      [name]: value
    }));
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    const dataToSend = { ...formData, updatedDate: formData.updatedDate };

    addMedicalDetail(dataToSend, diseaseId)
      .then(response => {
        navigate(`/patients/${id}/profile`);
      })
      .catch(error => {
        console.error(error);
      });
  };

  const handleCancel = () => {
    navigate(`/patients/${id}/profile`);
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
      <h2 className='text-center text-success fw-bold'>Add Medical Detail</h2>
      <form onSubmit={handleSubmit}>
        {diseaseId == 101 && (
          <>
            <div className="mb-3">
              <label htmlFor="fbg" className="form-label fw-bold">FBG</label>
              <input type="number" className="form-control" id="fbg" name="fbg" value={formData.fbg} onChange={handleChange} required />
            </div>
            <div className="mb-3">
              <label htmlFor="ppbg" className="form-label fw-bold">PPBG</label>
              <input type="number" className="form-control" id="ppbg" name="ppbg" value={formData.ppbg} onChange={handleChange} required />
            </div>
            <div className="mb-3">
              <label htmlFor="rbg" className="form-label fw-bold">RBG</label>
              <input type="number" className="form-control" id="rbg" name="rbg" value={formData.rbg} onChange={handleChange} required />
            </div>
          </>
        )}
        {diseaseId == 102 && (
          <>
            <div className="mb-3">
              <label htmlFor="systolic" className="form-label fw-bold">Systolic</label>
              <input type="number" className="form-control" id="systolic" name="systolic" value={formData.systolic} onChange={handleChange} required />
            </div>
            <div className="mb-3">
              <label htmlFor="diastolic" className="form-label fw-bold">Diastolic</label>
              <input type="number" className="form-control" id="diastolic" name="diastolic" value={formData.diastolic} onChange={handleChange} required />
            </div>
          </>
        )}
        <button type="submit" className="btn btn-outline-success fw-bold">Submit</button>
        <button type="submit" className="mx-3 btn btn-outline-warning btn-long fw-bold" onClick={handleCancel}>Cancel</button>
      </form>
    </div>
  );
};

export default AddMedicalDetail;
