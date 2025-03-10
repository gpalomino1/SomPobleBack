package com.sompoble.cat.controller;

import com.sompoble.cat.domain.Empresario;
import com.sompoble.cat.service.EmpresarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/empresarios")
public class EmpresarioController {

    @Autowired
    private EmpresarioService empresarioService;

    @GetMapping
    public List<Empresario> getAll() {
        return empresarioService.getAll();
    }

    @GetMapping("/{dni}")
    public ResponseEntity<Empresario> getByDni(@PathVariable String dni) {
        Optional<Empresario> empresario = empresarioService.getByDni(dni);
        return empresario.map(ResponseEntity::ok)
                          .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Empresario create(@RequestBody Empresario empresario) {
        return empresarioService.save(empresario);
    }

    @PutMapping("/{dni}")
    public ResponseEntity<Empresario> update(@PathVariable String dni, @RequestBody Empresario empresario) {
        if (!empresarioService.existsByDni(dni)) {
            return ResponseEntity.notFound().build();
        }
        empresario.setDni(dni);
        return ResponseEntity.ok(empresarioService.save(empresario));
    }

    @DeleteMapping("/{dni}")
    public ResponseEntity<Void> delete(@PathVariable String dni) {
        if (!empresarioService.existsByDni(dni)) {
            return ResponseEntity.notFound().build();
        }
        empresarioService.deleteByDni(dni);
        return ResponseEntity.noContent().build();
    }
}
