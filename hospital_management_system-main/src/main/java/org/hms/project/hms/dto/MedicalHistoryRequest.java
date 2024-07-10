package org.hms.project.hms.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;
import org.hms.project.hms.entity.Patient;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class MedicalHistoryRequest {
    private long id;
    private int diseaseId;
    private int fbg;
    private int ppbg;
    private int rbg;
    private int systolic;
    private int diastolic;
    private Boolean isActive;
    private Date updatedDate;
    @NotNull
    private long patientId;
}
