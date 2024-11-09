package com.onetomany.CollegeOneToMany.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class College {
    @Id
    @GeneratedValue
    Long collegeId;
    String name;
    @OneToMany(mappedBy = "college")
    List<Student> students = new ArrayList<>();

    public College() {
    }

    public College(Long collegeId, String name, List<Student> students) {
        this.collegeId = collegeId;
        this.name = name;
        this.students = students;
    }

    public Long getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(Long collegeId) {
        this.collegeId = collegeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void addStudents(Student students) {
        this.students.add(students);
    }

}
