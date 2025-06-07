package com.congreso.backend.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Team {
    private Integer id;
    private String alias;
    private String description;
    private Boolean status;
}
