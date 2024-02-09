package com.example.CMSCrud.DTO;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class CoursesDTO {
    private String name;
    private Integer cost;
}
