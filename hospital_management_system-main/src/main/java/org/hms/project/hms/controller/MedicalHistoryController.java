package org.hms.project.hms.controller;

import lombok.AllArgsConstructor;
import org.hms.project.hms.dto.MedicalHistoryDto;
import org.hms.project.hms.dto.MedicalHistoryRequest;
import org.hms.project.hms.dto.PatientDto;
import org.hms.project.hms.service.MedicalHistoryService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/medicalhistory")
public class MedicalHistoryController {

    private MedicalHistoryService medicalHistoryService;

    //building add medical history rest api
    @PostMapping
    public ResponseEntity<MedicalHistoryDto> createMedicalHistory(@RequestBody MedicalHistoryRequest medicalHistoryDto) {
        MedicalHistoryDto savedMedicalHistory = medicalHistoryService.createMedicalHistory(medicalHistoryDto);
        return new ResponseEntity<>(savedMedicalHistory, HttpStatus.CREATED);
    }

    //building get medical history by id rest api
    @GetMapping("{id}")
    public ResponseEntity<MedicalHistoryDto> getMedicalHistoryById(@PathVariable("id") Long medicalHistoryId) {
        MedicalHistoryDto medicalHistoryDto = medicalHistoryService.getMedicalHistoryById(medicalHistoryId);
        return ResponseEntity.ok(medicalHistoryDto);
    }

    //building get all medical history rest api
    @GetMapping
    public ResponseEntity<List<MedicalHistoryDto>> getAllMedicalHistory(){
        List<MedicalHistoryDto> medicalHistories = medicalHistoryService.getAllMedicalHistory();
        return ResponseEntity.ok(medicalHistories);
    }

    //building update employ rest api
    @PutMapping("{id}")
    public ResponseEntity<MedicalHistoryDto> updateMedicalHistory(@PathVariable("id") Long medicalHistoryId, @RequestBody MedicalHistoryDto updatedMedicalHistory){
        MedicalHistoryDto medicalHistoryDto = medicalHistoryService.updateMedicalHistory(medicalHistoryId, updatedMedicalHistory);
        return ResponseEntity.ok(medicalHistoryDto);
    }

    //building delete medical history rest api
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteMedicalHistory(@PathVariable("id") Long medicalHistoryId){
        medicalHistoryService.deleteMedicalHistory(medicalHistoryId);
        return ResponseEntity.ok("Deleted Medical History with Id: " + medicalHistoryId);
    }

    //building get medical history by patientId REST API
    @GetMapping("/patient/{id}")
    public ResponseEntity<Object> getMedicalHistoryByPatientId(@PathVariable("id") Long patientId) {
        List<MedicalHistoryDto> medicalHistories  =  medicalHistoryService.getMedicalHistoryByPatientId(patientId);
        return ResponseEntity.ok(medicalHistories);
    }

    //building get medical history by patient's first name
    @GetMapping("/patient/firstName/{firstName}")
    public ResponseEntity<Object> getMedicalHistoryByPatientName(@PathVariable("firstName") String firstName) {
        List<MedicalHistoryDto> medicalHistories = medicalHistoryService.getMedicalHistoryByPatientFirstName(firstName);
        return ResponseEntity.ok(medicalHistories);
    }

    //building get medical history by updatedDate REST API
    @GetMapping("/updatedDate/{updatedDate}")
    public ResponseEntity<Object> getMedicalHistoryByUpdatedDate(@PathVariable("updatedDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date updatedDate) {
        List<MedicalHistoryDto> medicalHistories  =  medicalHistoryService.getMedicalHistoryByUpdatedDate(updatedDate);
        return ResponseEntity.ok(medicalHistories);
    }

    //building get medical history by isActive REST API
    @GetMapping("/isActive/{isActive}")
    public ResponseEntity<Object> getMedicalHistoryByIsActive(@PathVariable("isActive") Boolean isActive) {
        List<MedicalHistoryDto> medicalHistories = medicalHistoryService.getMedicalHistoryByIsActive(isActive);
        return ResponseEntity.ok(medicalHistories);
    }

    //building get medical history by patientId and isActive REST API
    @GetMapping("/byPatientIdAndIsActive")
    public ResponseEntity<Object> getMedicalHistoryByPatientIdAndIsActive(@RequestParam Long patientId, @RequestParam Boolean isActive) {
        List<MedicalHistoryDto> medicalHistories = medicalHistoryService.getMedicalHistoryByPatientIdAndIsActive(patientId, isActive);
        return ResponseEntity.ok(medicalHistories);
    }

    //building get medical history by diseaseId and isActive REST API
    @GetMapping("/byDiseaseIdAndIsActive")
    public ResponseEntity<Object> getMedicalHistoryByDiseaseIdAndIsActive(@RequestParam Integer diseaseId, @RequestParam Boolean isActive) {
        List<MedicalHistoryDto> medicalHistories = medicalHistoryService.getMedicalHistoryByDiseaseIdAndIsActive(diseaseId, isActive);
        return ResponseEntity.ok(medicalHistories);
    }
}
