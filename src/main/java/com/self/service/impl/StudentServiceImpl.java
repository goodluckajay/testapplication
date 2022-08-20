package com.self.service.impl;

import com.self.model.Student;
import com.self.model.StudentDetailRequest;
import com.self.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class StudentServiceImpl implements StudentService {

    private Map<String, Student> map;

    @Override
    public Student createUser(StudentDetailRequest studentDetailRequest) {

        if (map == null){
            map = new HashMap<>();
        }
        String studentId = UUID.randomUUID().toString();

        Student student = new Student();

        student.setFirstName(studentDetailRequest.getFirstName());
        student.setLastName(studentDetailRequest.getLastName());
        student.setEmial(studentDetailRequest.getEmial());
        student.setId(studentId);

        return student;

    }
}
