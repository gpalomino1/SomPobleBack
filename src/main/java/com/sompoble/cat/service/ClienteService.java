package com.sompoble.cat.service;

import com.sompoble.cat.domain.Cliente;
import java.util.List;
import java.util.Optional;

public interface ClienteService {
	List<Cliente> getAll();

	Optional<Cliente> getByDni(String dni);

	Cliente save(Cliente cliente);

	void deleteByDni(String dni);

	boolean existsByDni(String dni);
}
