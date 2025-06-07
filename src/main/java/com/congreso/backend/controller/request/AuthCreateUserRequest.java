package com.congreso.backend.controller.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record AuthCreateUserRequest(@NotBlank String username, @NotBlank String password,
                                    @NotBlank String email,
                                    @NotBlank String alias,
                                    @NotBlank String cell,
                                    String codeCell,
                                    LocalDateTime dateStartVerification,
                                    LocalDateTime dateEndVerification,
                                    @NotNull Integer idCity,
                                    @Valid AuthCreateRoleRequest rolerequest,
                                    @NotBlank String ci,
                                    @NotBlank String firstName,
                                    @NotBlank String secondName,
                                    @NotBlank String name,
                                    @NotBlank String gender) {
}
