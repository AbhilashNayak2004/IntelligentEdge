package org.hms.project.hms.mapper;

import org.hms.project.hms.dto.HypertensionHistoryDto;
import org.hms.project.hms.entity.HypertensionHistory;

public class HypertensionHistoryMapper {
    public static HypertensionHistoryDto mapToHypertensionHistoryDto(HypertensionHistory hypertensionHistory) {
        return new HypertensionHistoryDto(
          hypertensionHistory.getId(),
          hypertensionHistory.getDetails(),
          hypertensionHistory.getTreatment(),
                hypertensionHistory.getSystolic(),
          hypertensionHistory.getDiastolic(),
          hypertensionHistory.getDiagnosisDate()
        );
    }

    public static HypertensionHistory mapToHypertensionHistory(HypertensionHistoryDto hypertensionHistoryDto) {
        return new HypertensionHistory(
                hypertensionHistoryDto.getId(),
                hypertensionHistoryDto.getDetails(),
                hypertensionHistoryDto.getTreatment(),
                hypertensionHistoryDto.getSystolic(),
                hypertensionHistoryDto.getDiastolic(),
                hypertensionHistoryDto.getDiagnosisDate()
        );
    }
}
