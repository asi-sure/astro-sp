package com.congreso.backend.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PersonsDto {
    private Long id;
    private String usuario;
    private String cedula;
    private String name;
    private String firstName;
    private String secondName;
    private String email;
    private String telephone;
    private String gender;
    private String photo;
    private Date dateBirth;
    private Boolean status;
}
