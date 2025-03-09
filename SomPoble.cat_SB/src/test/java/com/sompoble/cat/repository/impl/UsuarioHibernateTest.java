package com.sompoble.cat.repository.impl;

import com.sompoble.cat.domain.Usuario;
import com.sompoble.cat.repository.UsuarioRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
//@Transactional
public class UsuarioHibernateTest {

    @Autowired
    private UsuarioRepository usuarioRepository;

    private Usuario usuario;

    @BeforeEach
    public void setUp() {
        // Configuramos un nuevo usuario para cada prueba
        usuario = new Usuario();
        usuario.setTipoUsuario(1);
        usuario.setNombreUsuario("testUser1");
        usuario.setContraseña("pass");
    }

    @Test
    public void testAddUsuario() {
        usuarioRepository.addUsuario(usuario);

        Usuario retrievedUsuario = usuarioRepository.findByNombreUsuario("testUser");
        assertNotNull(retrievedUsuario);
        assertEquals("testUser", retrievedUsuario.getNombreUsuario());
        assertEquals("pass", retrievedUsuario.getContraseña());
    }

    @Test
    public void testUpdateUsuario() {
        usuarioRepository.addUsuario(usuario);

        usuario.setContraseña("newpass");
        usuarioRepository.updateUsuario(usuario);

        Usuario retrievedUsuario = usuarioRepository.findByNombreUsuario("testUser");
        assertNotNull(retrievedUsuario);
        assertEquals("newpass", retrievedUsuario.getContraseña());
    }

    @Test
    public void testFindByNombreUsuario() {
        usuario = new Usuario();
        usuario.setTipoUsuario(1);
        usuario.setNombreUsuario("testUser2");
        usuario.setContraseña("pass");
        usuarioRepository.addUsuario(usuario);

        Usuario retrievedUsuario = usuarioRepository.findByNombreUsuario("testUser2");

        assertNotNull(retrievedUsuario);
        assertEquals("testUser2", retrievedUsuario.getNombreUsuario());
    }
}