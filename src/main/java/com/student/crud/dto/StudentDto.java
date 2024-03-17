package com.student.crud.dto;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StudentDto {
    private String studentId;
    private String name;
    private String email;
    private Long contactNo;
    private String address;
    private Integer rollNo;
    private String grade;
}
