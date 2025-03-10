package com.sompoble.cat.service;

import com.sompoble.cat.domain.Usuario;

public interface UsuarioService {

    void addUsuario(Usuario usuario, String dni, String nombre, String apellidos, String email, String telefono);

    void updateUsuario(Usuario usuario);

    Usuario findByNombreUsuario(String nombreUsuario);
}