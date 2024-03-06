package com.jcgh.usuarios.demo.controller;

import com.jcgh.usuarios.demo.entity.Usuarios;
import com.jcgh.usuarios.demo.service.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuariosController {

    private final UsuariosService usuariosService;

    @Autowired
    public UsuariosController(UsuariosService usuariosService) {
        this.usuariosService = usuariosService;
    }

    @PostMapping("/crear")
    public Usuarios crearUsuario(@RequestBody Usuarios usuarios){
        return usuariosService.crearUsuarios(usuarios);
    }

    @GetMapping
    public List<Usuarios> listarUsuarios(){
        return usuariosService.listaUsuarios();
    }

    @GetMapping("/{id}")
    public Usuarios traerPorId(@PathVariable Long id){
        return usuariosService.getId(id);
    }

    @GetMapping("/buscarnombre/{username}")
    public Usuarios traerPorUsername(@PathVariable String username){
        return usuariosService.getUsername(username);
    }
    @GetMapping("/buscartelefono/{telefono}")
    public List<Usuarios> traerPorTelefono(@PathVariable Long telefono){
        return usuariosService.getTelefono(telefono);
    }

    @GetMapping("/buscaremail/{email}")
    public List<Usuarios> traerPorEmail(@PathVariable String email){
        return  usuariosService.getEmail(email);
    }

    @GetMapping("/buscarestado/{habilitado}")
    public List<Usuarios> traerPorEstado(@PathVariable boolean habilitado){
        return usuariosService.getHabilitado(habilitado);
    }

    @PutMapping("/actualizar")
    public Usuarios actualizarUsuarios(@RequestBody Usuarios usuarios){
        return usuariosService.actualizarUsuario(usuarios);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminarPorId(@PathVariable Long id){
         usuariosService.eliminarUsuario(id);
    }
}
