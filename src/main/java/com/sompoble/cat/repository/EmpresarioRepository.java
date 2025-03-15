package com.sompoble.cat.repository;
import com.sompoble.cat.domain.Empresario;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmpresarioRepository extends JpaRepository<Empresario, Long> {
    Empresario findByEmail(String email);
    
    Empresario findByDNI(String dni);
    
    void updateEmpresario (Empresario empresario);
    
    void addEmpresario(Empresario empresario);

    List<Empresario> findAll();
    
    boolean existsById(Long id);

    void deleteById(Long id);
    
    boolean existsByDni(String dni);

    void deleteByDni(String dni);
    
    boolean existsByEmail(String email);
}