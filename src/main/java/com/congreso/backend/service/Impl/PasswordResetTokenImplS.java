package com.congreso.backend.service.Impl;

import com.congreso.backend.model.SystemUser;
import com.congreso.backend.repository.PasswordResetTokenR;
import com.congreso.backend.service.PasswordResetTokenS;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class PasswordResetTokenImplS implements PasswordResetTokenS {
    private final PasswordResetTokenR passwordResetTokenR;

    @Override
    public String createToken(SystemUser user) {
        Random random = new Random();
        String token = String.valueOf(1000 + random.nextInt(9000));
        LocalDateTime now = LocalDateTime.now();
        passwordResetTokenR.updateCodeCell(token, now, now.plusMinutes(5), user.getId());
        return token;
    }

    @Override
    public SystemUser verifyToken(String token) {
        SystemUser user = passwordResetTokenR.findByCodeCell(token);
        if (user == null || user.getDateEndVerification().isBefore(LocalDateTime.now())) {
            return null;
        }
        return user;
    }
}
