package com.sompoble.cat.repository;

import com.sompoble.cat.domain.Cliente;

public interface ClienteRepository {
    
    Cliente findByDNI(String dni);
    
    void updateCliente(Cliente cliente);
    
    void addCliente(Cliente cliente);
}