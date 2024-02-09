package com.example.CMSCrud.service;

import com.example.CMSCrud.DTO.StudentDTO;
import com.example.CMSCrud.model.Student;
import com.example.CMSCrud.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepo studentRepo;

    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }

    public List<StudentDTO> getNameAndAge() {
        List<Student> stuList = studentRepo.findAll();
        List<StudentDTO> studentDTOS = new ArrayList<>();

        for(int i=0; i<stuList.size(); i++) {
            StudentDTO dto = new StudentDTO();
            dto.setName(stuList.get(i).getName());
            dto.setAge(stuList.get(i).getAge());
            studentDTOS.add(dto);
        }
        return studentDTOS;

    }
}
