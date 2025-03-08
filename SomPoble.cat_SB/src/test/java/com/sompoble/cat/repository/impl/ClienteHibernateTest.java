package com.sompoble.cat.repository.impl;

import com.sompoble.cat.domain.Cliente;
import static org.junit.jupiter.api.Assertions.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ClienteHibernateTest {

    /*private SessionFactory sessionFactory;

    @BeforeEach
    public void setUp() throws IOException {
        Properties hibernateProperties = new Properties();
        try (FileInputStream fis = new FileInputStream("src/main/resources/hibernate.properties")) {
            hibernateProperties.load(fis);
        }
        sessionFactory = new Configuration()
            .setProperties(hibernateProperties)
            .addAnnotatedClass(Cliente.class)
            .buildSessionFactory();
    }

    @Test
    public void testAddCliente() {
        Cliente cliente = new Cliente();
        cliente.setDni("53567814X");
        cliente.setNombre("Sergio");
        cliente.setApellidos("Ramirez Luque");
        cliente.setEmail("sramires@ioc.es");
        cliente.setTelefono("686180800");

        // Abrir una sesión y comenzar una transacción
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(cliente);  
            transaction.commit();

            Cliente retrievedUsuario;
            retrievedUsuario = (Cliente) session.get((Class<T>) cliente.class, cliente.getIdPersona());
            assertNotNull(retrievedUsuario);
            assertEquals("addUser", retrievedUsuario.getNombre());
        }
    }

    @Test
    public void testUpdateUsuario() {
        Usuario usuario = new Usuario();
        usuario.setNombreUsuario("userToUpdate");
        usuario.setTipoUsuario("updatedCliente");
        usuario.setContraseña("oldpass");

        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(usuario);
            transaction.commit();
        }

        usuario.setContraseña("newpass");

        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(usuario); 
            transaction.commit();
        }

        try (Session session = sessionFactory.openSession()) {
            Usuario updatedUsuario = session.get(Usuario.class, usuario.getIdUsuario());
            assertNotNull(updatedUsuario);
            assertEquals("newpass", updatedUsuario.getContraseña());
        }
    }

    @Test
    public void testFindByNombreUsuario() {
        // Crear y guardar un usuario
        Usuario usuario = new Usuario();
        usuario.setNombreUsuario("findUser");
            usuario.setTipoUsuario("findCliente");
        usuario.setContraseña("pass");

        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(usuario);
            transaction.commit();
        }

        try (Session session = sessionFactory.openSession()) {
            Usuario foundUsuario = session.createQuery("FROM Usuario WHERE nombreUsuario = :nombreUsuario", Usuario.class)
                                          .setParameter("nombreUsuario", "findUser")
                                          .uniqueResult();
            assertNotNull(foundUsuario);
            assertEquals("findUser", foundUsuario.getNombreUsuario());
        }
    }*/
}