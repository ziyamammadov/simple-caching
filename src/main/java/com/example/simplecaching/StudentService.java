package com.example.simplecaching;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Cacheable("student")
    public Student getStudentByID(String id) {
        try {
            System.out.println("Going to sleep 5s....");
            Thread.sleep(1000 * 5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new Student(id, "Max", "A");

    }
}
