package com.kajal.studentmvc.service;

import com.kajal.studentmvc.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final List<Student> studentList = new ArrayList<>();
    private int idCounter = 1;

    @Override
    public List<Student> getAll() {
        return studentList;
    }

    @Override
    public void save(Student student) {
        student.setId(idCounter++);
        studentList.add(student);
    }

    @Override
    public Student getById(int id) {
        return studentList.stream()
                .filter(s -> s.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public void update(Student updatedStudent) {
        for (int i = 0; i < studentList.size(); i++) {
            Student s = studentList.get(i);
            if (s.getId() == updatedStudent.getId()) {
                studentList.set(i, updatedStudent);
                break;
            }
        }
    }

    @Override
    public void delete(int id) {
        Iterator<Student> iterator = studentList.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getId() == id) {
                iterator.remove();
                break;
            }
        }
    }
} 