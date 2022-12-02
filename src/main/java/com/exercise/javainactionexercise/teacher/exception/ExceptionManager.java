//package com.exercise.javainactionexercise.teacher.exception;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//
//@RestControllerAdvice
//public class ExceptionManager {
//    @ExceptionHandler(RuntimeException.class)
//    public ResponseEntity<?> rentimeExceptionHandler(RuntimeException e) {
//        // RuntimeException이 나면 Controller대신 이곳에서 리턴을 해줍니다.
//        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                .body(e.getMessage());
//        // INTERNAL_SERVER_ERROR를 리턴하고 ResponseBody에 e.getMessage()를 추가해서 보냅니다.
//    }
//}
