package com.basic.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

@Entity
@Table(name="student_table",uniqueConstraints={
        @UniqueConstraint(columnNames = {"stu_name", "stu_marks"})
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long stuRoll;

    @Column(name="stu_name", length=10, nullable=false)
    private String stuName;

    @Column(name="stu_city")
    private String stuCity;

    @Column(nullable=false, unique=true)
    private float stuMarks;

    @CreationTimestamp
    private LocalDate stuDoa;


    @CreationTimestamp
    private LocalTime stuTime;

    @CreationTimestamp
    private LocalDateTime stuDateTime;



}
