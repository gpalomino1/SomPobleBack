package com.sompoble.cat.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.sompoble.cat.domain.Cliente;
import java.util.List;



public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Cliente findByEmail(String email);
    
    Cliente findByDNI(String dni);
    
    void updateCliente(Cliente cliente);
    
    void addCliente(Cliente cliente);

    List<Cliente> findAll();
    
    boolean existsById(Long id);

    void deleteById(Long id);
    
    boolean existsByDni(String dni);

    void deleteByDni(String dni);
    
    boolean existsByEmail(String email);
  
    
}