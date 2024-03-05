package com.jcgh.usuarios.demo.repository;

import com.jcgh.usuarios.demo.entity.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuariosRepository extends JpaRepository<Usuarios,Long> {
}
