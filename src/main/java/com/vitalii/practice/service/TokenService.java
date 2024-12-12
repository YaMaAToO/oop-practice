package com.vitalii.practice.service;

import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.Date;

@Service
public class TokenService {

    private static final String ADMIN_LOGIN = "admin"; // Замініть на значення з application.properties
    private static final long TOKEN_EXPIRATION_TIME = 5 * 60 * 1000; // 5 хвилин у мілісекундах

    public String generateToken(String login) {
        long expirationTime = new Date().getTime() + TOKEN_EXPIRATION_TIME;
        String token = login + ":" + expirationTime;
        return Base64.getEncoder().encodeToString(token.getBytes());
    }

    public boolean isValidToken(String token) {
        try {
            String decodedToken = new String(Base64.getDecoder().decode(token));
            String[] tokenParts = decodedToken.split(":");
            if (tokenParts.length != 2) {
                return false;
            }

            String login = tokenParts[0];
            long expirationTime = Long.parseLong(tokenParts[1]);

            return ADMIN_LOGIN.equals(login) && expirationTime > new Date().getTime();
        } catch (Exception e) {
            return false;
        }
    }
}

