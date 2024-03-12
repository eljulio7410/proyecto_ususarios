package com.jcgh.usuarios.demo.service;

import com.jcgh.usuarios.demo.dto.UsuariosDto;
import com.jcgh.usuarios.demo.entity.Usuarios;

import java.util.List;

public interface UsuariosService {

    public Usuarios crearUsuarios(Usuarios usuarios);

    public List<UsuariosDto> listaUsuarios();

    public Usuarios getId(Long id) throws Exception;

    public Usuarios getUsername(String username);

    public List<UsuariosDto> getEmail(String email);

    public List<UsuariosDto> getHabilitado(boolean habilitado);

    public Usuarios getNombre(String nombre);

    public Usuarios getApellido(String Apellido);

    public List<UsuariosDto> getTelefono(Long telefono);

    public Usuarios actualizarUsuario(Usuarios usuarios, Long id);

    public void eliminarUsuario(Long id);
}
