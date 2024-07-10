package org.hms.project.hms.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hms.project.hms.entity.MedicalHistory;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class PatientDto {
    private long id;
    private String firstName;
    private String lastName;
    private String gender;
    private Date birthDate;
    private int age;
    private String bloodGroup;
    private String phone;
    private String email;
    private String address;
    private Double height;
    private Double weight;
    private String medicalReason;
}
