package org.hms.project.hms.mapper;

import org.hms.project.hms.dto.MedicalHistoryDto;
import org.hms.project.hms.dto.MedicalHistoryRequest;
import org.hms.project.hms.entity.MedicalHistory;
import org.hms.project.hms.entity.Patient;

public class MedicalHistoryMapper {
    public static MedicalHistoryDto mapToMedicalHistoryDto(MedicalHistory medicalHistory) {
        return new MedicalHistoryDto(
                medicalHistory.getId(),
                medicalHistory.getDiseaseId(),
                medicalHistory.getFbg(),
                medicalHistory.getPpbg(),
                medicalHistory.getRbg(),
                medicalHistory.getSystolic(),
                medicalHistory.getDiastolic(),
                medicalHistory.getIsActive(),
                medicalHistory.getUpdatedDate(),
                medicalHistory.getPatient()
        );
    }

    public static MedicalHistory mapToMedicalHistory(MedicalHistoryRequest medicalHistoryRequest, Patient patient) {
        return new MedicalHistory(
                medicalHistoryRequest.getId(),
                medicalHistoryRequest.getDiseaseId(),
                medicalHistoryRequest.getFbg(),
                medicalHistoryRequest.getPpbg(),
                medicalHistoryRequest.getRbg(),
                medicalHistoryRequest.getSystolic(),
                medicalHistoryRequest.getDiastolic(),
                medicalHistoryRequest.getIsActive(),
                medicalHistoryRequest.getUpdatedDate(),
                patient
        );
    }

}
