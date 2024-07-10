package org.hms.project.hms.controller;

import lombok.AllArgsConstructor;
import org.hms.project.hms.dto.DiabetesHistoryDto;
import org.hms.project.hms.service.DiabetesHistoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/diabetes")
public class DiabetesHistoryController {

    private DiabetesHistoryService diabetesHistoryService;

    //building add diabetes history api
    @PostMapping
    public ResponseEntity<DiabetesHistoryDto> createDiabetesHistory(@RequestBody DiabetesHistoryDto diabetesHistoryDto){
        DiabetesHistoryDto savedDiabetesHistory = diabetesHistoryService.createDiabetesHistory(diabetesHistoryDto);
        return new ResponseEntity<>(savedDiabetesHistory, HttpStatus.CREATED);
    }

    //building get diabetes history rest api
    @GetMapping("{id}")
    public ResponseEntity<DiabetesHistoryDto> getDiabetesHistoryById(@PathVariable("id") Long diabetesHistoryId){
        DiabetesHistoryDto diabetesHistoryDto = diabetesHistoryService.getDiabetesHistoryById(diabetesHistoryId);
        return ResponseEntity.ok(diabetesHistoryDto);
    }

    //building get all diabetes history rest api
    @GetMapping
    public ResponseEntity<List<DiabetesHistoryDto>> getAllDiabetesHistory(){
        List<DiabetesHistoryDto> diabetesHistories = diabetesHistoryService.getAllDiabetesHistory();
        return ResponseEntity.ok(diabetesHistories);
    }

    //building update diabetes history rest api
    @PutMapping("{id}")
    public ResponseEntity<DiabetesHistoryDto> updateDiabetesHistory(@PathVariable("id") Long diabetesHistoryId, @RequestBody DiabetesHistoryDto updatedDiabetesHistory){
        DiabetesHistoryDto diabetesHistoryDto = diabetesHistoryService.updateDiabetesHistory(diabetesHistoryId, updatedDiabetesHistory);
        return ResponseEntity.ok(diabetesHistoryDto);
    }

    //building delete diabetes history rest api
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteDiabetesHistory(@PathVariable("id") Long diabetesHistoryId){
        diabetesHistoryService.deleteDiabetesHistory(diabetesHistoryId);
        return ResponseEntity.ok("Diabetes history deleted");
    }

}
