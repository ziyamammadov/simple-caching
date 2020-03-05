package com.azericard.simplecaching.service;

import com.azericard.simplecaching.entity.Student;
import com.azericard.simplecaching.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    Logger logger = LoggerFactory.getLogger(StudentService.class);

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    //  if @Cacheable method has no argument then it uses SimpleKey.EMPTY as key generator
    //  if @Cacheable method has only one argument then it uses argument as key generator
    //  If @Cacheable method has more than one argument is used, then an instance of SimpleKey composed of all arguments is used as key
    //  key word inside of @Cacheable is used to specify key of cache

    @CachePut(value = "allStudents", key = "#student.id")
    public Student save(Student student) {
        logger.info("save method of service called");
        return studentRepository.save(student);
    }

    @CacheEvict(value = "allStudents", key = "#student.id")
    public Student delete(Student student) {
        logger.info("delete method of service called");
        return studentRepository.delete(student);
    }

    @Cacheable(value = "allStudents", unless = "#result == null" ,key = "#id")
    public Student getStudentById(String id) throws InterruptedException {
        logger.info("getStudentById method of service called");
        Thread.sleep(2000);
        Student student = studentRepository.getById(Long.parseLong(id));
        return student;
    }

    @Cacheable(value = "allStudents", unless = "#result == null")
    public Map<Long, Student> getAll() throws InterruptedException {
        logger.info("getAll method of service called");
        Thread.sleep(2000);
        return studentRepository.getAll();
    }

    @CacheEvict(value = "allStudents", key = "#result.id")
    public Student update(Student student) {
        logger.info("update method of service called");
        return studentRepository.update(student);
    }
}
