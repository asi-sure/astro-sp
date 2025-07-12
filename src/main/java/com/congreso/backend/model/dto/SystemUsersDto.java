package com.congreso.backend.model.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SystemUsersDto {
    private Long idPerson;
    private String username;
    private String password;
}
