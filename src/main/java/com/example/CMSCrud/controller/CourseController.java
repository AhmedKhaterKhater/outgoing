package com.example.CMSCrud.controller;

import com.example.CMSCrud.DTO.CoursesDTO;
import com.example.CMSCrud.model.Course;
import com.example.CMSCrud.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/courses")
    public List<Course> allCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("/getNameAndCost")
    public List<CoursesDTO> getSomeCourseData() {
        return courseService.getNameAndCost();
    }
}
