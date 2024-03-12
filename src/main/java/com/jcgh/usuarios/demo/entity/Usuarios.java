package com.jcgh.usuarios.demo.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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

    private String email;

    private String nombre;

    private String apellido;

    private Long telefono;

    private boolean habilitado = true;

    private String perfil;

    @ManyToOne
    @JoinColumn(name = "rol")
    private Rol rol;



}
