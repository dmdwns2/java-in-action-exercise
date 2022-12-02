package com.exercise.javainactionexercise.user.service;

import com.exercise.javainactionexercise.user.dto.User;
import com.exercise.javainactionexercise.user.respository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String join(String userName, String password){

        // username 중복체크 중복체크를 하려면 DB에 갔다와야 함
        userRepository.findByUserName(userName)
                .ifPresent(user -> {
                    throw new RuntimeException(userName + "는 이미 존재합니다.");
                });
        //save 중복 아니면 저장
        User user = User.builder()
                .userName(userName)
                .password(password)
                .build();
        userRepository.save(user);


        return "SUCCESS";
    }
}
