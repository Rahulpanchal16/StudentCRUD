package com.student.crud.service;

import com.student.crud.dto.StudentDto;

import java.util.List;

public interface StudentService {

    StudentDto createStudent(StudentDto studentDto);

    StudentDto getStudentById(String studId);

    List<StudentDto> getAllStudents();

    void deleteStudent(String studId);

    StudentDto updateStudent(StudentDto studDto, String studId);
}
