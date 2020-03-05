package com.azericard.simplecaching.controller;

import com.azericard.simplecaching.entity.Student;
import com.azericard.simplecaching.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/student")
public class StudentController {
    Logger logger = LoggerFactory.getLogger(StudentController.class);

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @PutMapping("/save")
    public Student save(@RequestBody Student student) {
        logger.info("save method of controller called");
        return studentService.save(student);
    }

    @GetMapping("/all")
    public Map<Long, Student> findAll() throws InterruptedException {
        logger.info("findAll method of controller called");
        return studentService.getAll();
    }


    @GetMapping("/get/{id}")
    public Student findStudentById(@PathVariable long id) throws InterruptedException {
        logger.info("findStudentById method of controller called");
        Student student = studentService.getStudentById(String.valueOf(id));
        return student;
    }

    @DeleteMapping("/delete")
    public Student delete(@RequestBody Student student) {
        logger.info("delete method of controller called");
        return studentService.delete(student);
    }

    @PostMapping("/update")
    public Student update(@RequestBody Student student) {
        logger.info("update method of controller called");
        return studentService.update(student);
    }
}
