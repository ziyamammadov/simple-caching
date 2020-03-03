package com.example.simplecaching;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/student/{id}")
    public Student findStudentById(@PathVariable String id) {
        System.out.println("Searching by ID  : " + id);
        return studentService.getStudentByID(id);
    }
}
