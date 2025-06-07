package com.congreso.backend.service;

public interface EmailServiceS {
    void sendPasswordResetToken(String email, String token);
}
