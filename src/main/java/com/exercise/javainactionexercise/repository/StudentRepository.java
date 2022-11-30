package com.exercise.javainactionexercise.repository;

import com.exercise.javainactionexercise.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, String> {
}
