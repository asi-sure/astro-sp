package com.congreso.backend.model;

import jakarta.persistence.Id;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Inquilinos_ubic implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private Long id;
    private double latitude;
    private double longitude;
}
