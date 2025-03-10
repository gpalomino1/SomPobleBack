package com.sompoble.cat.service;

import com.sompoble.cat.domain.Empresa;
import java.util.List;
import java.util.Optional;

public interface EmpresaService {
	List<Empresa> getAll();

	Optional<Empresa> getByDni(String dni);

	Empresa save(Empresa empresa);

	void deleteByDni(String dni);

	boolean existsByDni(String dni);
}
