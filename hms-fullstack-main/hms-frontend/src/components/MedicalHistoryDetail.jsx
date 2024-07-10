import React, { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import { getMedicalHistoryDetailByPatientId } from '../services/PatientService';
import backgroundImage from "../assets/images/mback.jpg";

const MedicalHistoryDetail = () => {
  const [currentMedicalHistory, setCurrentMedicalHistory] = useState([]);
  const [pastMedicalHistory, setPastMedicalHistory] = useState([]);
  const { id, diseaseId } = useParams();

  useEffect(() => {
    if (id && diseaseId) {
      getMedicalHistoryDetailByPatientId(id, diseaseId).then((response) => {
        const records = response.data;
        setCurrentMedicalHistory(records.filter(record => record.isActive));
        setPastMedicalHistory(records.filter(record => !record.isActive));
      }).catch(error => {
        console.error(error);
      });
    }
  }, [id, diseaseId]);

  if (currentMedicalHistory.length === 0 && pastMedicalHistory.length === 0) {
    return <div>Loading...</div>;
  }

  const renderMedicalRecord = (record) => {
    return record.diseaseId == 102 ? (
      <>
        <h4 className='text-success'>Hypertension Record</h4>
        <p>Systolic: {record.systolic} mmHg</p>
        <p>Diastolic: {record.diastolic} mmHg</p>
      </>
    ) : (
      <>
        <h4 className='text-success'>Diabetes Record</h4>
        <p>FBG: {record.fbg} mg/dL</p>
        <p>PPBG: {record.ppbg} mg/dL</p>
        <p>RBG: {record.rbg} mg/dL</p>
      </>
    );
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
      <h2 className='text-center text-success fw-bold'>Medical History Detail</h2>
      <div className="row mt-5">
        <div className="col-md-6">
          <h3 className='text-center'>Current Records</h3>
          {currentMedicalHistory.length > 0 ? (
            currentMedicalHistory.map(record => (
              <div key={record.id} className="card mb-3 " style={{ backgroundColor: 'rgba(255, 255, 255, 0.4)' }}>
                <div className="card-body" style={{ backgroundColor: 'rgba(255, 255, 255, 0.4)' }}>
                  {renderMedicalRecord(record)}
                  <p>Updated Date: {new Date(record.updatedDate).toLocaleDateString()}</p>
                </div>
              </div>
            ))
          ) : (
            <p>No current medical records found.</p>
          )}
        </div>
        <div className="col-md-6">
          <h3 className='text-center'>Past Records</h3>
          {pastMedicalHistory.length > 0 ? (
            pastMedicalHistory.map(record => (
              <div key={record.id} className="card mb-3" style={{ backgroundColor: 'rgba(255, 255, 255, 0.4)' }}>
                <div className="card-body" style={{ backgroundColor: 'rgba(255, 255, 255, 0.6)' }}>
                  {renderMedicalRecord(record)}
                  <p>Updated Date: {new Date(record.updatedDate).toLocaleDateString()}</p>
                </div>
              </div>
            ))
          ) : (
            <p className='fw-bold'>No past medical records found.</p>
          )}
        </div>
      </div>
    </div>
  );
};

export default MedicalHistoryDetail;
