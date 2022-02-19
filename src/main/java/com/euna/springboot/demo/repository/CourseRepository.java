package com.euna.springboot.demo.repository;

import com.euna.springboot.demo.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface CourseRepository extends JpaRepository<Course, BigInteger> {
}
