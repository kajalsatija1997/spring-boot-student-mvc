package com.kajal.studentmvc.controller;

import com.kajal.studentmvc.model.Student;
import com.kajal.studentmvc.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;

import java.util.List;

@Controller
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/")
    public String home() {
        return "redirect:/students";
    }

    @GetMapping("/students")
    public String listStudents(Model model) {
        List<Student> students = studentService.getAll();
        model.addAttribute("students", students);
        return "list";
    }

    @GetMapping("/students/add")
    public String showAddForm(Model model) {
        model.addAttribute("student", new Student());
        return "add";
    }

    @PostMapping("/students/add")
    public String addStudent(@Valid @ModelAttribute Student student, BindingResult result) {
        if (result.hasErrors()) {
            return "add";
        }
        studentService.save(student);
        return "redirect:/students";
    }

    @GetMapping("/students/view/{id}")
    public String viewStudent(@PathVariable int id, Model model) {
        model.addAttribute("student", studentService.getById(id));
        return "view";
    }

    @GetMapping("/students/edit/{id}")
    public String showEditForm(@PathVariable int id, Model model) {
        model.addAttribute("student", studentService.getById(id));
        return "edit";
    }

    @PostMapping("/students/edit")
    public String updateStudent(@Valid @ModelAttribute Student student, BindingResult result) {
        if (result.hasErrors()) {
            return "edit";
        }
        studentService.update(student);
        return "redirect:/students";
    }

    @GetMapping("/students/delete/{id}")
    public String deleteStudent(@PathVariable int id) {
        studentService.delete(id);
        return "redirect:/students";
    }

    // REST Endpoint
    @ResponseBody
    @GetMapping("/api/students")
    public List<Student> apiStudents() {
        return studentService.getAll();
    }
} 