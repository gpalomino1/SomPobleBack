package com.sompoble.cat.repository.impl;

import com.sompoble.cat.domain.Usuario;
import static org.junit.jupiter.api.Assertions.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class UsuarioHibernateDatabaseTest {

    private SessionFactory sessionFactory;

    @BeforeEach
    public void setUp() throws IOException {
        // Cargar el archivo de propiedades
        Properties hibernateProperties = new Properties();
        try (FileInputStream fis = new FileInputStream("src/main/resources/hibernate.properties")) {
            hibernateProperties.load(fis);
        }

        sessionFactory = new Configuration()
            .addAnnotatedClass(Usuario.class) 
            .setProperties(hibernateProperties)
            .buildSessionFactory();
    }

    @Test
    public void testConnection() {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            assertNotNull(session);
            session.getTransaction().commit();
        }
    }
}
