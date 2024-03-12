package com.jcgh.usuarios.demo.dto;

import com.jcgh.usuarios.demo.entity.Usuarios;
import com.jcgh.usuarios.demo.repository.UsuariosRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuariosDto {
    private String username;
    private String nombre;
    private Long telefono;
    private String perfil;

   public UsuariosDto  toUsuariosDTO(Usuarios usuarios){
        UsuariosDto usuariosDto = new UsuariosDto();
        usuariosDto.setUsername(usuarios.getUsername());
        usuariosDto.setNombre(usuarios.getNombre());
        usuariosDto.setPerfil(usuarios.getPerfil());
        usuariosDto.setTelefono(usuarios.getTelefono());
        return usuariosDto;
    }



}



