package com.sompoble.cat.repository.impl;

import com.sompoble.cat.domain.Empresario;
import com.sompoble.cat.repository.EmpresarioRepository;
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
public class EmpresarioHibernate implements EmpresarioRepository {

    @Autowired
    private EntityManager entityManager;

    @Override
    public void addEmpresario(Empresario empresario) {
        entityManager.persist(empresario);
    }

    @Override
    public void updateEmpresario(Empresario empresario) {
        entityManager.merge(empresario);
    }

    @Override
    public Empresario findByDNI(String dni) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Empresario> cq = cb.createQuery(Empresario.class);
        Root<Empresario> root = cq.from(Empresario.class);

        Predicate dniPredicate = cb.equal(root.get("dni"), dni);
        cq.where(dniPredicate);

        return entityManager.createQuery(cq).getSingleResult();
    }
}