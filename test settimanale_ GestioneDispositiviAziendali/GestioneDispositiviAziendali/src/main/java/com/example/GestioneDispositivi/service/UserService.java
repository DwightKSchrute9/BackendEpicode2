package com.example.GestioneDispositivi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.GestioneDispositivi.entity.User;
import com.example.GestioneDispositivi.entity.UserRole;
import com.example.GestioneDispositivi.repository.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }
    
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    
    public User addUser(User user) {
        user.setRole(UserRole.USER);
        return userRepository.save(user);
    }
    
    public Optional<User> getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User updateUser(Long id, User user) throws Exception {
        User oldUser = userRepository.findById(id)
                .orElseThrow(() -> new Exception("User not found"));

        oldUser.setUsername(user.getUsername());
        oldUser.setId(user.getId());
        oldUser.setPassword(user.getPassword());
        oldUser.setFirstName(user.getFirstName());
        oldUser.setLastName(user.getLastName());
        oldUser.setEmail(user.getEmail());

        return userRepository.save(oldUser);
    }

    public void deleteUser(Long id) throws Exception {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new Exception("User not found"));

        userRepository.delete(user);
    }
}
