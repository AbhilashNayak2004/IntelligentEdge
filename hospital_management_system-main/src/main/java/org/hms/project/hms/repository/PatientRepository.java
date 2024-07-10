package org.hms.project.hms.repository;

import org.hms.project.hms.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    List<Patient> findByFirstName(String firstName);
    List<Patient> findByPhone(String phone);
}


