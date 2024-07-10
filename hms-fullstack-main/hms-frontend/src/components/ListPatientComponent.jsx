import React, { useEffect, useState } from "react";
import {
  deletePatient,
  listPatients,
  searchPatientByName,
  searchPatientByPhone,
  searchPatientById,
} from "../services/PatientService";
import { useNavigate } from "react-router-dom";
import SearchPatients from "./SearchPatients";
import { FaEdit, FaEye, FaTrashAlt } from "react-icons/fa";

const ListPatientComponent = () => {
  const [patients, setPatients] = useState([]);
  const [searchTerm, setSearchTerm] = useState("");
  const [searchType, setSearchType] = useState("name");
  const navigate = useNavigate();

  useEffect(() => {
    if (searchTerm === "") {
      getAllPatients();
    } else {
      performSearch();
    }
  }, [searchTerm, searchType]);

  const getAllPatients = () => {
    listPatients()
      .then((response) => {
        setPatients(response.data);
      })
      .catch((error) => {
        console.error(error);
      });
  };

  const addNewPatient = () => {
    navigate("/add-patient");
  };

  const updatePatient = (id) => {
    navigate(`/update-patient/${id}`);
  };

  const removePatient = (id) => {
    if (window.confirm("Are you sure you want to delete this patient?")) {
      deletePatient(id)
        .then(() => {
          getAllPatients();
        })
        .catch((error) => {
          console.error(error);
        });
    }
  };

  const viewPatientProfile = (id) => {
    navigate(`/patients/${id}/profile`);
  };

  const performSearch = () => {
    if (searchType === "name") {
      searchPatientByName(searchTerm)
        .then((response) => {
          setPatients(response.data);
        })
        .catch((error) => {
          console.error(error);
          setPatients([]);
        });
    } else if (searchType === "phone") {
      searchPatientByPhone(searchTerm)
        .then((response) => {
          setPatients(response.data);
        })
        .catch((error) => {
          console.error(error);
          setPatients([]);
        });
    } else if (searchType === "id") {
      searchPatientById(searchTerm)
        .then((response) => {
          setPatients([response.data]);
        })
        .catch((error) => {
          console.error(error);
          setPatients([]);
        });
    }
  };

  return (
    <div className="container">
      <br />

      <SearchPatients
        searchType={searchType}
        setSearchType={setSearchType}
        searchTerm={searchTerm}
        setSearchTerm={setSearchTerm}
      />
      <br />
      <h2 className="text-center">List of Patients</h2>
      <button className="btn btn-outline-info mb-2" onClick={addNewPatient}>
        Add Patient
      </button>
      <table className="table table-striped table-bordered table-hover text-center mb-5">
        <thead>
          <tr>
            <th>Id</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Gender</th>
            <th>DOB</th>
            <th>Age</th>
            <th>Blood</th>
            <th>Phone</th>
            <th>Email</th>
            <th colSpan="3">Actions</th>
          </tr>
        </thead>
        <tbody>
          {patients.map((patient) => (
            <tr key={patient.id}>
              <td>{patient.id}</td>
              <td>{patient.firstName}</td>
              <td>{patient.lastName}</td>
              <td>{patient.gender}</td>
              <td>{patient.birthDate}</td>
              <td>{patient.age}</td>
              <td>{patient.bloodGroup}</td>
              <td>{patient.phone}</td>
              <td>{patient.email}</td>
              <td>
                <button
                  className="btn btn-info"
                  onClick={() => viewPatientProfile(patient.id)}
                >
                  <FaEye />
                </button>

                <button
                  className="btn btn-warning mx-2"
                  onClick={() => updatePatient(patient.id)}
                >
                  <FaEdit />
                </button>
                <button
                  className="btn btn-danger mx-2"
                  onClick={() => removePatient(patient.id)}
                >
                  <FaTrashAlt />
                </button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default ListPatientComponent;
