package com.exercise.javainactionexercise.controller;

import com.exercise.javainactionexercise.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/teachers")
public class TeacherContorller {

    @Autowired // private final 이 붙어있고 생성자가 있으면 오토와이어가 자동으로들어감, 안적어도 됨
    private final TeacherService teacherService;

    public TeacherContorller(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    // TeacherService teacherService = new TeacherService();
    // 이렇게 쓰면 계속 controller가 호출될때마다 객체가 생성돼서 메모리에 문제가 생김



}
