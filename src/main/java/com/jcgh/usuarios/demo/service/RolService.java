package com.jcgh.usuarios.demo.service;

import com.jcgh.usuarios.demo.entity.Rol;

public interface RolService {

    public Rol crearRol(Rol rol);

    public Rol getId(Long id);

    public Rol actualizarRol(Rol rol);

    public void eliminarRol (Long id);
}
