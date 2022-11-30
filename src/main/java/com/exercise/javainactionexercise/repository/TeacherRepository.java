package com.exercise.javainactionexercise.repository;

import com.exercise.javainactionexercise.domain.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, String> {
}
