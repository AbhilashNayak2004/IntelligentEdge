package org.hms.project.hms.controller;

import lombok.AllArgsConstructor;
import org.hms.project.hms.dto.PatientDto;
import org.hms.project.hms.service.PatientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/patients")
public class PatientController {

    private PatientService patientService;

    // Build Add Patient REST API
    @PostMapping
    public ResponseEntity<PatientDto> createPatient(@RequestBody PatientDto patientDto) {
        PatientDto savedPatient = patientService.createPatient(patientDto);
        return new ResponseEntity<>(savedPatient, HttpStatus.CREATED);
    }

    // Build Get Patient REST API by Patient Id
    @GetMapping("{id}")
    public ResponseEntity<PatientDto> getPatientById(@PathVariable("id") Long patientId) {
        PatientDto patientDto = patientService.getPatientById(patientId);
        return ResponseEntity.ok(patientDto);
    }

    // Build Get Patient REST API by Patient Name
    @GetMapping("/firstName/{firstName}")
    public ResponseEntity<Object> getPatientByFirstName(@PathVariable("firstName") String firstName) {
        List<PatientDto> patients  =  patientService.getPatientByFirstName(firstName);
        return ResponseEntity.ok(patients);
    }

    // Build Get Patient REST API by Patient Phone
    @GetMapping("/phone/{phone}")
    public ResponseEntity<Object> getPatientByPhoneNumber(@PathVariable("phone") String phone) {
        List<PatientDto> patients =  patientService.getPatientByPhone(phone);
        return ResponseEntity.ok(patients);
    }

    // Build Get All Patients REST API
    @GetMapping
    public ResponseEntity<Object> getAllPatients() {
        List<PatientDto> patients = patientService.getAllPatients();
        return ResponseEntity.ok(patients);
    }

    // Build Update Patient REST API
    @PutMapping("{id}")
    public ResponseEntity<PatientDto> updatePatient(@PathVariable("id") Long patientId, @RequestBody PatientDto updatedPatient) {
        PatientDto patientDto = patientService.updatePatient(patientId, updatedPatient);
        return ResponseEntity.ok(patientDto);
    }

    // Build Delete Patient REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deletePatient(@PathVariable("id") Long patientId) {
        patientService.deletePatient(patientId);
        return ResponseEntity.ok("Patient deleted successfully");
    }


}
