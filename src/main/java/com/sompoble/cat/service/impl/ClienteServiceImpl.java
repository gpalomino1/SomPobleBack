package com.sompoble.cat.service.impl;

import com.sompoble.cat.domain.Cliente;
import com.sompoble.cat.repository.ClienteRepository;
import com.sompoble.cat.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public List<Cliente> getAll() {
        return clienteRepository.findAll();
    }

    @Override
    public Optional<Cliente> getByDni(String dni) {
        return clienteRepository.findByDni(dni);
    }

    @Override
    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public void deleteByDni(String dni) {
        clienteRepository.deleteByDni(dni);
    }

    @Override
    public boolean existsByDni(String dni) {
        return clienteRepository.existsByDni(dni);
    }
}

