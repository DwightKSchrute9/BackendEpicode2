package com.example.GestionePrenotazioniTavoloStellato.controllers;

import com.example.GestionePrenotazioniTavoloStellato.model.User;
import com.example.GestionePrenotazioniTavoloStellato.payload.ApiResponse;
import com.example.GestionePrenotazioniTavoloStellato.payload.JwtAuthenticationResponse;
import com.example.GestionePrenotazioniTavoloStellato.payload.LoginRequest;
import com.example.GestionePrenotazioniTavoloStellato.payload.UpdatePasswordRequest;
import com.example.GestionePrenotazioniTavoloStellato.payload.UserRequest;
import com.example.GestionePrenotazioniTavoloStellato.security.JwtTokenProvider;
import com.example.GestionePrenotazioniTavoloStellato.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider tokenProvider;

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody UserRequest signUpRequest) {
        if (userService.existsByUsername(signUpRequest.getUsername())) {
            return ResponseEntity.badRequest().body(new ApiResponse(false, "Username already taken"));
        }

        if (userService.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity.badRequest().body(new ApiResponse(false, "Email already in use"));
        }

        // Create new user's account
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(signUpRequest.getPassword());
        User user = new User(signUpRequest.getUsername(), signUpRequest.getEmail(), encodedPassword,
                signUpRequest.getFirstName(), signUpRequest.getLastName(), signUpRequest.getPhoneNumber());

        userService.registerUser(user);

        URI location = URI.create(String.format("/api/users/%s", user.getUsername()));

        return ResponseEntity.created(location).body(new ApiResponse(true, "User registered successfully"));
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsernameOrEmail(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = tokenProvider.generateToken(authentication);
        return ResponseEntity.ok(new JwtAuthenticationResponse(jwt));
    }

    @PutMapping("/{id}/updatePassword")
    public ResponseEntity<?> updatePassword(@PathVariable("id") Long userId, @RequestBody UpdatePasswordRequest updatePasswordRequest) {
        User user = userService.getUserById(userId);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        if (!passwordEncoder.matches(updatePasswordRequest.getOldPassword(), user.getPassword())) {
            return ResponseEntity.badRequest().body(new ApiResponse(false, "Incorrect old password"));
        }

        String encodedNewPassword = passwordEncoder.encode(updatePasswordRequest.getNewPassword());
        user.setPassword(encodedNewPassword);
        userService.updateUser(user);

        return ResponseEntity.ok(new ApiResponse(true, "Password updated successfully"));
    }
}
