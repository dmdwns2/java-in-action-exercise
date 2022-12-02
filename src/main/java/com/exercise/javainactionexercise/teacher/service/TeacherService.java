//package com.exercise.javainactionexercise.teacher.service;
//
//import com.exercise.javainactionexercise.teacher.domain.Teacher;
//import com.exercise.javainactionexercise.teacher.repository.TeacherRepository;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
//@Service
//public class TeacherService {
//
//    private final TeacherRepository teacherRepository;
//
//    public TeacherService(TeacherRepository teacherRepository) {
//        this.teacherRepository = teacherRepository;
//    }
//
//
//    public String world() {
//        // exception을 발생 시킴 (개발자가)
//        Optional<Teacher> teacherOptional = Optional.empty();
//        Teacher teacher = teacherOptional.orElseThrow(()->new RuntimeException("해당 teacher가 없습니다."));
//        //
//
//        // teacher를 받아와서 이름을 꺼내고 싶다.
//        return "world";
//    }
//
//}
