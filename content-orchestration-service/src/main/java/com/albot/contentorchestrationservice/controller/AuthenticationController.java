package com.albot.contentorchestrationservice.controller;

import com.albot.contentorchestrationservice.model.AuthenticationRequest;
import com.albot.contentorchestrationservice.model.AuthenticationResponse;
import com.albot.contentorchestrationservice.postgres.entity.UserCredentialEntity;
import com.albot.contentorchestrationservice.postgres.repository.UserCredentialRepository;
import com.albot.contentorchestrationservice.util.JwtProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.UUID;

@RestController
@RequestMapping( "/v1/api")
public class AuthenticationController {

    private static final Logger logger = LoggerFactory.getLogger(AuthenticationController.class);

    private AuthenticationManager authenticationManager;
    private JwtProvider jwtProvider;
    private UserDetailsService userDetailsService;
    private UserCredentialRepository userCredentialRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public AuthenticationController(AuthenticationManager authenticationManager, JwtProvider jwtProvider, UserDetailsService userDetailsService, UserCredentialRepository userCredentialRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.authenticationManager = authenticationManager;
        this.jwtProvider = jwtProvider;
        this.userDetailsService = userDetailsService;
        this.userCredentialRepository = userCredentialRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
            );
        } catch (DisabledException e) {
            logger.error("Given User disabled : {}", e.getMessage());
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            logger.error("Incorrect username or password : {}", e.getMessage());
            throw new Exception("Incorrect username or password", e);
        }
        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());
        final String jwt = jwtProvider.generateToken(userDetails);
        UserCredentialEntity userCredentialEntity = userCredentialRepository.getByUserName(authenticationRequest.getUsername());
        userCredentialEntity.setId(userCredentialEntity.getId());
        userCredentialEntity.setUserName(authenticationRequest.getUsername());
        userCredentialEntity.setEncryptedPassword(bCryptPasswordEncoder.encode(authenticationRequest.getPassword()));
        userCredentialRepository.save(userCredentialEntity);
        return ResponseEntity.ok(new AuthenticationResponse(jwt, "Bearer", HttpStatus.OK.value()));
    }
}
