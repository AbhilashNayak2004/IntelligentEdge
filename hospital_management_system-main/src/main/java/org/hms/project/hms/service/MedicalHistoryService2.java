package org.hms.project.hms.service;

import org.hms.project.hms.dto.MedicalHistoryDto;

import java.util.List;

public interface MedicalHistoryService2 {
    List<MedicalHistoryDto> getMedicalHistoryByPatientIdAndDiseaseId(Long patientId, Integer diseaseId);
}
