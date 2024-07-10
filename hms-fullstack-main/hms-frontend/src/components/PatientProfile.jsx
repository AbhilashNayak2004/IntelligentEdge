import React, { useEffect, useState } from "react";
import { useParams, useNavigate} from "react-router-dom";
import {
  getPatient, getMedicalHistoryByPatientIdAndIsActive
} from "../services/PatientService";
import maleProfile from "../assets/images/male-profile.jpg";
import femaleProfile from "../assets/images/female-profile.jpg";
import otherProfile from "../assets/images/other-profile.jpg";
import backgroundImage from "../assets/images/mback.jpg";

const PatientProfile = () => {
  const [patient, setPatient] = useState(null);
  const [medicalHistory, setMedicalHistory] = useState([]);
  const { id } = useParams();
  const navigate = useNavigate();

  useEffect(() => {
    if (id) {
      getPatient(id)
        .then((response) => {
          setPatient(response.data);
        })
        .catch((error) => {
          console.error(error);
        });

        getMedicalHistoryByPatientIdAndIsActive(id, true).then((response) => {
          setMedicalHistory(response.data);
        })
        .catch((error) => {
          console.error(error);
        });
    }
  }, [id]);

  if (!patient) {
    return <div>Loading...</div>;
  }

  const getProfileImage = (gender) => {
    switch (gender) {
      case "M":
        return maleProfile;
      case "F":
        return femaleProfile;
      case "Other":
        return otherProfile;
      default:
        return otherProfile;
    }
  };

  
 
  const diabetesDetails = medicalHistory.filter(
    (record) => record.diseaseId === 101
  );

  const hypertensionDetails = medicalHistory.filter(
    (record) => record.diseaseId === 102
  );

  const navigateToDetail = (diseaseId, action) => {
    if (action === 'add') {
      navigate(`/patients/${id}/addmedicaldetail/${diseaseId}`);
    } else {
      navigate(`/patients/${id}/medicalhistory/${diseaseId}`);
    }
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
      <div className="row">
        <div className="col-md-5">
          <div className="card" style={{ backgroundColor: 'rgba(255, 255, 255, 0.6)' }}>
            <div className="card-body" style={{ backgroundColor: 'rgba(255, 255, 255, 0.6)' }}>
              <div className="d-flex flex-column align-items-center">
                <img
                  src={getProfileImage(patient.gender)}
                  alt="Profile"
                  className="img-fluid rounded-circle mb-3"
                  style={{ width: '150px', height: '150px' }}
                />
                <h2>{patient.firstName} {patient.lastName}</h2>
              </div>
            </div>
            <div className="card mt-3 mb-2 col-md-10 offset-md-1">
              <div className="card-body">
                <p>Gender: {patient.gender}</p>
                <p>Birth Date: {new Date(patient.birthDate).toLocaleDateString()}</p>
                <p>Age: {patient.age}</p>
                <p>Blood Group: {patient.bloodGroup}</p>
                <p>Address: {patient.address}</p>
                <p>Phone: {patient.phone}</p>
                <p>Email: {patient.email}</p>
                <p>Height: {patient.height} cm</p>
                <p>Weight: {patient.weight} kg</p>
                <p>Medical Reason: {patient.medicalReason}</p>
              </div>
            </div>
          </div>
        </div>
        <div className="col-md-5 offset-md-2">
          <div className="card mb-3" style={{ backgroundColor: 'rgba(255, 255, 255, 0.6)' }}>
            <div className="card-body">
            <div className="row align-items-center">
                <div className="col-md-6">
                  <h3>Hypertension Details</h3>
                </div>
                <div className="col-md-6 md-2 text-end">
                <button className="btn btn-outline-primary btn-long px-1" onClick={() => navigateToDetail(102, 'add')}>Add</button>
                  <button className="btn btn-outline-warning btn-long px-1 ms-2" onClick={() => navigateToDetail(102)}>Detail</button>
                </div>
              </div>
              {hypertensionDetails.length > 0 ? (
                hypertensionDetails.map(record => (
                  <div key={record.id}>
                    <p>Systolic: {record.systolic} mmHg</p>
                    <p>Diastolic: {record.diastolic} mmHg</p>
                    <p>Updated Date: {record.updatedDate}</p>
                  </div>
                ))
              ) : (
                <p>No hypertension records found.</p>
              )}
            </div>
          </div>
          <div className="card" style={{ backgroundColor: 'rgba(255, 255, 255, 0.6)' }}>
            <div className="card-body">
            <div className="row align-items-center">
                <div className="col-md-6">
                  <h3>Diabetes Details</h3>
                </div>
                <div className="col-md-6 text-end">
                  <button className="btn btn-outline-primary btn-long px-1" onClick={() => navigateToDetail(101, 'add')}>Add</button>
                  <button className="btn btn-outline-warning btn-long px-1 ms-2" onClick={() => navigateToDetail(101)}>Detail</button>
                </div>
              </div>
              {diabetesDetails.length > 0 ? (
                diabetesDetails.map(record => (
                  <div key={record.id}>
                    <p>FBG: {record.fbg} mg/dL</p>
                    <p>PPBG: {record.ppbg} mg/dL</p>
                    <p>RBG: {record.rbg} mg/dL</p>
                    <p>Updated Date: {record.updatedDate}</p>
                  </div>
                ))
              ) : (
                <p>No diabetes records found.</p>
              )}
            </div>
          </div>
        </div>
      </div>
    </div>

  );
};

export default PatientProfile;
