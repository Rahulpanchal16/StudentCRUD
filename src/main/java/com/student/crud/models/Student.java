package com.student.crud.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Students")
public class Student {
    @Id
    @Column(name ="student_id")
    private String studentId;  //Will generate a random id instead of auto generating
    private String name;
    private String email;
    private Long contactNo;
    private String address;
    private Integer rollNo;
    private String grade;
}
