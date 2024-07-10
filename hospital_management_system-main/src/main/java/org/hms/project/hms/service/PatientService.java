package org.hms.project.hms.service;

import org.hms.project.hms.dto.PatientDto;
import org.hms.project.hms.entity.Patient;

import java.util.List;

public interface PatientService {
    PatientDto createPatient(PatientDto patientDto);

    PatientDto getPatientById (Long patientId);
    List<PatientDto> getPatientByFirstName(String firstName);
    List<PatientDto> getPatientByPhone(String phone);

    List<PatientDto> getAllPatients();

    PatientDto updatePatient(Long patientId, PatientDto updatedPatient);

    void deletePatient(Long patientId);
}
