import "./App.css";
import HomePage from "./components/HomePage";
import PatientProfile from "./components/PatientProfile";
import PatientComponent from "./components/PatientComponent";
import AddMedicalDetail from "./components/AddMedicalDetail";
import MedicalHistoryDetail from "./components/MedicalHistoryDetail";
import FooterComponent from "./components/FooterComponent";
import HeaderComponent from "./components/HeaderComponent";
import ListPatientComponent from "./components/ListPatientComponent";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import HypertensionDetails from "./components/HypertensionDetails";
import DiabetesDetails from "./components/DiabetesDetails";


function App() {
  return (
    <>
      <BrowserRouter>
        <HeaderComponent />

        <Routes>
          {/* // http://localhost:3000 */}
          <Route path="/" element={<HomePage />} />
          <Route path="/home" element={<HomePage />} />
          <Route
            path="/hypertension-details"
            element={<HypertensionDetails />}
          />
          <Route path="/diabetes-details" element={<DiabetesDetails />} />
          {/* // http://localhost:3000/patients */}
          <Route path="/patients" element={<ListPatientComponent />}></Route>
          <Route path="/patients" element={<PatientComponent />} />
          {/* // http://localhost:3000/add-patient */}
          <Route path="/add-patient" element={<PatientComponent />}></Route>
          {/* // http://localhost:3000/update-patient/{id} */}
          <Route
            path="/update-patient/:id"
            element={<PatientComponent />}
          ></Route>
          {/* // http://localhost:3000/patients/{id}/profile */}
          <Route path="/patients/:id/profile" element={<PatientProfile />} />
        

          <Route exact path="/patient/:id" component={PatientProfile}></Route>
          <Route
            path="/patient/:id/medicalhistory/:diseaseId"
            component={MedicalHistoryDetail}
          ></Route>
          <Route path="/patient/:id" element={<PatientProfile />}></Route>
          <Route
            path="/patients/:id/medicalhistory/:diseaseId"
            element={<MedicalHistoryDetail />}
          />
          <Route
            path="/patients/:id/addmedicaldetail/:diseaseId"
            element={<AddMedicalDetail />}
          />
        </Routes>

        <FooterComponent />
      </BrowserRouter>
    </>
  );
}

export default App;
