import React, { useEffect, useState } from "react";
import { getActiveMedicalHistoryByDisease } from "../services/PatientService";
import maleProfile from "../assets/images/male-profile.jpg";
import femaleProfile from "../assets/images/female-profile.jpg";
import otherProfile from "../assets/images/other-profile.jpg";
import backgroundImage from "../assets/images/mback.jpg";

const HypertensionDetails = () => {
  const [hypertensionRecords, setHypertensionRecords] = useState([]);

  useEffect(() => {
    getActiveMedicalHistoryByDisease(102, true)
      .then((response) => {
        setHypertensionRecords(response.data);
      })
      .catch((error) => {
        console.error("Error fetching hypertension records:", error);
      });
  }, []);

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

  return (
    <div className="container mt-3 mb-3">
      <h1>Hypertension Details</h1>
      {hypertensionRecords.length > 0 ? (
        hypertensionRecords.map((record) => (
          <div
            key={record.id}
            className="card mb-3"
            style={{
              backgroundImage: `url(${backgroundImage})`,
              backgroundSize: "cover",
              backgroundPosition: "center",
              color: "white",
            }}
          >
            <div key={record.id} className="card mb-3 mt-3 col-md-10 offset-md-1">
              <div className="card-body">
                <div className="row">
                  <div className="col-md-4 text-center">
                    <img
                      src={getProfileImage(record.patient.gender)}
                      alt="Profile"
                      className="img-fluid rounded-circle mb-3"
                      style={{ width: "100px", height: "100px" }}
                    />
                    <h5 className="card-title">
                      {record.patient.firstName} {record.patient.lastName}
                    </h5>
                  </div>
                  <div className="col-md-4">
                    <p>Gender: {record.patient.gender}</p>
                    <p>
                      Birth Date:{" "}
                      {new Date(record.patient.birthDate).toLocaleDateString()}
                    </p>
                    <p>Age: {record.patient.age}</p>
                    <p>Blood Group: {record.patient.bloodGroup}</p>
                    <p>Height: {record.patient.height}</p>
                    <p>Weight: {record.patient.weight}</p>
                  </div>
                  <div className="col-md-4">
                    <p>Systolic: {record.systolic} mmHg</p>
                    <p>Diastolic: {record.diastolic} mmHg</p>
                    <p>Updated Date: {record.updatedDate}</p>
                  </div>
                </div>
              </div>
            </div>
          </div>
        ))
      ) : (
        <p>No active hypertension records found.</p>
      )}
    </div>
  );
};

export default HypertensionDetails;
