package io.maddennis.authjwt.service;

import io.maddennis.authjwt.payload.LoginRequest;
import io.maddennis.authjwt.payload.SignupRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public interface AuthService {

    ResponseEntity<?> registerUser(SignupRequest signUpRequest);
    ResponseEntity<?> authenticateUser(LoginRequest loginRequest);
}
