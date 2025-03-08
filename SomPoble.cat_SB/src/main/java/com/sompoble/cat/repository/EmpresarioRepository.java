package com.sompoble.cat.repository;

import com.sompoble.cat.domain.Empresario;

public interface EmpresarioRepository {
    
    Empresario findByDNI(String dni);
    
    void updateEmpresario (Empresario empresario);
    
    void addEmpresario(Empresario empresario);
}