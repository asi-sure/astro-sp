package com.congreso.backend.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "priv_menu")
public class Priv_MenuE {
    @Id
    private Long id_priv_menu;

    private int id_mesub;
    private int id_priv;

    @ManyToOne
    @MapsId("id_priv")
    @JoinColumn(name = "id_priv")
    @JsonManagedReference
    PrivilegiosE privilegios;

    @ManyToOne
    @MapsId("id_mesub")
    @JoinColumn(name = "id_mesub")
    @JsonManagedReference
    MesubE mesub;

}
