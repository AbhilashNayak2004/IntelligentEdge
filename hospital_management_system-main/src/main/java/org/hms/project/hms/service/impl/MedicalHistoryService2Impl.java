package org.hms.project.hms.service.impl;

import lombok.AllArgsConstructor;
import org.hms.project.hms.dto.MedicalHistoryDto;
import org.hms.project.hms.entity.MedicalHistory;
import org.hms.project.hms.mapper.MedicalHistoryMapper;
import org.hms.project.hms.repository.MedicalHistoryRepository;
import org.hms.project.hms.repository.PatientRepository;
import org.hms.project.hms.service.MedicalHistoryService2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class MedicalHistoryService2Impl implements MedicalHistoryService2 {

    private final PatientRepository patientRepository;
    private MedicalHistoryRepository medicalHistoryRepository;

    @Override
    public List<MedicalHistoryDto> getMedicalHistoryByPatientIdAndDiseaseId(Long patientId, Integer diseaseId) {
        List<MedicalHistory> medicalHistories = medicalHistoryRepository.findByPatientIdAndDiseaseId(patientId, diseaseId);
        return medicalHistories.stream().map((medicalHistory) -> MedicalHistoryMapper.mapToMedicalHistoryDto(medicalHistory))
                .collect(Collectors.toList());
    }
}
