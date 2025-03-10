package com.sompoble.cat.controller;

import com.sompoble.cat.domain.Empresa;
import com.sompoble.cat.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/empresas")
public class EmpresaController {

    @Autowired
    private EmpresaService empresaService;

    // Obtener todas las empresas
    @GetMapping
    public List<Empresa> getAll() {
        return empresaService.findAll();
    }

    // Consultar por CIF
    @GetMapping("/{cif}")
    public ResponseEntity<Empresa> getByCif(@PathVariable String cif) {
        Empresa empresa = empresaService.findByCif(cif);
        return empresa != null ? ResponseEntity.ok(empresa) : ResponseEntity.notFound().build();
    }

    // Crear una nueva empresa
    @PostMapping
    public ResponseEntity<Void> create(@RequestBody Empresa empresa) {
        if (empresaService.existsByCif(empresa.getCif())) {
            return ResponseEntity.status(409).build();  // Retorna HTTP 409 si ya existe
        }

        empresaService.addEmpresario(empresa);
        return ResponseEntity.created(null).build();  // Creación exitosa con código 201
    }

    // Actualizar una empresa
    @PutMapping("/{cif}")
    public ResponseEntity<Empresa> update(@PathVariable String cif, @RequestBody Empresa empresa) {
        Empresa existingEmpresa = empresaService.findByCif(cif);

        if (existingEmpresa == null) {
            return ResponseEntity.notFound().build();  // Si no existe, retornar 404
        }

        existingEmpresa.setNombre(empresa.getNombre());
        existingEmpresa.setDireccion(empresa.getDireccion());

        empresaService.updateEmpresa(existingEmpresa);
        return ResponseEntity.ok(existingEmpresa);  // Devolver la empresa actualizada
    }

    // Eliminar una empresa por CIF
    @DeleteMapping("/{cif}")
    public ResponseEntity<Void> delete(@PathVariable String cif) {
        if (!empresaService.existsByCif(cif)) {
            return ResponseEntity.notFound().build();  // Si no existe, retornar 404
        }
        empresaService.deleteByCif(cif);
        return ResponseEntity.noContent().build();  // Retorna código 204 para eliminación exitosa
    }
}