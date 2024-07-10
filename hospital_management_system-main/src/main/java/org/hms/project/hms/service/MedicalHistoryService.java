package org.hms.project.hms.service;

import org.hms.project.hms.dto.MedicalHistoryDto;
import org.hms.project.hms.dto.MedicalHistoryRequest;
import org.hms.project.hms.entity.MedicalHistory;

import java.util.Date;
import java.util.List;

public interface MedicalHistoryService {
    MedicalHistoryDto createMedicalHistory(MedicalHistoryRequest medicalHistoryDto);

    MedicalHistoryDto getMedicalHistoryById(Long medicalHistoryId);

    List<MedicalHistoryDto> getAllMedicalHistory();

    MedicalHistoryDto updateMedicalHistory(Long medicalHistoryId, MedicalHistoryDto updatedMedicalHistory);

    void deleteMedicalHistory(Long medicalHistoryId);

    List<MedicalHistoryDto> getMedicalHistoryByPatientId(Long patientId);

    List<MedicalHistoryDto> getMedicalHistoryByPatientFirstName(String firstName);

    List<MedicalHistoryDto> getMedicalHistoryByUpdatedDate(Date updatedDate);

    List<MedicalHistoryDto> getMedicalHistoryByIsActive(Boolean isActive);

    List<MedicalHistoryDto> getMedicalHistoryByPatientIdAndIsActive(Long patientId, Boolean isActive);

    List<MedicalHistoryDto> getMedicalHistoryByDiseaseIdAndIsActive(Integer diseaseId, Boolean isActive);

}
