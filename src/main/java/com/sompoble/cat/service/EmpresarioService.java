package com.sompoble.cat.service;

import com.sompoble.cat.domain.Empresario;
import java.util.List;
import java.util.Optional;

public interface EmpresarioService {
	List<Empresario> getAll();

	Optional<Empresario> getById(Long id);

	Empresario save(Empresario empresario);

	void delete(Long id);

	boolean existsById(Long id);

	Optional<Empresario> getByDni(String dni);

	void deleteByDni(String dni);

	boolean existsByDni(String dni);


}