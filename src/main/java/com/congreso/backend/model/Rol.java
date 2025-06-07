package com.congreso.backend.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Rol {
    private Integer id;
    private String name;
    private String description;
    private Boolean status;
    private String roleSecurity;

}
