package com.example.EPIC.ENERGY.SERVICES.service;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.EPIC.ENERGY.SERVICES.model.Ruolo;
import com.example.EPIC.ENERGY.SERVICES.model.Utente;
import com.example.EPIC.ENERGY.SERVICES.util.JwtUtils;

@Service
public class AuthService implements UserDetailsService {
    
    @Autowired
    private UtenteService utenteService;
    
    @Autowired
    private JwtUtils jwtUtils;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Utente utente = utenteService.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Utente non trovato con username: " + username));
        
        GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + ((Utente) utente.getRuolo()).name());
        UserDetails userDetails = new User(utente.getUsername(), utente.getPassword(), Collections.singletonList(authority));
        
        return userDetails;
    }
    
    public String generateToken(UserDetails userDetails) {
        return jwtUtils.generateToken(userDetails);
    }
    
    public boolean validateToken(String token) {
        return jwtUtils.validateToken(token);
    }
    
    public String getUsernameFromToken(String token) {
        return jwtUtils.getUsernameFromToken(token);
    }
    
    public Ruolo getRuoloFromToken(String token) {
        return jwtUtils.getRuoloFromToken(token);
    }

}