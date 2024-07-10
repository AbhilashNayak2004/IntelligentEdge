package org.hms.project.hms.repository;

import jakarta.transaction.Transactional;
import org.hms.project.hms.entity.MedicalHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface MedicalHistoryRepository extends JpaRepository<MedicalHistory, Long> {
    List<MedicalHistory> findByPatientId(Long patientId);

    List<MedicalHistory> findByPatientFirstName(String firstName);

    List<MedicalHistory> findByUpdatedDate(Date updatedDate);

    @Modifying
    @Transactional
    @Query("UPDATE MedicalHistory mh SET mh.isActive = false WHERE mh.patient.id = :patientId AND mh.diseaseId = :diseaseId AND mh.isActive = true")
    void deactivatePreviousEntries(Long patientId, Integer diseaseId);

    List<MedicalHistory> findByIsActive(Boolean isActive);

    List<MedicalHistory> findByPatientIdAndIsActive(Long patientId, Boolean isActive);

    List<MedicalHistory> findByDiseaseIdAndIsActive(Integer diseaseId, Boolean isActive);

    List<MedicalHistory> findByPatientIdAndDiseaseId(Long patientId, Integer diseaseId);
}
