package com.self.service;

import com.self.model.Student;
import com.self.model.StudentDetailRequest;
import org.springframework.web.bind.annotation.RequestBody;

public interface StudentService {

    public Student createUser(@RequestBody StudentDetailRequest studentDetailRequest);
}
