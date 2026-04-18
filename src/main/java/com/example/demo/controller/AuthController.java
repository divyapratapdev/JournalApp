package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.JwtService;
import com.example.demo.service.UserDetailsServiceImp;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final UserDetailsServiceImp userDetailsService;
    private final UserService userService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> credentials) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        credentials.get("userName"),
                        credentials.get("password")
                )
        );
        UserDetails userDetails = userDetailsService.loadUserByUsername(credentials.get("userName"));
        String token = jwtService.generateToken(userDetails);
        return ResponseEntity.ok(Map.of("token", token));
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        boolean created = userService.saveNewUser(user);
        if (created) {
            return ResponseEntity.ok(Map.of("message", "User registered successfully"));
        }
        return ResponseEntity.badRequest().body(Map.of("error", "Registration failed. Username may already exist."));
    }
}
