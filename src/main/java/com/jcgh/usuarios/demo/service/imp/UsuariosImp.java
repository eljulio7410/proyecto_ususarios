package com.jcgh.usuarios.demo.service.imp;

import com.jcgh.usuarios.demo.dto.UsuariosDto;
import com.jcgh.usuarios.demo.entity.Usuarios;
import com.jcgh.usuarios.demo.repository.UsuariosRepository;
import com.jcgh.usuarios.demo.service.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuariosImp implements UsuariosService {

    @Autowired
    public UsuariosRepository usuariosRepository;

    @Override
    public Usuarios crearUsuarios(Usuarios usuarios) {
        return usuariosRepository.save(usuarios);
    }

    @Override
    public List<UsuariosDto> listaUsuarios() {
        List<Usuarios> lUsuarios = usuariosRepository.findAll();
        List<UsuariosDto> lUsuariosDto = lUsuarios.stream().map(usu-> new UsuariosDto().toUsuariosDTO(usu)).collect(Collectors.toList());
        return lUsuariosDto;
    }

    @Override
    public Usuarios getId(Long id) throws Exception {
       Optional<Usuarios> usuariop = Optional.of(usuariosRepository.getById(id));
      if (!usuariop.isPresent()){
          throw new Exception(String.valueOf(HttpStatus.NO_CONTENT));
      }
      return usuariop.get();
       // Usuarios gIdUsuarios = usuariosRepository.findById(id).get();
       // UsuariosDto gIdUsuariosDto = new UsuariosDto().toUsuariosDTO(gIdUsuarios);

    }

    @Override
    public Usuarios getUsername(String username) {
        return usuariosRepository.findByUsername(username);
    }

    @Override
    public List<UsuariosDto> getEmail(String email) {
        List<Usuarios> lEUsuarios = usuariosRepository.findByEmail(email);
        List<UsuariosDto> lEUsuariosDto = lEUsuarios.stream().map(UD -> new UsuariosDto().toUsuariosDTO(UD)).collect(Collectors.toList());
        return lEUsuariosDto;
    }

    @Override
    public List<UsuariosDto> getHabilitado(boolean habilitado) {
        List<Usuarios> lHUsuarios = usuariosRepository.findByEstado(habilitado);
        List<UsuariosDto> lHUsuariosDto = lHUsuarios.stream().map(UD -> new UsuariosDto().toUsuariosDTO(UD)).collect(Collectors.toList());
        return lHUsuariosDto;
    }

    @Override
    public Usuarios getNombre(String nombre) {
        return null;
    }

    @Override
    public Usuarios getApellido(String Apellido) {
        return null;
    }

    @Override
    public List<UsuariosDto> getTelefono(Long telefono) {
        List<Usuarios> lTUsuarios = usuariosRepository.findByTelefonoContaining(telefono);
        List<UsuariosDto> lTUsuariosDto = lTUsuarios.stream().map(UD -> new UsuariosDto().toUsuariosDTO(UD)).collect(Collectors.toList());
        return lTUsuariosDto;
    }

    @Override
    public Usuarios actualizarUsuario(Usuarios usuarios, Long id) {
        Usuarios usuariosDto = usuariosRepository.getById(id);
        usuariosDto.setEmail(usuarios.getEmail());
        usuariosDto.setNombre(usuarios.getNombre());
        usuariosDto.setApellido(usuarios.getApellido());
        return usuariosRepository.save(usuarios);
    }

    @Override
    public void eliminarUsuario(Long id) {
        usuariosRepository.deleteById(id);
    }
}
