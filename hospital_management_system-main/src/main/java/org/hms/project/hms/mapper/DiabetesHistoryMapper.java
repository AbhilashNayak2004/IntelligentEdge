package org.hms.project.hms.mapper;

import org.hms.project.hms.dto.DiabetesHistoryDto;
import org.hms.project.hms.entity.DiabetesHistory;

public class DiabetesHistoryMapper {
    public static DiabetesHistoryDto mapToDto(DiabetesHistory diabetesHistory) {
        return new DiabetesHistoryDto(
                diabetesHistory.getId(),
                diabetesHistory.getDetails(),
                diabetesHistory.getTreatment(),
                diabetesHistory.getFbg(),
                diabetesHistory.getPpbg(),
                diabetesHistory.getRbg(),
                diabetesHistory.getDiagnosisDate()
        );
    }

    public static DiabetesHistory mapToDiabetesHistory(DiabetesHistoryDto diabetesHistoryDto) {
        return new DiabetesHistory(
                diabetesHistoryDto.getId(),
                diabetesHistoryDto.getDetails(),
                diabetesHistoryDto.getTreatment(),
                diabetesHistoryDto.getFbg(),
                diabetesHistoryDto.getPpbg(),
                diabetesHistoryDto.getRbg(),
                diabetesHistoryDto.getDiagnosisDate()
        );
    }
}
