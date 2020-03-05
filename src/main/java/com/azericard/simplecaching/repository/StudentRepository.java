package com.azericard.simplecaching.repository;

import com.azericard.simplecaching.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class StudentRepository {

    private static final Map<Long, Student> STUDENT_MAP = new HashMap<>();

    public Student save(Student student) {
        return  STUDENT_MAP.put(student.getId(), student);
    }

    public Student update(Student student) {
        return STUDENT_MAP.put(student.getId(), student);
    }

    public Map<Long, Student> getAll() {
        return STUDENT_MAP;
    }

    public Student getById(long id) {
        return STUDENT_MAP.get(id);
    }

    public Student delete(Student student) {
        return STUDENT_MAP.remove(student.getId());
    }
}
