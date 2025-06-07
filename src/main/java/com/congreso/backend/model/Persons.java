package com.congreso.backend.model;


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
public class Persons {

    private Long id;

    @NotNull
    @NotBlank
    @Size(max = 15)
    private String cedula;

    @NotNull
    @NotBlank
    @Size(max = 50, min = 3)
    private String name;

    @NotNull
    @NotBlank
    @Size(max = 100, min = 3)
    private String firstName;

    @Size(max = 50)
    private String secondName;

    @Size(max = 100)
    private String email;

    @Size(max = 20)
    private String gender;

    @Size(max = 20)
    private String telephone;

    @Size(max = 200)
    private String photo;

    private Date dateBirth;

    private Boolean status = true;
}
