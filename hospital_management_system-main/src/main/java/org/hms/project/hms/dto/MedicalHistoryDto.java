package org.hms.project.hms.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hms.project.hms.entity.DiabetesHistory;
import org.hms.project.hms.entity.HypertensionHistory;
import org.hms.project.hms.entity.Patient;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class MedicalHistoryDto {
    private long id;
    private int diseaseId;
    private Integer fbg;
    private Integer ppbg;
    private Integer rbg;
    private Integer systolic;
    private Integer diastolic;
    private Boolean isActive;
    private Date updatedDate;
    private Patient patient;
}
