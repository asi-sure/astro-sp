package com.congreso.backend.model;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder  //mine
public class SystemUsers {
    private Long idPerson;
    private String username;
    private String password;
    private Boolean status;
    private LocalDateTime dateStartVerification;
    private LocalDateTime dateEndVerification;
    private Boolean isEnabled;
    private Boolean accountNoExpired;
    private Boolean accountNoLocked;
    private Boolean credentialNoExpired;
}
