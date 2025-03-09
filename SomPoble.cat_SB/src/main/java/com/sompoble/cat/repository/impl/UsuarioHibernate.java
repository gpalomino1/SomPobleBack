package com.sompoble.cat.repository.impl;

import com.sompoble.cat.domain.Usuario;
import com.sompoble.cat.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

@Repository
@Transactional
public class UsuarioHibernate implements UsuarioRepository {

    @Autowired
    private EntityManager entityManager;

    @Override
    public void addUsuario(Usuario usuario) {
        entityManager.persist(usuario);
    }

    @Override
    public void updateUsuario(Usuario usuario) {
        entityManager.merge(usuario);
    }

    @Override
    public Usuario findByNombreUsuario(String nombreUsuario) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Usuario> cq = cb.createQuery(Usuario.class);
        Root<Usuario> root = cq.from(Usuario.class);

        Predicate nombreUsuarioPredicate = cb.equal(root.get("nombreUsuario"), nombreUsuario);
        cq.where(nombreUsuarioPredicate);

        return entityManager.createQuery(cq).getSingleResult();
    }
}