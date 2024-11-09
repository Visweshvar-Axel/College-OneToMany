package com.onetomany.CollegeOneToMany.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.onetomany.CollegeOneToMany.entity.College;

@Repository
public interface CollegeRepo extends JpaRepository<College, Long> {
    @Query("SELECT C FROM College C WHERE C.name = :name")
    public College findByName(@Param("name") String collegeName);
}
