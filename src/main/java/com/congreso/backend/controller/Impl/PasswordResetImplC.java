package com.congreso.backend.controller.Impl;

import com.congreso.backend.model.SystemUser;
import com.congreso.backend.service.Impl.EmailService;
import com.congreso.backend.service.PasswordResetTokenS;
import com.congreso.backend.service.SystemsUserS;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@CrossOrigin(origins = "http://localhost:4200", methods = { GET, POST, PUT, DELETE }, allowedHeaders = { "Content-Type", "Authorization" })
@RestController
@RequestMapping("/reset/")
@RequiredArgsConstructor
public class PasswordResetImplC {
    private final SystemsUserS systemsUserS;
    private final EmailService emailService;
    private final PasswordResetTokenS tokenService;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("password/change")
    public ResponseEntity<String> changePassword2(
            @RequestParam String username,
            @RequestParam String newPassword) {
        systemsUserS.updateChangePassword(username, passwordEncoder.encode(newPassword));  //  update(user);
        return ResponseEntity.ok("Contraseña actualizada exitosamente");
    }

    /*@PostMapping("password-reset/request")
    public ResponseEntity<String> requestPasswordReset(@RequestParam String email) {
        SystemUser user = systemsUserS.findSystemUserByEmail(email);
        if (user == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no encontrado");
        }
        String token = tokenService.createToken(user);
        emailService.sendPasswordResetToken(email, token);
        return ResponseEntity.ok("Código de recuperación enviado al correo electrónico");
    }*/

    /*@PostMapping("password-reset/verify")
    public ResponseEntity<String> verifyPasswordResetToken(@RequestParam String token) {
        SystemUser user = tokenService.verifyToken(token);
        if (user == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Token inválido o expirado");
        }
        return ResponseEntity.ok("Código verificado. Proceda a cambiar su contraseña.");
    }*/

    /*@PostMapping("password-reset/change")
    public ResponseEntity<String> changePassword(
            @RequestParam String token,
            @RequestParam String newPassword) {
        SystemUser user = tokenService.verifyToken(token);
        SystemUser userRecovery = systemsUserS.findById(user.getId());
        if (user == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Token inválido o expirado");
        }
        user.setId(userRecovery.getId());
        user.setAlias(userRecovery.getUsername());
        user.setEmail(userRecovery.getEmail());
        user.setUsername(userRecovery.getUsername());
        user.setCell(userRecovery.getCell());
        user.setIsEnabled(true);
        user.setAccountNoExpired(true);
        user.setAccountNoLocked(true);
        user.setCredentialNoExpired(true);
        user.setIdCity(userRecovery.getIdCity());
        user.setIdPerson(userRecovery.getIdPerson());
        user.setPassword(passwordEncoder.encode(newPassword));
        user.setCodeCell(null);
        user.setDateStartVerification(null);
        user.setDateEndVerification(null);
        systemsUserS.update(user);
        return ResponseEntity.ok("Contraseña actualizada exitosamente");
    }*/
}
