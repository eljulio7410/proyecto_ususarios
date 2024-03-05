package com.jcgh.usuarios.demo.service.imp;

import com.jcgh.usuarios.demo.entity.Usuarios;
import com.jcgh.usuarios.demo.repository.UsuariosRepository;
import com.jcgh.usuarios.demo.service.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UsuariosImp implements UsuariosService {

    @Autowired
    public UsuariosRepository usuariosRepository;

    @Override
    public Usuarios crearUsuarios(Usuarios usuarios) {
        return usuariosRepository.save(usuarios);
    }

    @Override
    public List<Usuarios> listaUsuarios() {
        return usuariosRepository.findAll();
    }

    @Override
    public Usuarios getId(Long id) {
        return usuariosRepository.findById(id).get();
    }

    @Override
    public Usuarios actualizarUsuario(Usuarios usuarios) {
        return usuariosRepository.save(usuarios);
    }

    @Override
    public void eliminarUsuario(Long id) {
        usuariosRepository.deleteById(id);
    }
}
