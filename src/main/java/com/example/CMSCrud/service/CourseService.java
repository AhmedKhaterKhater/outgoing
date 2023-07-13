package com.example.CMSCrud.service;

import com.example.CMSCrud.model.Course;
import com.example.CMSCrud.model.Student;
import com.example.CMSCrud.repository.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepo courseRepo;

    public List<Course> getAllStudents() {
        return courseRepo.findAll();
    }
}
