package com.jcgh.usuarios.demo.controller;


import com.jcgh.usuarios.demo.entity.Rol;
import com.jcgh.usuarios.demo.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rol")
public class RolController {

    private final RolService rolService;

    @Autowired
    public RolController(RolService rolService) {
        this.rolService = rolService;
    }

    @PostMapping("/crear")
    public Rol crearRol(@RequestBody Rol rol){
        return rolService.crearRol(rol);
    }

    @GetMapping("/{id}")
    public Rol traerPorId(@PathVariable Long id){
        return rolService.getId(id);
    }

    @PutMapping("/actualizar")
    public Rol actualizarRol(@RequestBody Rol rol){
        return rolService.actualizarRol(rol);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminarPorId(@PathVariable Long id){
        rolService.eliminarRol(id);
    }
}
