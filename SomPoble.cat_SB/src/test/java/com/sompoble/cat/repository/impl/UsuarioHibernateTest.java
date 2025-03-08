package com.sompoble.cat.repository.impl;

import com.sompoble.cat.domain.Usuario;
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

public class UsuarioHibernateTest {

    private SessionFactory sessionFactory;

    @BeforeEach
    public void setUp() throws IOException {
        Properties hibernateProperties = new Properties();
        try (FileInputStream fis = new FileInputStream("src/main/resources/hibernate.properties")) {
            hibernateProperties.load(fis);
        }
        sessionFactory = new Configuration()
            .setProperties(hibernateProperties)
            .addAnnotatedClass(Usuario.class)
            .buildSessionFactory();
    }

    @Test
    public void testAddUsuario() {
        Usuario usuario = new Usuario();
        usuario.setNombreUsuario("addUser");
        usuario.setTipoUsuario("Cliente");
        usuario.setContraseña("pass");

        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(usuario);
            transaction.commit();

            Usuario retrievedUsuario = session.get(Usuario.class, usuario.getIdUsuario());
            assertNotNull(retrievedUsuario);
            assertEquals("addUser", retrievedUsuario.getNombreUsuario());
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
    }
}