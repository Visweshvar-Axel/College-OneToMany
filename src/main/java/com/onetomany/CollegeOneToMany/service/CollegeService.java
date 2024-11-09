package com.onetomany.CollegeOneToMany.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onetomany.CollegeOneToMany.entity.College;
import com.onetomany.CollegeOneToMany.entity.Student;
import com.onetomany.CollegeOneToMany.repository.CollegeRepo;
import com.onetomany.CollegeOneToMany.repository.StudentRepo;

@Service
public class CollegeService {
    @Autowired
    CollegeRepo collegeRepo;
    @Autowired
    StudentRepo studentRepo;

    public College createCollege(College college) {
        College res = collegeRepo.save(college);
        return res;
    }

    public Student createStudent(Long collegeId, Student student) {
        Optional<College> college = collegeRepo.findById(collegeId);
        if (college.isPresent()) {
            student.setCollege(college.get());
            college.get().addStudents(student);
            return studentRepo.save(student);
        }
        return null;
    }

    public List<College> getAllCollege() {
        List<College> res = collegeRepo.findAll();
        return res;
    }

    public College getStudentByColelgeName(String collegeName) {
        College res = collegeRepo.findByName(collegeName);
        return res;
    }
}
