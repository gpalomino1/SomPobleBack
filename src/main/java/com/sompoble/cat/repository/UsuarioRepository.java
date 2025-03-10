package com.sompoble.cat.repository;

import com.sompoble.cat.domain.Usuario;

public interface UsuarioRepository {
    
    Usuario findByNombreUsuario(String nombreUsuario);
    
    void updateUsuario(Usuario usuario);
    
    void addUsuario(Usuario usuario);
}