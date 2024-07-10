package org.hms.project.hms.service.impl;

import lombok.AllArgsConstructor;
import org.hms.project.hms.dto.MedicalHistoryDto;
import org.hms.project.hms.dto.MedicalHistoryRequest;
import org.hms.project.hms.dto.PatientDto;
import org.hms.project.hms.entity.MedicalHistory;
import org.hms.project.hms.entity.Patient;
import org.hms.project.hms.exception.ResourceNotFoundException;
import org.hms.project.hms.mapper.MedicalHistoryMapper;
import org.hms.project.hms.mapper.PatientMapper;
import org.hms.project.hms.repository.MedicalHistoryRepository;
import org.hms.project.hms.repository.PatientRepository;
import org.hms.project.hms.service.MedicalHistoryService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class MedicalHistoryServiceImpl implements MedicalHistoryService {

    private final PatientRepository patientRepository;
    private MedicalHistoryRepository medicalHistoryRepository;

    @Override
    public MedicalHistoryDto createMedicalHistory(MedicalHistoryRequest medicalHistoryRequest) {

        // Deactivate previous entries for the same patient and disease
        medicalHistoryRepository.deactivatePreviousEntries(medicalHistoryRequest.getPatientId(), medicalHistoryRequest.getDiseaseId());


        Patient patient = patientRepository.findById(medicalHistoryRequest.getPatientId()).orElseThrow(() ->
                new ResourceNotFoundException("Patient not found"));
        MedicalHistory medicalHistory = MedicalHistoryMapper.mapToMedicalHistory(medicalHistoryRequest, patient);
        MedicalHistory savedMedicalHistory = medicalHistoryRepository.save(medicalHistory);
        return MedicalHistoryMapper.mapToMedicalHistoryDto(savedMedicalHistory);
    }

    @Override
    public MedicalHistoryDto getMedicalHistoryById(Long medicalHistoryId) {
        MedicalHistory medicalHistory = medicalHistoryRepository.findById(medicalHistoryId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("There is no medical history report with id "+ medicalHistoryId));
        return MedicalHistoryMapper.mapToMedicalHistoryDto(medicalHistory);
    }

    @Override
    public List<MedicalHistoryDto> getAllMedicalHistory() {
        List<MedicalHistory> medicalHistories= medicalHistoryRepository.findAll();
        return medicalHistories.stream().map((medicalHistory) -> MedicalHistoryMapper.mapToMedicalHistoryDto(medicalHistory))
                .collect(Collectors.toList());
    }

    @Override
    public MedicalHistoryDto updateMedicalHistory(Long medicalHistoryId, MedicalHistoryDto updatedMedicalHistory) {
        MedicalHistory medicalHistory = medicalHistoryRepository.findById(medicalHistoryId).orElseThrow(
                () -> new ResourceNotFoundException("There is no medical history report with id "+ medicalHistoryId)
        );

        medicalHistory.setDiseaseId(updatedMedicalHistory.getDiseaseId());
        medicalHistory.setFbg(updatedMedicalHistory.getFbg());
        medicalHistory.setPpbg(updatedMedicalHistory.getPpbg());
        medicalHistory.setRbg(updatedMedicalHistory.getRbg());
        medicalHistory.setSystolic(updatedMedicalHistory.getSystolic());
        medicalHistory.setDiastolic(updatedMedicalHistory.getDiastolic());
        medicalHistory.setIsActive(updatedMedicalHistory.getIsActive());
        medicalHistory.setUpdatedDate(updatedMedicalHistory.getUpdatedDate());
        medicalHistory.setPatient(updatedMedicalHistory.getPatient());

        MedicalHistory updatedMedicalHistoryObj = medicalHistoryRepository.save(medicalHistory);
        return MedicalHistoryMapper.mapToMedicalHistoryDto(updatedMedicalHistoryObj);
    }

    @Override
    public void deleteMedicalHistory(Long medicalHistoryId) {
        MedicalHistory medicalHistory = medicalHistoryRepository.findById(medicalHistoryId).orElseThrow(
                () -> new ResourceNotFoundException("There is no medical history report with id "+ medicalHistoryId)
        );

        medicalHistoryRepository.deleteById(medicalHistoryId);
    }

    @Override
    public List<MedicalHistoryDto> getMedicalHistoryByPatientId(Long patientId) {
        List<MedicalHistory> medicalHistories = medicalHistoryRepository.findByPatientId(patientId);
        return medicalHistories.stream().map((medicalHistory) -> MedicalHistoryMapper.mapToMedicalHistoryDto(medicalHistory))
                .collect(Collectors.toList());
    }

    @Override
    public List<MedicalHistoryDto> getMedicalHistoryByPatientFirstName(String firstName) {
        List<MedicalHistory> medicalHistories = medicalHistoryRepository.findByPatientFirstName(firstName);
        return medicalHistories.stream().map((medicalHistory) -> MedicalHistoryMapper.mapToMedicalHistoryDto(medicalHistory))
                .collect(Collectors.toList());
    }

    @Override
    public List<MedicalHistoryDto> getMedicalHistoryByUpdatedDate(Date updatedDate) {
        List<MedicalHistory> medicalHistories = medicalHistoryRepository.findByUpdatedDate(updatedDate);
        return medicalHistories.stream().map((medicalHistory) -> MedicalHistoryMapper.mapToMedicalHistoryDto(medicalHistory))
                .collect(Collectors.toList());
    }

    @Override
    public List<MedicalHistoryDto> getMedicalHistoryByIsActive(Boolean isActive) {
        List<MedicalHistory> medicalHistories = medicalHistoryRepository.findByIsActive(isActive);
        return medicalHistories.stream().map((medicalHistory) -> MedicalHistoryMapper.mapToMedicalHistoryDto(medicalHistory))
                .collect(Collectors.toList());
    }

    @Override
    public List<MedicalHistoryDto> getMedicalHistoryByPatientIdAndIsActive(Long patientId, Boolean isActive) {
        List<MedicalHistory> medicalHistories = medicalHistoryRepository.findByPatientIdAndIsActive(patientId, isActive);
        return medicalHistories.stream().map((medicalHistory) -> MedicalHistoryMapper.mapToMedicalHistoryDto(medicalHistory))
                .collect(Collectors.toList());
    }

    @Override
    public List<MedicalHistoryDto> getMedicalHistoryByDiseaseIdAndIsActive(Integer diseaseId, Boolean isActive) {
        List<MedicalHistory> medicalHistories = medicalHistoryRepository.findByDiseaseIdAndIsActive(diseaseId, isActive);
        return medicalHistories.stream().map((medicalHistory) -> MedicalHistoryMapper.mapToMedicalHistoryDto(medicalHistory))
                .collect(Collectors.toList());
    }

}
