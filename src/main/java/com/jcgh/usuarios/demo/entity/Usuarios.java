package com.jcgh.usuarios.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Usuarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    private String nombre;

    private String apellido;

    private Long telefono;

    private boolean habilitado = true;

    private String perfil;

    @ManyToOne
    @JoinColumn(name = "rol-id")
    private Rol rol;

}
