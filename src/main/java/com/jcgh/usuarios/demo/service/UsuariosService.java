package com.jcgh.usuarios.demo.service;

import com.jcgh.usuarios.demo.entity.Usuarios;

import java.util.List;

public interface UsuariosService {

    public Usuarios crearUsuarios(Usuarios usuarios);

    public List<Usuarios> listaUsuarios();

    public Usuarios getId(Long id);

    public Usuarios actualizarUsuario(Usuarios usuarios);

    public void eliminarUsuario(Long id);
}
