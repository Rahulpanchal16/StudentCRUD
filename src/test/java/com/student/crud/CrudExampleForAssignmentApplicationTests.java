package com.student.crud;

import com.student.crud.dto.StudentDto;
import com.student.crud.service.StudentService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Random;
import java.util.UUID;

@SpringBootTest
class CrudExampleForAssignmentApplicationTests {

    @Autowired
    private StudentService studentService;
    @Autowired
    private ModelMapper mapper;

    @Test
    void contextLoads() {
    }

    @Test
    @Disabled
    void generateRandomUsers() {
        long min = 9800000000L;
        long max = 9999999999L;
        Random random = new Random();
        for (int i = 0; i < 100; i++) {

            long contactNumber = min + ((long) (random.nextDouble() * (max - min)));
            StudentDto testData = StudentDto.builder()
                    .studentId(UUID.randomUUID().toString())
                    .name("student" + i)
                    .address("Test address")
                    .grade(Integer.toString(i))
                    .email("student" + i + "@mail.com")
                    .contactNo(contactNumber)
                    .rollNo(i)
                    .build();
            this.studentService.createStudent(testData);
        }
    }
}
