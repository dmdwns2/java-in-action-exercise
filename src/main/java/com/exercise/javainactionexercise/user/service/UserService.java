package com.exercise.javainactionexercise.user.service;

import com.exercise.javainactionexercise.user.config.EncoderConfig;
import com.exercise.javainactionexercise.user.dto.User;
import com.exercise.javainactionexercise.user.exception.AppException;
import com.exercise.javainactionexercise.user.exception.ErrorCode;
import com.exercise.javainactionexercise.user.respository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public String join(String userName, String password) {

        // username 중복체크 중복체크를 하려면 DB에 갔다와야 함
        userRepository.findByUserName(userName)
                .ifPresent(user -> {
                    throw new AppException(ErrorCode.USERNAME_DUPLICATED, userName + "는 이미 존재합니다.");
                });
        //save 중복 아니면 저장
        User user = User.builder()
                .userName(userName)
                .password(bCryptPasswordEncoder.encode(password))
                .build();
        userRepository.save(user);


        return "SUCCESS";
    }

    public String login(String userName, String password) {

        // name 없음
        User selectedUser = userRepository.findByUserName(userName)
                .orElseThrow(() -> new AppException(ErrorCode.USERNAME_NOT_FOUND, userName + "이(가) 없습니다."));


        // password 틀림
        if(!bCryptPasswordEncoder.matches(selectedUser.getPassword(), password)) {
            throw new AppException(ErrorCode.INVALID_PASSWORD,"패스워드를 잘못 입력 했습니다.");
        }

        return "token 리턴";
    }
}
