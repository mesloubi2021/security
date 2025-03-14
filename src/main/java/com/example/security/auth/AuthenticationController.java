package com.example.security.auth;

import com.example.security.auth.dto.AuthenticationRequestDTO;
import com.example.security.auth.dto.AuthenticationResponseDTO;
import com.example.security.auth.dto.RegisterRequestDTO;
import com.example.security.services.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final Logger logger = LoggerFactory.getLogger(AuthenticationController.class);
    @Autowired
    private final AuthenticationService services;
    

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponseDTO> register(
            @RequestBody RegisterRequestDTO request
    ) {
        logger.info("The request information" + request);
        return ResponseEntity.ok(services.register(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponseDTO> register(
            @RequestBody AuthenticationRequestDTO request
    ) {
        return ResponseEntity.ok(services.authenticate(request));
    }

}
