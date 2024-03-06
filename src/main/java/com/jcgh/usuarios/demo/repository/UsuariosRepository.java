package com.jcgh.usuarios.demo.repository;

import com.jcgh.usuarios.demo.entity.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UsuariosRepository extends JpaRepository<Usuarios,Long> {

    Usuarios findByUsername(String username);

    @Query("SELECT u FROM Usuarios u WHERE CAST(u.telefono AS string) LIKE %:telefono%")
    List<Usuarios> findByTelefonoContaining(@Param("telefono") Long telefono);

    @Query("SELECT u FROM Usuarios u WHERE u.email LIKE %:email%")
    List<Usuarios> findByEmail(@Param("email") String email);

    @Query("SELECT u FROM Usuarios u WHERE u.habilitado =:estado")
    List<Usuarios> findByEstado(@Param("estado") Boolean estado);
}
