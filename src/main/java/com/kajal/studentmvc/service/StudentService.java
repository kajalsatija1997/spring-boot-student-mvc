package com.kajal.studentmvc.service;

import com.kajal.studentmvc.model.Student;
import java.util.List;

public interface StudentService {
    List<Student> getAll();
    void save(Student student);
    Student getById(int id);
    void update(Student student);
    void delete(int id);
} 