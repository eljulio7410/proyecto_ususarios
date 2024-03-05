package com.jcgh.usuarios.demo.repository;

import com.jcgh.usuarios.demo.entity.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolRepository extends JpaRepository<Rol,Long> {
}
