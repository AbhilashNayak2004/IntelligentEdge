import axios from "axios";

export const REST_API_BASE_URL = "http://localhost:8080/api/patients";
export const REST_API_BASE_MEDICAL_URL =
  "http://localhost:8080/api/medicalhistory";

export const listPatients = () => axios.get(REST_API_BASE_URL);

export const createPatient = (patient) =>
  axios.post(REST_API_BASE_URL, patient);

export const getPatient = (patientId) =>
  axios.get(REST_API_BASE_URL + "/" + patientId);

export const updatePatient = (patientId, patient) =>
  axios.put(REST_API_BASE_URL + "/" + patientId, patient);

export const deletePatient = (patientId) =>
  axios.delete(REST_API_BASE_URL + "/" + patientId);

export const searchPatientByName = (firstName) =>
  axios.get(REST_API_BASE_URL + "/firstName/" + firstName);

export const searchPatientByPhone = (phone) =>
  axios.get(REST_API_BASE_URL + "/phone/" + phone);

export const searchPatientById = (patientId) =>
  axios.get(REST_API_BASE_URL + "/" + patientId);

export const getMedicalHistoryByPatientId = (patientId) =>
  axios.get(REST_API_BASE_MEDICAL_URL + `patients/${patientId}`);

export const getMedicalHistoryByPatientIdAndIsActive = (
  patientId,
  isActive
) => {
  return axios.get(`${REST_API_BASE_MEDICAL_URL}/byPatientIdAndIsActive`, {
    params: {
      patientId,
      isActive,
    },
  });
};

export const getActiveMedicalHistoryByDisease = (diseaseId, isActive) => {
  return axios.get(`${REST_API_BASE_MEDICAL_URL}/byDiseaseIdAndIsActive`, {
    params: {
      diseaseId,
      isActive,
    },
  });
};

export const getMedicalHistoryDetailByPatientId = (patientId, diseaseId) =>
  axios.get(`${REST_API_BASE_URL}/${patientId}/medicalhistory/${diseaseId}`);

export const addMedicalDetail = (data, diseaseId) =>
  axios.post(
    `${REST_API_BASE_URL}/${data.patientId}/addmedicaldetail/${diseaseId}`,
    data
  );
