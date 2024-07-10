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

public class DiabetesHistoryDto {
    private long id;
    private String details;
    private String treatment;
    private long fbg;
    private long ppbg;
    private long rbg;
    private Date diagnosisDate;
}
