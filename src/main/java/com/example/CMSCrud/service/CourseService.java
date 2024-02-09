package com.example.CMSCrud.service;

import com.example.CMSCrud.DTO.CoursesDTO;
import com.example.CMSCrud.model.Course;
import com.example.CMSCrud.model.Student;
import com.example.CMSCrud.repository.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepo courseRepo;

    public List<Course> getAllCourses() {
        return courseRepo.findAll();
    }

    public List<CoursesDTO> getNameAndCost() {
        List<Course> courseList = courseRepo.findAll();
        List<CoursesDTO> coursesDTOS = new ArrayList<>();
        for(int i=0; i<courseList.size(); i++) {
            CoursesDTO dto = new CoursesDTO();
            dto.setCost(courseList.get(i).getCost());
            dto.setName(courseList.get(i).getName());
            coursesDTOS.add(dto);
        }
        return coursesDTOS;
    }
}
