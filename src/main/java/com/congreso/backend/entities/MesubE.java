package com.congreso.backend.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "mesub")
public class MesubE {
    @Id
    private Long id_mesub;
    private int id_menu;
    private int id_subm;

    @OneToMany(mappedBy = "mesub")
    @JsonBackReference
    Set<Priv_MenuE> priv_menu;

    @ManyToOne
    @MapsId("id_menu")
    @JoinColumn(name = "id_menu")
    @JsonManagedReference
    MenuE menu;
}
