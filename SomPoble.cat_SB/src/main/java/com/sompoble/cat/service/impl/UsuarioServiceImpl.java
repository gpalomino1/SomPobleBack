package com.sompoble.cat.service.impl;

import com.sompoble.cat.domain.Cliente;
import com.sompoble.cat.domain.Empresario;
import com.sompoble.cat.domain.Usuario;
import com.sompoble.cat.repository.UsuarioRepository;
import com.sompoble.cat.repository.ClienteRepository;
import com.sompoble.cat.repository.EmpresarioRepository;
import com.sompoble.cat.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EmpresarioRepository empresarioRepository;

    @Override
    @Transactional
    public void addUsuario(Usuario usuario, String dni, String nombre, String apellidos, String email, String telefono) {
        if (usuario == null || usuario.getTipoUsuario() == null) {
            throw new IllegalArgumentException("El usuario y su tipo no pueden ser nulos.");
        }

        usuarioRepository.addUsuario(usuario);

        //Si es un cliente - 1 (TODO: hay que ver como lo recibimos)
        if (usuario.getTipoUsuario() == 1) {
            Cliente cliente = new Cliente();
            cliente.setDni(dni);
            cliente.setNombre(nombre);
            cliente.setApellidos(apellidos);
            cliente.setEmail(email);
            cliente.setTelefono(telefono);
            cliente.setUsuarioCliente(usuario);
            clienteRepository.addCliente(cliente);
        } //Si es un cliente - 2 (TODO: hay que ver como lo recibimos)
        else if (usuario.getTipoUsuario() == 2) {
            Empresario empresario = new Empresario();
            empresario.setDni(dni);
            empresario.setNombre(nombre);
            empresario.setApellidos(apellidos);
            empresario.setEmail(email);
            empresario.setTelefono(telefono);
            empresarioRepository.addEmpresario(empresario);
        }
    }

    @Override
    @Transactional
    public void updateUsuario(Usuario usuario) {
        if (usuario == null || usuario.getTipoUsuario() == null) {
            throw new IllegalArgumentException("El usuario y su tipo no pueden ser nulos.");
        }
        usuarioRepository.updateUsuario(usuario);
    }

    @Override
    public Usuario findByNombreUsuario(String nombreUsuario) {
        if (nombreUsuario == null || nombreUsuario.isEmpty()) {
            throw new IllegalArgumentException("El nombre de usuario no puede ser nulo o vacío.");
        }
        return usuarioRepository.findByNombreUsuario(nombreUsuario);
    }
}
