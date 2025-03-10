package com.sompoble.cat.service.impl;

import com.sompoble.cat.domain.Empresario;
import com.sompoble.cat.repository.EmpresarioRepository;
import com.sompoble.cat.service.EmpresarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EmpresaServiceImpl implements EmpresarioService {

    @Autowired
    private EmpresarioRepository empresarioRepository;

    @Override
    public List<Empresario> getAll() {
        return empresarioRepository.findAll();
    }

    @Override
    public Optional<Empresario> getByDni(String dni) {
        return empresarioRepository.findByDni(dni);
    }

    @Override
    public Empresario save(Empresario empresario) {
        return empresarioRepository.save(empresario);
    }

    @Override
    public void deleteByDni(String dni) {
        empresarioRepository.deleteByDni(dni);
    }

    @Override
    public boolean existsByDni(String dni) {
        return empresarioRepository.existsByDni(dni);
    }

	@Override
	public Optional<Empresario> getById(Long id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean existsById(Long id) {
		// TODO Auto-generated method stub
		return false;
	}
}

