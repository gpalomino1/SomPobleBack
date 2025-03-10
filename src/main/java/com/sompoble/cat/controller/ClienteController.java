package com.sompoble.cat.controller;

import com.sompoble.cat.domain.Cliente;
import com.sompoble.cat.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public List<Cliente> getAll() {
        return clienteService.getAll();
    }

    // Consulta por DNI
    @GetMapping("/{dni}")
    public ResponseEntity<Cliente> getByDni(@PathVariable String dni) {
        Optional<Cliente> cliente = clienteService.getByDni(dni);
        return cliente.map(ResponseEntity::ok)
                      .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Cliente create(@RequestBody Cliente cliente) {
        return clienteService.save(cliente);
    }

    // Actualización usando DNI
    @PutMapping("/{dni}")
    public ResponseEntity<Cliente> update(@PathVariable String dni, @RequestBody Cliente cliente) {
        if (!clienteService.existsByDni(dni)) {
            return ResponseEntity.notFound().build();
        }
        // Asegurarse de que el DNI del objeto coincida con el de la URL
        cliente.setDni(dni);
        return ResponseEntity.ok(clienteService.save(cliente));
    }

    // Borrado usando DNI
    @DeleteMapping("/{dni}")
    public ResponseEntity<Void> delete(@PathVariable String dni) {
        if (!clienteService.existsByDni(dni)) {
            return ResponseEntity.notFound().build();
        }
        clienteService.deleteByDni(dni);
        return ResponseEntity.noContent().build();
    }
}

