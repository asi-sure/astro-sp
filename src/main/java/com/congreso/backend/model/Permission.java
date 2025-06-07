package com.congreso.backend.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Permission {
    private Long id;
    private String name;
    private String description;
    private Boolean status;
}
