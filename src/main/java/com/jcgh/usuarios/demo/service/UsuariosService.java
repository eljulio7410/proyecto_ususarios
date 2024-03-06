package com.jcgh.usuarios.demo.service;

import com.jcgh.usuarios.demo.entity.Usuarios;

import java.util.List;

public interface UsuariosService {

    public Usuarios crearUsuarios(Usuarios usuarios);

    public List<Usuarios> listaUsuarios();

    public Usuarios getId(Long id);

    public Usuarios getUsername(String username);

    public List<Usuarios> getEmail(String email);

    public List<Usuarios> getHabilitado(boolean habilitado);

    public Usuarios getNombre(String nombre);

    public Usuarios getApellido(String Apellido);

    public List<Usuarios> getTelefono(Long telefono);

    public Usuarios actualizarUsuario(Usuarios usuarios);

    public void eliminarUsuario(Long id);
}
