package org.hms.project.hms.controller;

import lombok.AllArgsConstructor;
import org.hms.project.hms.dto.HypertensionHistoryDto;
import org.hms.project.hms.service.HypertensionHistoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/hypertension")
public class HypertensionHistoryController {

    private HypertensionHistoryService hypertensionHistoryService;

    //building add hypertension history rest api
    @PostMapping
    public ResponseEntity<HypertensionHistoryDto> createHypertensionHistory(@RequestBody HypertensionHistoryDto hypertensionHistoryDto) {
        HypertensionHistoryDto savedHypertensionHistory = hypertensionHistoryService.createHypertensionHistory(hypertensionHistoryDto);
        return new ResponseEntity<>(savedHypertensionHistory, HttpStatus.CREATED);
    }

    //building get hypertension history rest api
    @GetMapping("{id}")
    public ResponseEntity<HypertensionHistoryDto> getHypertensionHistoryById(@PathVariable("id") Long hypertensionHistoryId) {
        HypertensionHistoryDto hypertensionHistoryDto = hypertensionHistoryService.getHypertensionHistoryById(hypertensionHistoryId);
        return ResponseEntity.ok(hypertensionHistoryDto);
    }

    //building get all hypertension history rest api
    @GetMapping
    public ResponseEntity<List<HypertensionHistoryDto>> getHypertensionHistory() {
        List<HypertensionHistoryDto> hypertensionHistories = hypertensionHistoryService.getAllHypertensionHistory();
        return ResponseEntity.ok(hypertensionHistories);
    }

    //building update hypertension history rest api
    @PutMapping("{id}")
    public ResponseEntity<HypertensionHistoryDto> updateHypertensionHistory(@PathVariable("id") Long hypertensionHistoryId, @RequestBody HypertensionHistoryDto updatedHypertensionHistory) {
        HypertensionHistoryDto hypertensionHistoryDto = hypertensionHistoryService.updateHypertensionHistory(hypertensionHistoryId, updatedHypertensionHistory);
        return ResponseEntity.ok(hypertensionHistoryDto);
    }

    //building delete hypertension history rest api
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteHypertensionHistory(@PathVariable("id") Long hypertensionHistoryId) {
        hypertensionHistoryService.deleteHypertensionHistory(hypertensionHistoryId);
        return ResponseEntity.ok("Deleted hypertension history");
    }

}
