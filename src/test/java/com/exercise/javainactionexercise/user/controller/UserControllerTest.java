package com.exercise.javainactionexercise.user.controller;

import com.exercise.javainactionexercise.user.dto.UserJoinRequest;
import com.exercise.javainactionexercise.user.exception.AppException;
import com.exercise.javainactionexercise.user.exception.ErrorCode;
import com.exercise.javainactionexercise.user.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest // 목테스트를 할거다.
class UserControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    UserService userService;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    @DisplayName("회원가입 성공")
    void join() throws Exception {

        String userName = "Mbappe";
        String password = "123qwe";

        mockMvc.perform(post("/api/v1/users/join")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsBytes(new UserJoinRequest(userName, password))))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("회원가입 실패 userName 중복")
    void join_fail() throws Exception {

        String userName = "Mbappe";
        String password = "123qwe";

        when(userService.join(any(), any()))
                .thenThrow(new RuntimeException("해당 userID가 중복됩니다."));


        mockMvc.perform(post("/api/v1/users/join")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsBytes(new UserJoinRequest(userName, password))))
                .andDo(print())
                .andExpect(status().isConflict());
    }

    @Test
    @DisplayName("로그인 성공")
    @WithAnonymousUser
    void login_success() throws Exception {

        String userName = "Mbappe";
        String password = "123qwe";

        when(userService.login(any(),any()))
                .thenReturn("token");

        mockMvc.perform(post("/api/v1/users/login")
                        .with(csrf())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsBytes(new UserJoinRequest(userName, password))))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("로그인 실패 - userName 없음 ")
    @WithAnonymousUser
    void login_fail1() throws Exception {

        String userName = "Mbappe";
        String password = "123qwe";

        when(userService.login(any(),any()))
                .thenReturn(new AppException(ErrorCode.USERNAME_DUPLICATED, "") {
                });

        mockMvc.perform(post("/api/v1/users/login")
                        .with(csrf())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsBytes(new UserJoinRequest(userName, password))))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("로그인 실패 - userName 틀림 ")
    @WithAnonymousUser
    void login_fail2() throws Exception {

        String userName = "Mbappe";
        String password = "123qwe";

        when(userService.login(any(),any()))
                .thenReturn(new AppException(ErrorCode.USERNAME_DUPLICATED, "") {
                });

        mockMvc.perform(post("/api/v1/users/login")
                        .with(csrf())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsBytes(new UserJoinRequest(userName, password))))
                .andDo(print())
                .andExpect(status().isConflict());
    }
}