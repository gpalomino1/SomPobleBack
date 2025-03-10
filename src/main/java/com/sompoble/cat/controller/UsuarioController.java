package com.sompoble.cat.controller;

import com.sompoble.cat.domain.Usuario;
import com.sompoble.cat.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;


    public static class UsuarioRequest {
        private Usuario usuario;
        private String dni;
        private String nombre;
        private String apellidos;
        private String email;
        private String telefono;

        // Getters y Setters
        public Usuario getUsuario() {
            return usuario;
        }
        public void setUsuario(Usuario usuario) {
            this.usuario = usuario;
        }
        public String getDni() {
            return dni;
        }
        public void setDni(String dni) {
            this.dni = dni;
        }
        public String getNombre() {
            return nombre;
        }
        public void setNombre(String nombre) {
            this.nombre = nombre;
        }
        public String getApellidos() {
            return apellidos;
        }
        public void setApellidos(String apellidos) {
            this.apellidos = apellidos;
        }
        public String getEmail() {
            return email;
        }
        public void setEmail(String email) {
            this.email = email;
        }
        public String getTelefono() {
            return telefono;
        }
        public void setTelefono(String telefono) {
            this.telefono = telefono;
        }
    }

    // Endpoint para crear un nuevo Usuario con datos adicionales
    @PostMapping
    public ResponseEntity<Void> addUsuario(@RequestBody UsuarioRequest request) {
        usuarioService.addUsuario(
                request.getUsuario(),
                request.getDni(),
                request.getNombre(),
                request.getApellidos(),
                request.getEmail(),
                request.getTelefono()
        );
        return ResponseEntity.ok().build();
    }

    // Endpoint para actualizar un Usuario. Se espera que el objeto Usuario no incluya el id, que se asigna desde la URL.
    @PutMapping("/{id}")
    public ResponseEntity<Void> updateUsuario(@PathVariable Long id, @RequestBody Usuario usuario) {
        usuario.setId(id);
        usuarioService.updateUsuario(usuario);
        return ResponseEntity.ok().build();
    }

    // Endpoint para buscar un Usuario por su nombre de usuario
    @GetMapping("/find")
    public ResponseEntity<Usuario> findByNombreUsuario(@RequestParam String nombreUsuario) {
        Usuario usuario = usuarioService.findByNombreUsuario(nombreUsuario);
        if (usuario == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(usuario);
    }
}
