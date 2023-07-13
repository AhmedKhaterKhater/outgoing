package com.example.CMSCrud.controller;

import com.example.CMSCrud.model.Student;
import com.example.CMSCrud.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService  studentService;

    public List<Student> allStudent() {
        return studentService.getAllStudents();
    }
}
