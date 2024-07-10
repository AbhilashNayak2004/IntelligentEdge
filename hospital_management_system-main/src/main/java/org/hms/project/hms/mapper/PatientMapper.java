package org.hms.project.hms.mapper;

import org.hms.project.hms.dto.PatientDto;
import org.hms.project.hms.entity.Patient;

public class PatientMapper {
    public static PatientDto mapToPatientDto(Patient patient) {
        return new PatientDto(
                patient.getId(),
                patient.getFirstName(),
                patient.getLastName(),
                patient.getGender(),
                patient.getBirthDate(),
                patient.getAge(),
                patient.getBloodGroup(),
                patient.getPhone(),
                patient.getEmail(),
                patient.getAddress(),
                patient.getHeight(),
                patient.getWeight(),
                patient.getMedicalReason()
        );
    }

    public static Patient mapToPatient(PatientDto patientDto) {
        return new Patient(
                patientDto.getId(),
                patientDto.getFirstName(),
                patientDto.getLastName(),
                patientDto.getGender(),
                patientDto.getBirthDate(),
                patientDto.getAge(),
                patientDto.getBloodGroup(),
                patientDto.getPhone(),
                patientDto.getEmail(),
                patientDto.getAddress(),
                patientDto.getHeight(),
                patientDto.getWeight(),
                patientDto.getMedicalReason()
        );
    }
}
