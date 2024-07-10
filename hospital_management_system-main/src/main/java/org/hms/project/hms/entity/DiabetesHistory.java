package org.hms.project.hms.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
@Table(name = "diabetes_history")
public class DiabetesHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "diagnosis_details")
    private String details;

    @Column(name = "treatments")
    private String treatment;

    @Column(name = "fbg")
    private Long fbg;

    @Column(name = "ppbg")
    private Long ppbg;

    @Column(name = "rbg")
    private Long rbg;

    @Column(name = "diagnosis_date")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date diagnosisDate;
}

