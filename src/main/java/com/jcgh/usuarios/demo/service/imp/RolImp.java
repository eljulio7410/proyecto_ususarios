package com.jcgh.usuarios.demo.service.imp;

import com.jcgh.usuarios.demo.entity.Rol;
import com.jcgh.usuarios.demo.repository.RolRepository;
import com.jcgh.usuarios.demo.service.RolService;
import org.springframework.stereotype.Service;

@Service
public class RolImp implements RolService {

    public RolRepository rolRepository;

    @Override
    public Rol crearRol(Rol rol) {
        return rolRepository.save(rol);
    }

    @Override
    public Rol getId(Long id) {
        return rolRepository.findById(id).get();
    }

    @Override
    public Rol actualizarRol(Rol rol) {
        return rolRepository.save(rol);
    }

    @Override
    public void eliminarRol(Long id) {
        rolRepository.deleteById(id);
    }
}
