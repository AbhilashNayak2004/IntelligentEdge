package org.hms.project.hms.controller;

import lombok.AllArgsConstructor;
import org.hms.project.hms.dto.MedicalHistoryDto;
import org.hms.project.hms.dto.MedicalHistoryRequest;
import org.hms.project.hms.entity.MedicalHistory;
import org.hms.project.hms.entity.Patient;
import org.hms.project.hms.service.MedicalHistoryService;
import org.hms.project.hms.service.MedicalHistoryService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/patients")
public class MedicalHistoryController2 {

    @Autowired
    private MedicalHistoryService medicalHistoryService;
    private MedicalHistoryService2 medicalHistoryService2;

    @PostMapping("/{patientId}/addmedicaldetail/{diseaseId}")
    public ResponseEntity<MedicalHistoryDto> addMedicalDetail(
            @PathVariable Long patientId,
            @PathVariable Integer diseaseId,
            @RequestBody MedicalHistoryRequest medicalHistoryDto
    ) {
        MedicalHistoryDto savedMedicalHistory = medicalHistoryService.createMedicalHistory(medicalHistoryDto);
        return new ResponseEntity<>(savedMedicalHistory, HttpStatus.CREATED);
    }

    @GetMapping("/{patientId}/medicalhistory/{diseaseId}")
    public ResponseEntity<Object> getMedicalDetail(@PathVariable Long patientId, @PathVariable Integer diseaseId){
        List<MedicalHistoryDto> medicalHistories = medicalHistoryService2.getMedicalHistoryByPatientIdAndDiseaseId(patientId, diseaseId);
        return ResponseEntity.ok(medicalHistories);
    }
}
