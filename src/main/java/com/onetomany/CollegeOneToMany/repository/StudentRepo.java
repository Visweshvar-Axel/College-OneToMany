package com.onetomany.CollegeOneToMany.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onetomany.CollegeOneToMany.entity.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {

}
