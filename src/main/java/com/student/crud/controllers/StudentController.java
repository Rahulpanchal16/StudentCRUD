package com.student.crud.controllers;

import com.student.crud.dto.StudentDto;
import com.student.crud.service.StudentService;
import com.student.crud.utils.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/student")
public class StudentController {

    @Autowired
    private StudentService studService;

    @PostMapping(path = "/create")
    public ResponseEntity<StudentDto> createStudent(@RequestBody StudentDto studDto) {
        StudentDto createdStudent = this.studService.createStudent(studDto);
        return new ResponseEntity<>(createdStudent, HttpStatus.CREATED);
    }

    @GetMapping(path = "/get/{studId}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable String studId) {
        StudentDto studentById = this.studService.getStudentById(studId);
        return new ResponseEntity<>(studentById, HttpStatus.OK);
    }

    @GetMapping(path = "/get")
    public ResponseEntity<List<StudentDto>> getAllStudents() {
        List<StudentDto> allStudents = this.studService.getAllStudents();
        return new ResponseEntity<>(allStudents, HttpStatus.OK);
    }

    @DeleteMapping(path = "/delete/{studId}")
    public ResponseEntity<ApiResponse> deleteStudent(@PathVariable String studId) {
        this.studService.deleteStudent(studId);
        ApiResponse response = ApiResponse.builder()
                .message("Student with id " + studId + " deleted")
                .success(true)
                .statusCode(HttpStatus.NO_CONTENT)
                .build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping(path = "/update/{studId}")
    public ResponseEntity<StudentDto> updateStudent(@RequestBody StudentDto studentDto, @PathVariable String studId) {
        StudentDto updatedStudent = this.studService.updateStudent(studentDto, studId);
        return new ResponseEntity<>(updatedStudent, HttpStatus.OK);
    }
}
