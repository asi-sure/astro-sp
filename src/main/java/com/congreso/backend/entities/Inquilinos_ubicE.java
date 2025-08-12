package com.congreso.backend.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "inquilinos_ubic")
public class Inquilinos_ubicE {
    @Id
    private Long id;

    @Column(name = "longitude", nullable = false)
    private double longitude;

    @Column(name = "latitude", nullable = false)
    private double latitude;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    @JsonBackReference
    private InquilinosE inquilino;

}
