package org.hms.project.hms.service;

import org.hms.project.hms.dto.DiabetesHistoryDto;

import java.util.List;

public interface DiabetesHistoryService {
    DiabetesHistoryDto createDiabetesHistory(DiabetesHistoryDto diabetesHistoryDto);

    DiabetesHistoryDto getDiabetesHistoryById(Long diabetesHistoryId);

    List<DiabetesHistoryDto> getAllDiabetesHistory();

    DiabetesHistoryDto updateDiabetesHistory(Long diabetesHistoryId, DiabetesHistoryDto updatedDiabetesHistory);

    void deleteDiabetesHistory(Long diabetesHistoryId);
}
