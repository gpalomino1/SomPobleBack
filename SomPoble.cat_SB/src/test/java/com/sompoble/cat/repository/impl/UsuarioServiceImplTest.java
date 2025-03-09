package com.sompoble.cat.repository.impl;

import com.sompoble.cat.domain.Cliente;
import com.sompoble.cat.domain.Empresario;
import com.sompoble.cat.domain.Usuario;
import com.sompoble.cat.repository.UsuarioRepository;
import com.sompoble.cat.repository.ClienteRepository;
import com.sompoble.cat.repository.EmpresarioRepository;
import com.sompoble.cat.service.impl.UsuarioServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UsuarioServiceImplTest {

    @Mock
    private UsuarioRepository usuarioRepository;

    @Mock
    private ClienteRepository clienteRepository;

    @Mock
    private EmpresarioRepository empresarioRepository;

    @InjectMocks
    private UsuarioServiceImpl usuarioService;

    private Usuario usuario;
    private final String dni = "12345678A";
    private final String nombre = "Juan";
    private final String apellidos = "Pérez";
    private final String email = "juan@example.com";
    private final String telefono = "600123456";

    @BeforeEach
    public void setUp() {
        // Configurar un usuario de prueba
        usuario = new Usuario();
        usuario.setTipoUsuario(1);
        usuario.setNombreUsuario("testUser");
        usuario.setContraseña("password");
    }

    @Test
    public void testAddUsuario_Cliente() {
        // Asignamos tipoUsuario como 1 para Cliente
        usuario.setTipoUsuario(1);

        usuarioService.addUsuario(usuario, dni, nombre, apellidos, email, telefono);

        // Verificamos que el usuario se ha agregado, que el cliente se ha agregado, y que no se ha agregado un empresario
        verify(usuarioRepository, times(1)).addUsuario(usuario);
        verify(clienteRepository, times(1)).addCliente(any(Cliente.class));
        verify(empresarioRepository, times(0)).addEmpresario(any(Empresario.class));
    }

    @Test
    public void testAddUsuario_Empresario() {
        // Asignamos tipoUsuario como 2 para Empresario
        usuario.setTipoUsuario(2);

        usuarioService.addUsuario(usuario, dni, nombre, apellidos, email, telefono);

        // Verificamos que el usuario se ha agregado, que el empresario se ha agregado, y que no se ha agregado un cliente
        verify(usuarioRepository, times(1)).addUsuario(usuario);
        verify(clienteRepository, times(0)).addCliente(any(Cliente.class));
        verify(empresarioRepository, times(1)).addEmpresario(any(Empresario.class));
    }

    @Test
    public void testAddUsuario_NullTipoUsuario() {
        Usuario usuarioInvalid = new Usuario();
        usuarioInvalid.setTipoUsuario(null);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            usuarioService.addUsuario(usuarioInvalid, dni, nombre, apellidos, email, telefono);
        });

        assertEquals("El usuario y su tipo no pueden ser nulos.", exception.getMessage());
    }

    @Test
    public void testUpdateUsuario() {
        usuario.setContraseña("newPassword");

        usuarioService.updateUsuario(usuario);

        verify(usuarioRepository, times(1)).updateUsuario(usuario);
    }

    @Test
    public void testFindByNombreUsuario() {
        when(usuarioRepository.findByNombreUsuario("testUser")).thenReturn(usuario);

        Usuario retrievedUsuario = usuarioService.findByNombreUsuario("testUser");

        assertNotNull(retrievedUsuario);
        assertEquals("testUser", retrievedUsuario.getNombreUsuario());
    }

    @Test
    public void testFindByNombreUsuario_NullOrEmpty() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            usuarioService.findByNombreUsuario("");
        });
        assertEquals("El nombre de usuario no puede ser nulo o vacío.", exception.getMessage());
    }
}
