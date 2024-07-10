package org.hms.project.hms.service.impl;

import lombok.AllArgsConstructor;
import org.hms.project.hms.dto.PatientDto;
import org.hms.project.hms.entity.Patient;
import org.hms.project.hms.exception.ResourceNotFoundException;
import org.hms.project.hms.mapper.PatientMapper;
import org.hms.project.hms.repository.PatientRepository;
import org.hms.project.hms.service.PatientService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor

public class PatientServiceImpl implements PatientService {

    private PatientRepository patientRepository;

    @Override
    public PatientDto createPatient(PatientDto patientDto){

        Patient patient = PatientMapper.mapToPatient(patientDto);
        Patient savedPatient = patientRepository.save(patient);
        return PatientMapper.mapToPatientDto(savedPatient);
    }

    @Override
    public PatientDto getPatientById(Long patientId) {
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Patient with id " + patientId + " not found"));
        return PatientMapper.mapToPatientDto(patient);
    }

    @Override
    public List<PatientDto> getPatientByFirstName(String firstName) {
        List<Patient> patients = patientRepository.findByFirstName(firstName);
        return patients.stream().map((patient) -> PatientMapper.mapToPatientDto(patient))
                .collect(Collectors.toList());
    }

    @Override
    public List<PatientDto> getPatientByPhone(String phone) {
        List<Patient> patients = patientRepository.findByPhone(phone);
        return patients.stream().map((patient) -> PatientMapper.mapToPatientDto(patient))
                .collect(Collectors.toList());
    }


    @Override
    public List<PatientDto> getAllPatients() {
        List<Patient> patients = patientRepository.findAll();
        return patients.stream().map((patient) -> PatientMapper.mapToPatientDto(patient))
                .collect(Collectors.toList());
    }

    @Override
    public PatientDto updatePatient(Long patientId, PatientDto updatedPatient) {
        Patient patient = patientRepository.findById(patientId).orElseThrow(
                () -> new ResourceNotFoundException("Patient with id " + patientId + " not found")
        );

        patient.setFirstName(updatedPatient.getFirstName());
        patient.setLastName(updatedPatient.getLastName());
        patient.setGender(updatedPatient.getGender());
        patient.setBirthDate(updatedPatient.getBirthDate());
        patient.setAge(updatedPatient.getAge());
        patient.setBloodGroup(updatedPatient.getBloodGroup());
        patient.setPhone(updatedPatient.getPhone());
        patient.setEmail(updatedPatient.getEmail());
        patient.setAddress(updatedPatient.getAddress());
        patient.setHeight(updatedPatient.getHeight());
        patient.setWeight(updatedPatient.getWeight());
        patient.setMedicalReason(updatedPatient.getMedicalReason());

        Patient updatedPatientObj = patientRepository.save(patient);

        return PatientMapper.mapToPatientDto(updatedPatientObj);
    }

    @Override
    public void deletePatient(Long patientId) {

        Patient patient = patientRepository.findById(patientId).orElseThrow(
                () -> new ResourceNotFoundException("Patient with id " + patientId + " not found")
        );

        patientRepository.deleteById(patientId);

    }
}
