package com.congreso.backend.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "inquilinos")
public class InquilinosE {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Campo requerido")
    @NotBlank
    @Size(max = 20, min = 3)
    private String cedula;

    @NotNull(message = "Campo requerido")
    @NotBlank
    @Size(max = 50, min = 3)
    private String nombre;

    @Size(max = 40)
    private String ap;

    @Size(max = 40)
    private String am;

    @Size(max = 100)
    private String direc;

    @Size(max = 20)
    private String celular;

    @Size(max = 200)
    private String ubicacion;

    private boolean estado;

    @OneToMany(mappedBy="inquilino")
    @JsonBackReference
    private List<McontratosE> contratos;

    @OneToOne(mappedBy = "inquilino", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = true)
    @JsonManagedReference
    private Inquilinos_ubicE ubicacion_gps;

    public String datos(){
        String xdato=this.nombre;
        if (this.ap!=null){
          if (!this.ap.trim().equals("")){
              xdato=xdato + " "+this.ap.trim();
          }
        }
        if (this.am!=null){
            if (!this.am.trim().equals("")){
                xdato=xdato + " "+this.am.trim();
            }
        }
        return xdato;
    }
}
