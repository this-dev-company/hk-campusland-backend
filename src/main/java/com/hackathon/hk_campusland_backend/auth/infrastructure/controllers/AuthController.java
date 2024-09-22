package com.hackathon.hk_campusland_backend.auth.infrastructure.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hackathon.hk_campusland_backend.auth.domain.dto.AuthResponse;
import com.hackathon.hk_campusland_backend.auth.domain.dto.LoginRequest;
import com.hackathon.hk_campusland_backend.auth.domain.dto.RegisterRequest;
import com.hackathon.hk_campusland_backend.auth.infrastructure.adapters.AuthAdapter;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthAdapter authAdapter;

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request){
        return ResponseEntity.ok(authAdapter.login(request));
    }

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request){
        return ResponseEntity.ok(authAdapter.register(request));
    }
}
