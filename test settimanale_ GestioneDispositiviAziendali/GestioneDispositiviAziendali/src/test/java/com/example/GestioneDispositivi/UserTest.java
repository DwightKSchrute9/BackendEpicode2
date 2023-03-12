package com.example.GestioneDispositivi;



import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.GestioneDispositivi.entity.User;

public class UserTest {
    private User user;

    @BeforeEach
    public void setUp() {
        user = new User();
    }

    @Test
    public void testGetId() {
        Long idValue = 4L;
        user.setId(idValue);
        Assertions.assertEquals(idValue, user.getId());
    }

    @Test
    public void testGetUsername() {
        String usernameValue = "johndoe";
        user.setUsername(usernameValue);
        Assertions.assertEquals(usernameValue, user.getUsername());
    }

    @Test
    public void testGetFirstName() {
        String firstNameValue = "John";
        user.setFirstName(firstNameValue);
        Assertions.assertEquals(firstNameValue, user.getFirstName());
    }

    @Test
    public void testGetLastName() {
        String lastNameValue = "Doe";
        user.setLastName(lastNameValue);
        Assertions.assertEquals(lastNameValue, user.getLastName());
    }

    @Test
    public void testGetEmail() {
        String emailValue = "johndoe@example.com";
        user.setEmail(emailValue);
        Assertions.assertEquals(emailValue, user.getEmail());
    }
}
