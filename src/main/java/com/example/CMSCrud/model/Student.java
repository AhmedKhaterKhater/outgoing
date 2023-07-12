package com.example.CMSCrud.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Student")
public class Student {

    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "age")
    private Long age;

}
