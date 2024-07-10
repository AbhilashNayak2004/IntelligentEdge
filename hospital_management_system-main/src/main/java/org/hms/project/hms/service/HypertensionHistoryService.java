package org.hms.project.hms.service;

import org.hms.project.hms.dto.HypertensionHistoryDto;

import java.util.List;

public interface HypertensionHistoryService{
    HypertensionHistoryDto createHypertensionHistory(HypertensionHistoryDto hypertensionHistoryDto);

    HypertensionHistoryDto getHypertensionHistoryById(Long hypertensionHistoryId);

    List<HypertensionHistoryDto> getAllHypertensionHistory();

    HypertensionHistoryDto updateHypertensionHistory(Long hypertensionHistoryId, HypertensionHistoryDto updatedHypertensionHistory);

    void deleteHypertensionHistory(Long hypertensionHistoryId);
}
