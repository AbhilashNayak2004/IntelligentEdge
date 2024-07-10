package org.hms.project.hms.service.impl;

import lombok.AllArgsConstructor;
import org.hms.project.hms.dto.DiabetesHistoryDto;
import org.hms.project.hms.entity.DiabetesHistory;
import org.hms.project.hms.exception.ResourceNotFoundException;
import org.hms.project.hms.mapper.DiabetesHistoryMapper;
import org.hms.project.hms.repository.DiabetesHistoryRepository;
import org.hms.project.hms.service.DiabetesHistoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DiabetesHistoryServiceImpl implements DiabetesHistoryService {

    private DiabetesHistoryRepository diabetesHistoryRepository;

    @Override
    public DiabetesHistoryDto createDiabetesHistory(DiabetesHistoryDto diabetesHistoryDto) {

        DiabetesHistory diabetesHistory = DiabetesHistoryMapper.mapToDiabetesHistory(diabetesHistoryDto);
        DiabetesHistory savedDiabetesHistory = diabetesHistoryRepository.save(diabetesHistory);
        return DiabetesHistoryMapper.mapToDto(savedDiabetesHistory);
    }

    @Override
    public DiabetesHistoryDto getDiabetesHistoryById(Long diabetesHistoryId) {
        DiabetesHistory diabetesHistory = diabetesHistoryRepository.findById(diabetesHistoryId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Diabetes history not found with id: " + diabetesHistoryId));

        return DiabetesHistoryMapper.mapToDto(diabetesHistory);
    }

    @Override
    public List<DiabetesHistoryDto> getAllDiabetesHistory() {
        List<DiabetesHistory> diabetesHistories = diabetesHistoryRepository.findAll();
        return diabetesHistories.stream().map((diabetesHistory) -> DiabetesHistoryMapper.mapToDto(diabetesHistory))
                .collect(Collectors.toList());
    }

    @Override
    public DiabetesHistoryDto updateDiabetesHistory(Long diabetesHistoryId, DiabetesHistoryDto updatedDiabetesHistory) {
        DiabetesHistory diabetesHistory = diabetesHistoryRepository.findById(diabetesHistoryId).orElseThrow(
                () -> new ResourceNotFoundException("Diabetes history not found with id: " + diabetesHistoryId)
        );

        diabetesHistory.setDetails(updatedDiabetesHistory.getDetails());
        diabetesHistory.setTreatment(updatedDiabetesHistory.getTreatment());
        diabetesHistory.setDiagnosisDate(updatedDiabetesHistory.getDiagnosisDate());

        DiabetesHistory updatedDiabetesHistoryObj = diabetesHistoryRepository.save(diabetesHistory);

        return DiabetesHistoryMapper.mapToDto(updatedDiabetesHistoryObj);
    }

    @Override
    public void deleteDiabetesHistory(Long diabetesHistoryId) {

        DiabetesHistory diabetesHistory = diabetesHistoryRepository.findById(diabetesHistoryId).orElseThrow(
                () -> new ResourceNotFoundException("Diabetes history not found with id: " + diabetesHistoryId)
        );

        diabetesHistoryRepository.deleteById(diabetesHistoryId);

    }
}
