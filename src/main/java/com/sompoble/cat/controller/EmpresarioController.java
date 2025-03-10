package com.sompoble.cat.controller;

import com.sompoble.cat.domain.Empresario;
import com.sompoble.cat.service.EmpresarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/empresarios")
public class EmpresarioController {

    @Autowired
    private EmpresarioService empresarioService;

    // Obtener todos los empresarios
    @GetMapping
    public List<Empresario> getAll() {
        return empresarioService.findAll();
    }

    // Consultar por DNI
    @GetMapping("/{dni}")
    public ResponseEntity<Empresario> getByDni(@PathVariable String dni) {
        Empresario empresario = empresarioService.findByDNI(dni);
        return empresario != null ? ResponseEntity.ok(empresario) : ResponseEntity.notFound().build();
    }

    // Crear un nuevo empresario
    @PostMapping
    public ResponseEntity<Void> create(@RequestBody Empresario empresario) {
        if (empresarioService.existsByDni(empresario.getDni())) {
            return ResponseEntity.status(409).build();  // Retorna HTTP 409 si ya existe
        }

        empresarioService.addEmpresario(empresario);
        return ResponseEntity.created(null).build();  // Creación exitosa con código 201
    }

    // Actualizar un empresario
    @PutMapping("/{dni}")
    public ResponseEntity<Empresario> update(@PathVariable String dni, @RequestBody Empresario empresario) {
        Empresario existingEmpresario = empresarioService.findByDNI(dni);

        if (existingEmpresario == null) {
            return ResponseEntity.notFound().build();  // Si no existe, retornar 404
        }

        existingEmpresario.setNombre(empresario.getNombre());
        existingEmpresario.setApellidos(empresario.getApellidos());

        empresarioService.updateEmpresario(existingEmpresario);
        return ResponseEntity.ok(existingEmpresario);  // Devolver el empresario actualizado
    }

    // Eliminar un empresario por DNI
    @DeleteMapping("/{dni}")
    public ResponseEntity<Void> delete(@PathVariable String dni) {
        if (!empresarioService.existsByDni(dni)) {
            return ResponseEntity.notFound().build();  // Si no existe, retornar 404
        }
        empresarioService.deleteByDni(dni);
        return ResponseEntity.noContent().build();  // Retorna código 204 para eliminación exitosa
    }
}
