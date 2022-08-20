package com.self.controller;

import com.self.model.Student;
import com.self.model.StudentDetailRequest;
import com.self.model.StudentDetailRequestUpdate;
import com.self.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import javax.xml.ws.Response;

import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.UUID;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.APPLICATION_XML_VALUE;

@RestController
@RequestMapping(path = "/users")
public class UserController {

    private Map<String, Student> map;

    @Autowired
    private StudentService studentService;

    @PostMapping(consumes =
            {
                APPLICATION_XML_VALUE,
                APPLICATION_JSON_VALUE
            },
            produces =
            {
                APPLICATION_XML_VALUE,
                APPLICATION_JSON_VALUE
            }
    )
    public ResponseEntity<Student> createUser(@Valid @RequestBody StudentDetailRequest studentDetailRequest) {

        return new ResponseEntity<Student>(studentService.createUser(studentDetailRequest), HttpStatus.OK);
    }

    /*@GetMapping
    public String getAllUsers(){    // either this method or getFilteredUsers() can be used

        return "get all users";
    }*/

    @GetMapping(path = "/{id}",
            produces = {
                    APPLICATION_XML_VALUE,
                    APPLICATION_JSON_VALUE
            }
    )
    public ResponseEntity<Student> getSingleUser(@PathVariable String id) {

        if (map.containsKey(id)){
            return new ResponseEntity<Student>(map.get(id), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

    }

    @GetMapping()  // just for knowledge we are using defaultValue and required attributes of @RequestParam annotation
    public String getFilteredUsers(@RequestParam(value = "page", defaultValue = "1") int page,
                                   @RequestParam(value = "limit", defaultValue = "5") int limit,
                                   @RequestParam(value = "sort", required = false) String sort) {
        return "This is the user having page : " + page + " and limit : " + limit + " and sort order is :" + sort;
    }

    @PutMapping(consumes =
            {
                    APPLICATION_XML_VALUE,
                    APPLICATION_JSON_VALUE
            },
            produces =
                    {
                            APPLICATION_XML_VALUE,
                            APPLICATION_JSON_VALUE
                    }
    , path = "/{id}")
    public ResponseEntity<Student> updateUser(@Valid @RequestBody StudentDetailRequestUpdate studentDetailRequestUpdate, @PathVariable String id) {

        Student student = map.get(id);

        student.setFirstName(studentDetailRequestUpdate.getFirstName());
        student.setLastName(studentDetailRequestUpdate.getLastName());

        map.put(id, student);
        return new ResponseEntity<> (student, HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable String id) {

            Student student = map.get(id);
            map.remove(id);

            return ResponseEntity.noContent().build();
    }
}
