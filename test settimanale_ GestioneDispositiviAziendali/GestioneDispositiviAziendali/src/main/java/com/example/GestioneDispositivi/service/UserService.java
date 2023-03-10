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

	public User updateUser(Long id, User user) {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteUser(Long id) {
		// TODO Auto-generated method stub
		
	}
}

