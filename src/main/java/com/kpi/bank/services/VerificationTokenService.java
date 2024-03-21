package com.kpi.bank.services;

import com.kpi.bank.dto.Response;
import com.kpi.bank.entites.User;
import com.kpi.bank.entites.VerificationToken;
import org.springframework.http.ResponseEntity;

public interface VerificationTokenService {
    void saveUserVerificationToken(User user, String token);
    String validateToken(String token);
    ResponseEntity<Response> verifyEmail(String token);
    VerificationToken generateNewVerificationToken(String oldToken);
}