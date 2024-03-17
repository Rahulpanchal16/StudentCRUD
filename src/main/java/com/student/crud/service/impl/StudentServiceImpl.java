package com.student.crud.service.impl;

import com.student.crud.dto.StudentDto;
import com.student.crud.exceptions.ResourceNotFoundException;
import com.student.crud.models.Student;
import com.student.crud.repos.StudentRepo;
import com.student.crud.service.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepo studRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public StudentDto createStudent(StudentDto studentDto) {
        String randomStudentId = UUID.randomUUID().toString();
        Student student = modelMapper.map(studentDto, Student.class);
        student.setStudentId(randomStudentId);
        Student savedStudent = this.studRepo.save(student);
        return modelMapper.map(savedStudent, StudentDto.class);
    }

    @Override
    public StudentDto getStudentById(String studId) {
        Student studentById = studRepo.findById(studId).orElseThrow(() -> new ResourceNotFoundException("Student", "id", studId));
        return modelMapper.map(studentById, StudentDto.class);
    }

    @Override
    public List<StudentDto> getAllStudents() {
        List<StudentDto> allStudents = this.studRepo.findAll().stream()
                .map(student -> this.modelMapper.map(student, StudentDto.class)).collect(Collectors.toList());
        return allStudents;
    }

    @Override
    public void deleteStudent(String studId) {
        Student studentById = this.studRepo.findById(studId)
                .orElseThrow(() -> new ResourceNotFoundException("Student", "id", studId));
        this.studRepo.delete(studentById);
    }

    @Override
    public StudentDto updateStudent(StudentDto studDto, String studId) {
        Student newStudentData = this.modelMapper.map(studDto, Student.class);
        Student studentById = this.studRepo.findById(studId)
                .orElseThrow(() -> new ResourceNotFoundException("Student", "id", studId));
        studentById.setName(newStudentData.getName());
        studentById.setEmail(newStudentData.getEmail());
        studentById.setAddress(newStudentData.getAddress());
        studentById.setContactNo(newStudentData.getContactNo());
        studentById.setGrade(newStudentData.getGrade());
        studentById.setRollNo(newStudentData.getRollNo());
        Student updatedStud = this.studRepo.save(studentById);
        return this.modelMapper.map(updatedStud, StudentDto.class);
    }
}
