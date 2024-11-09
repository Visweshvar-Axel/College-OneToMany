package com.onetomany.CollegeOneToMany.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.onetomany.CollegeOneToMany.entity.College;
import com.onetomany.CollegeOneToMany.entity.Student;
import com.onetomany.CollegeOneToMany.service.CollegeService;

@RestController
public class CollegeController {
    @Autowired
    CollegeService collegeService;

    @PostMapping("/colleges")
    public ResponseEntity<College> createCollege(@RequestBody College college) {
        College res = collegeService.createCollege(college);
        return ResponseEntity.ok().body(res);
    }

    @PostMapping("/colleges/{collegeId}/students")
    public ResponseEntity<Student> createStudentByCollegeId(@PathVariable Long collegeId,
            @RequestBody Student student) {
        Student res = collegeService.createStudent(collegeId, student);
        return ResponseEntity.ok().body(res);
    }

    @GetMapping("/colleges")
    public ResponseEntity<List<College>> getAllCollege() {
        List<College> res = collegeService.getAllCollege();
        return ResponseEntity.ok().body(res);
    }

    @GetMapping("/colleges/students")
    public ResponseEntity<List<Student>> getStudentByCollegeName(@RequestParam String collegeName) throws Exception {
        College college = collegeService.getStudentByColelgeName(collegeName);
        if (college == null) {
            throw new Exception();
        }
        List<Student> res = college.getStudents();
        return ResponseEntity.ok().body(res);
    }
}
