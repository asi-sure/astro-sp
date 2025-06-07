package com.congreso.backend.model;

import lombok.*;

import java.time.LocalDateTime;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder  //mine
public class SystemUser {
    private Long id;
    private String alias;
    private String email;
    private String username;
    private String password;
    private String cell;
    private String codeCell;
    private LocalDateTime dateStartVerification;
    private LocalDateTime dateEndVerification;
    private Boolean status;
    private Boolean isEnabled;
    private Boolean accountNoExpired;
    private Boolean accountNoLocked;
    private Boolean credentialNoExpired;
    private Integer idCity;
    private Long idPerson;

}
