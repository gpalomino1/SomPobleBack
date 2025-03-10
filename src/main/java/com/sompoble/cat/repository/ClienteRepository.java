package com.sompoble.cat.repository;

import java.util.List;
import java.util.Optional;

import com.sompoble.cat.domain.Cliente;

public interface ClienteRepository {
    
    Cliente findByDNI(String dni);
    
    void updateCliente(Cliente cliente);
    
    void addCliente(Cliente cliente);

	List<Cliente> findAll();

	Cliente save(Cliente cliente);

	void deleteById(Long id);

	Optional<Cliente> findByDni(String dni);

	void deleteByDni(String dni);

	boolean existsByDni(String dni);
}