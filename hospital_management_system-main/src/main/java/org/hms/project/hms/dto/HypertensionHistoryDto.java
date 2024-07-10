package org.hms.project.hms.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class HypertensionHistoryDto {
    private long id;
    private String details;
    private String treatment;
    private long systolic;
    private long diastolic;
    private Date diagnosisDate;

}
