package com.congreso.backend.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Person {
    private Long id;

    @NotNull
    @NotBlank
    @Size(max = 12)
    private String ci;

    @NotNull
    @NotBlank
    @Size(max = 100)
    private String firstName;

    @NotNull
    @NotBlank
    @Size(max = 100)
    private String secondName;

    @NonNull
    @NotBlank
    @Size(max = 100, min = 3)
    private String name;

    @NonNull
    @NotBlank
    @Size(max = 3, min = 1)
    private String gender;
    private Boolean status = true;

}
