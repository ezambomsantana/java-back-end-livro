package com.santana.java.back.end.service;

import com.santana.java.back.end.dto.UserDTO;
import com.santana.java.back.end.model.User;
import com.santana.java.back.end.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {


    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @Test
    public void testListAllUsers() {

        List<User> users = new ArrayList<>();

        Mockito.when(userRepository.findAll()).thenReturn(users);

        List<UserDTO> usersReturn = userService.getAll();
        Assertions.assertEquals(0, usersReturn.size());

    }


}
