package com.smartsolutions.eschool;

import com.smartsolutions.eschool.util.ResourceObject;
import com.smartsolutions.eschool.util.SingleResourceSuccessResponseObject;
import com.smartsolutions.eschool.util.jwt.JwtUtil;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:4200") // allow Vite dev server
public class AuthController {

    private final JwtUtil jwtUtil;
    private final UserDetailsService userDetailsService;
    private final AuthenticationManager authenticationManager;


    @Autowired
    public AuthController(JwtUtil jwtUtil, UserDetailsService userDetailsService, AuthenticationManager authenticationManager) {
        this.jwtUtil = jwtUtil;
        this.userDetailsService = userDetailsService;
        this.authenticationManager = authenticationManager;
    }


    @PostMapping("/generateToken")
    public SingleResourceSuccessResponseObject signIn(@Valid @RequestBody HashMap<String, String> request) {
        String email = request.get("email");
        String password = request.get("password");

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(email, password)
            );
        } catch (Exception e) {
            e.printStackTrace(); // log actual reason
            throw new RuntimeException("Login failed: " + e.getMessage());
        }

        UserDetails userDetails = userDetailsService.loadUserByUsername(email);
        String token = jwtUtil.generateToken(userDetails);

        return new SingleResourceSuccessResponseObject(
                new ResourceObject(
                        "auth-123",
                        "jwt",
                        Map.of("token", token))
        );
    }

}