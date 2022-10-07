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
        users.add(getUser(1, "User Name", "123"));
        users.add(getUser(2, "User Name 2", "321"));

        Mockito.when(userRepository.findAll()).thenReturn(users);

        List<UserDTO> usersReturn = userService.getAll();
        Assertions.assertEquals(2, usersReturn.size());

    }

    private User getUser(Integer id, String nome, String cpf) {
        User user = new User();
        user.setId(id);
        user.setNome(nome);
        user.setCpf(cpf);
        return user;
    }


}
