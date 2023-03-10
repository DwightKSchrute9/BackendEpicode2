package com.example.GestioneDispositivi.security;



import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

    public JwtAuthenticationEntryPoint(UserDetails userDetails, Object object,
			Collection<? extends GrantedAuthority> authorities) {
		// TODO Auto-generated constructor stub
	}

	@Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException authException) throws IOException, ServletException {
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized error: " + authException.getMessage());
    }
    
    // Aggiunta per gestire l'eccezione JwtAuthenticationException
    public void handleJwtAuthenticationException(HttpServletResponse response, Exception e) throws IOException {
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized error: " + e.getMessage());
    }

	public void setDetails(WebAuthenticationDetails buildDetails) {
		// TODO Auto-generated method stub
		
	}
}
