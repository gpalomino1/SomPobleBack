package com.sompoble.cat.controller;

import com.sompoble.cat.domain.Empresa;
import com.sompoble.cat.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/empresas")
public class EmpresaController {

    @Autowired
    private EmpresaService empresaService;

    @GetMapping
    public List<Empresa> getAll() {
        return empresaService.getAll();
    }

    @GetMapping("/{dni}")
    public ResponseEntity<Empresa> getByDni(@PathVariable String dni) {
        Optional<Empresa> empresa = empresaService.getByDni(dni);
        return empresa.map(ResponseEntity::ok)
                      .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Empresa create(@RequestBody Empresa empresa) {
        return empresaService.save(empresa);
    }

    @PutMapping("/{dni}")
    public ResponseEntity<Empresa> update(@PathVariable String dni, @RequestBody Empresa empresa) {
        if (!empresaService.existsByDni(dni)) {
            return ResponseEntity.notFound().build();
        }
        empresa.setDni(dni);
        return ResponseEntity.ok(empresaService.save(empresa));
    }

    @DeleteMapping("/{dni}")
    public ResponseEntity<Void> delete(@PathVariable String dni) {
        if (!empresaService.existsByDni(dni)) {
            return ResponseEntity.notFound().build();
        }
        empresaService.deleteByDni(dni);
        return ResponseEntity.noContent().build();
    }
}
