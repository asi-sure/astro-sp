package com.congreso.backend.entities;

import com.congreso.backend.enumeration.Tipo_persons;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "persons")
public class PersonsE {
    @Id
    private Long id;

    private String cedula;

    private String name;

    @Column(name="first_name")
    private String firstName;

    @Column(name="second_name")
    private String secondName;

    private String email;

    private String telephone;

    private String gender;

    private String photo;

    @Column(name="date_birth")
    private Date dateBirth;

    private Boolean status;

    @Enumerated(EnumType.STRING)
    private Tipo_persons tipoper;

    @OneToMany(mappedBy="persona_resp")
    @JsonBackReference
    private List<McontratosE> contratos;

    @OneToMany(mappedBy="persona_resp")
    @JsonBackReference
    private List<MacopladosE> acoplados;

    private String datos(){
        return this.name+" "+this.firstName+" "+this.secondName;
    }
}
