package com.jcgh.usuarios.demo.controller;

import com.jcgh.usuarios.demo.dto.UsuariosDto;
import com.jcgh.usuarios.demo.entity.Usuarios;
import com.jcgh.usuarios.demo.service.UsuariosService;
import com.jcgh.usuarios.demo.util.RequestUsuario;
import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
@Slf4j
@RestController
@RequestMapping("/usuarios")
public class UsuariosController {

    private final UsuariosService usuariosService;

   // private final GestionMapper gestionMapper;

    @Autowired
    public UsuariosController(UsuariosService usuariosService) {
        this.usuariosService = usuariosService;
      //  this.gestionMapper = gestionMapper;
    }

    @PostMapping("/crear")
    public Usuarios crearUsuario(@RequestBody Usuarios usuarios){
        return usuariosService.crearUsuarios(usuarios);
    }

    @GetMapping
    public List<UsuariosDto> listarUsuarios(){
        return usuariosService.listaUsuarios();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> traerPorId(@PathVariable Long id) throws Exception {
        try {
            Usuarios gIdUsuarios = usuariosService.getId(id);
            UsuariosDto gIdUsuariosDto = new UsuariosDto().toUsuariosDTO(gIdUsuarios);
            return new  ResponseEntity<>(gIdUsuariosDto, HttpStatus.OK);
        }catch (Exception e){
            String mensajeError = "Error con la consulta por ID: " + e.getMessage();
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(e.getMessage());

        }

    }

    @GetMapping("/buscarnombre/{username}")
    public ResponseEntity<?> traerPorUsername(@PathVariable String username) throws Exception{
        try {
            Usuarios gUsUsuario = usuariosService.getUsername(username);
            UsuariosDto gUsUsuarioDto = new UsuariosDto().toUsuariosDTO(gUsUsuario);
            return new ResponseEntity<>(gUsUsuarioDto, HttpStatus.OK);

        } catch (Exception e) {
            String mensajeError = "Error al procesar la solicitud: " + e.getMessage();
            return new ResponseEntity<>(mensajeError, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/buscartelefono/{telefono}")
    public ResponseEntity<?> traerPorTelefono(@PathVariable Long telefono) throws Exception{
        try {
            List<UsuariosDto> usuarioEncontrados = usuariosService.getTelefono(telefono);
            return new ResponseEntity<>(usuarioEncontrados, HttpStatus.OK);
        } catch (Exception e) {
            String mensajeError = "Error al procesar la solicitud: " + e.getMessage();
            return new ResponseEntity<>(mensajeError, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/buscaremail/{email}")
    public List<UsuariosDto> traerPorEmail(@PathVariable String email){
        return  usuariosService.getEmail(email);
    }

    @GetMapping("/buscarestado/{habilitado}")
    public List<UsuariosDto> traerPorEstado(@PathVariable boolean habilitado){
        return usuariosService.getHabilitado(habilitado);
    }

    @PutMapping("/actualizar/{id}")
    public UsuariosDto actualizarUsuarios(@RequestBody Usuarios usuarios,@PathVariable Long id) throws Exception {
       Usuarios user = usuariosService.actualizarUsuario(usuarios, id);
       UsuariosDto usuariosDto = new UsuariosDto().toUsuariosDTO(user);
        return usuariosDto;
    }
    @DeleteMapping("/eliminar/{id}")
    public void eliminarPorId(@PathVariable Long id){
         usuariosService.eliminarUsuario(id);
    }
}
