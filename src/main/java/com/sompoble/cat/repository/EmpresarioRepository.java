package com.sompoble.cat.repository;

import java.util.List;
import java.util.Optional;

import com.sompoble.cat.domain.Empresario;

public interface EmpresarioRepository {
    
    Empresario findByDNI(String dni);
    
    void updateEmpresario (Empresario empresario);
    
    void addEmpresario(Empresario empresario);

	List<Empresario> findAll();

	Empresario save(Empresario empresario);

	void deleteById1(Long id);

	boolean existsById(Long id);

	void deleteById(Long id);

	Optional<Empresario> findByDni(String dni);

	void deleteByDni(String dni);

	boolean existsByDni(String dni);
}