package com.smartsolutions.eschool.util.jwt;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
@Slf4j
//This class is responsible for handling authentication failures and responding with a customized error message when an unauthenticated user attempts to access a secured resource
//AuthenticationEntryPoint interface, which is part of Spring Security. The AuthenticationEntryPoint is invoked when an unauthenticated user tries to access a secured resource, and it's responsible for handling the authentication failure.
public class AuthEntryPointJwt implements AuthenticationEntryPoint {

    private AuthEntryPointJwt() {
    }


    @Override
    //The commence method is a callback method provided by the AuthenticationEntryPoint interface, and it is called when an authentication failure occurs.
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {

        log.error("Unauthorized error: {}", authException.getMessage());

        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

        final Map<String, Object> body = new HashMap<>();
        body.put("status", HttpServletResponse.SC_UNAUTHORIZED);
        body.put("error", "Unauthorized");
        body.put("message", authException.getMessage());
        body.put("path", request.getServletPath());
        final ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(response.getOutputStream(), body);
    }
}

