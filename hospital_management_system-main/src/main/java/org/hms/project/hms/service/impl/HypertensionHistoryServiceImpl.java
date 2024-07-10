package org.hms.project.hms.service.impl;

import lombok.AllArgsConstructor;
import org.hms.project.hms.dto.HypertensionHistoryDto;
import org.hms.project.hms.entity.HypertensionHistory;
import org.hms.project.hms.exception.ResourceNotFoundException;
import org.hms.project.hms.mapper.HypertensionHistoryMapper;
import org.hms.project.hms.repository.HypertensionHistoryRepository;
import org.hms.project.hms.service.HypertensionHistoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class HypertensionHistoryServiceImpl implements HypertensionHistoryService {

    private HypertensionHistoryRepository hypertensionHistoryRepository;

    @Override
    public HypertensionHistoryDto createHypertensionHistory(HypertensionHistoryDto hypertensionHistoryDto) {

        HypertensionHistory hypertensionHistory = HypertensionHistoryMapper.mapToHypertensionHistory(hypertensionHistoryDto);
        HypertensionHistory savedHypertensionHistory = hypertensionHistoryRepository.save(hypertensionHistory);
        return HypertensionHistoryMapper.mapToHypertensionHistoryDto(savedHypertensionHistory);
    }

    @Override
    public HypertensionHistoryDto getHypertensionHistoryById(Long hypertensionHistoryId) {
        HypertensionHistory hypertensionHistory = hypertensionHistoryRepository.findById(hypertensionHistoryId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Hypertension history not found with id: " + hypertensionHistoryId));

        return HypertensionHistoryMapper.mapToHypertensionHistoryDto(hypertensionHistory);
    }

    @Override
    public List<HypertensionHistoryDto> getAllHypertensionHistory() {
        List<HypertensionHistory> hypertensionHistories = hypertensionHistoryRepository.findAll();
        return hypertensionHistories.stream().map((hypertensionHistory) -> HypertensionHistoryMapper.mapToHypertensionHistoryDto(hypertensionHistory))
                .collect(Collectors.toList());
    }

    @Override
    public HypertensionHistoryDto updateHypertensionHistory(Long hypertensionHistoryId, HypertensionHistoryDto updatedHypertensionHistory) {
        HypertensionHistory hypertensionHistory = hypertensionHistoryRepository.findById(hypertensionHistoryId).orElseThrow(
                () -> new ResourceNotFoundException("Hypertension history not found with id: " + hypertensionHistoryId)
        );

        hypertensionHistory.setDetails(updatedHypertensionHistory.getDetails());
        hypertensionHistory.setTreatment(updatedHypertensionHistory.getTreatment());
        hypertensionHistory.setDiagnosisDate(updatedHypertensionHistory.getDiagnosisDate());

        HypertensionHistory updatedHypertensionHistoryObj = hypertensionHistoryRepository.save(hypertensionHistory);

        return HypertensionHistoryMapper.mapToHypertensionHistoryDto(updatedHypertensionHistoryObj);
    }

    @Override
    public void deleteHypertensionHistory(Long hypertensionHistoryId) {

        HypertensionHistory hypertensionHistory = hypertensionHistoryRepository.findById(hypertensionHistoryId).orElseThrow(
                () -> new ResourceNotFoundException("Hypertension history not found with id: " + hypertensionHistoryId)
        );

        hypertensionHistoryRepository.deleteById(hypertensionHistoryId);

    }
}
