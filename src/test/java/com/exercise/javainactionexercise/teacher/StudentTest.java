//package com.exercise.javainactionexercise.teacher;
//
//import com.exercise.javainactionexercise.teacher.domain.Teacher;
//import org.junit.jupiter.api.Test;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//import java.util.function.Predicate;
//import java.util.stream.Collectors;
//
//class StudentTest {
//
//    @Test
//    void name() {
//        List<Teacher> teachers = new ArrayList<>();
//        Teacher kyeongrok = new Teacher("김경록", true, true);
//        Teacher kyeonghwan = new Teacher("고경환", true, false);
//        Teacher sujin = new Teacher("김수진", false, true);
//        Teacher sohyun = new Teacher("강소현", true, true);
//
//        teachers.add(kyeongrok);
//        teachers.add(kyeonghwan);
//        teachers.add(sujin);
//        teachers.add(sohyun);
//
//        // 알고리즘 true이신 분들
//        System.out.println("---알고리즘 true이신 분들--");
//        // DB에서 읽어왔습니다.
//        List<Teacher> likeAlgorithmTeacher = new ArrayList<>();
//        for (int i = 0; i < teachers.size(); i++) {
//            if(teachers.get(i).isLikeAlgorithm()){
//                likeAlgorithmTeacher.add(teachers.get(i));
//            }
//        }
//
//        System.out.println("---SpringBoot이 true이신 분들 map--");
//        List<String> likeSpringBootTeachers = teachers.stream()
//                .filter(teacher -> teacher.isLikeSpringBoot() == true)
//                .map(teacher -> teacher.getName())
//                .collect(Collectors.toList());
//
//        for (String teacherName : likeSpringBootTeachers) {
//            System.out.println(teacherName);
//        }
//
//        Optional<Teacher> optionalTeacher = Optional.of(kyeongrok);
//        optionalTeacher.orElseThrow(()-> new RuntimeException());
//
//        List<String> likeSpringBootTeachers1 = teachers.stream()
//                .filter(item -> item.isLikeSpringBoot() == true)
//                .map(item -> item.getName())
//                .collect(Collectors.toList());
//
//
//    }
//
//    @Test
//    void predicateTest() {
//        // 숫자 num을 넣으면 10보다 큰지 true, false로 리턴 해주는 내장 인터페이스
//        Predicate<Integer> predicate = num -> num > 10;
//        System.out.println(predicate.test(10));
//    }
//
//    @Test
//    void optionalTest() {
//        // DB에서 select되어 값이 있는 상태
//        Optional<Teacher> optionalTeacher = Optional.of(new Teacher("김경록", true, true));
//        Optional<Teacher> emptyTeacher = Optional.empty();
//
//        List<Teacher> teachers = new ArrayList<>();
//        teachers.size(); // --> 값이 없으면 0
//
//
//        // 값이 없는 경우 get
//        Optional<Teacher> emptyTeacher2 = Optional.empty();
//        if(emptyTeacher2.isPresent()) {
//            emptyTeacher2.get();
//            emptyTeacher2.orElseThrow(RuntimeException::new);
//            Teacher teacher1 = emptyTeacher2.orElseThrow(()-> new RuntimeException());
//        }
//
//
//
//        // get
//        Optional<Teacher> optionalTeacher3 = Optional.of(new Teacher("김경록", true, true));
//        Teacher teacher = optionalTeacher3.get(); //값이 있는 경우
//
//
//
//        // 값이 있는 경우 무언가 처리 하고 싶을 때
//        Optional<Teacher> optionalTeacher4 = Optional.of(new Teacher("김경록", true, true));
//        optionalTeacher4.ifPresent(sth -> {
//            throw new RuntimeException(sth.getName());
//            // throw new HospitalReviewAppException(ErrorCode.DUPLICATED_USER_NAME, String.format("UserName:%s", request.getUserName()));
//        });
//
//        // .ofNullable, orElse()
//        Optional<Teacher> optionalTeacher5 = Optional.of(new Teacher(null, true, true));
//        String name = Optional.ofNullable(optionalTeacher5.get().getName()).orElse("이름이 없습니다.");
//        System.out.println(name);
//    }
//
//
//}
//
