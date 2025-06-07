package com.congreso.backend.service;

import com.congreso.backend.model.SystemUser;

public interface PasswordResetTokenS {
    String createToken(SystemUser user);

    SystemUser verifyToken(String token);
}
