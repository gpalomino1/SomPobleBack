package com.sompoble.cat.repository.impl;

import com.sompoble.cat.domain.Cliente;
import com.sompoble.cat.repository.ClienteRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class ClienteHibernate implements ClienteRepository {

    @Autowired
    private EntityManager entityManager;

    @Override
    public void addCliente(Cliente cliente) {
        entityManager.persist(cliente);
    }

    @Override
    public void updateCliente(Cliente cliente) {
        entityManager.merge(cliente);
    }

    @Override
    public Cliente findByDNI(String dni) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Cliente> cq = cb.createQuery(Cliente.class);
        Root<Cliente> root = cq.from(Cliente.class);

        Predicate dniPredicate = cb.equal(root.get("dni"), dni);
        cq.where(dniPredicate);

        return entityManager.createQuery(cq).getSingleResult();
    }

    @Override
    public List<Cliente> findAll() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Cliente> cq = cb.createQuery(Cliente.class);
        Root<Cliente> root = cq.from(Cliente.class);

        return entityManager.createQuery(cq).getResultList();
    }

    @Override
    public void deleteById(Long id) {
        Cliente cliente = entityManager.find(Cliente.class, id);
        if (cliente != null) {
            entityManager.remove(cliente);
        }
    }

    @Override
    public void deleteByDni(String dni) {
        Cliente cliente = findByDNI(dni);  // Puedes reutilizar la consulta findByDNI
        if (cliente != null) {
            entityManager.remove(cliente);
        }
    }

    @Override
    public boolean existsByDni(String dni) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Cliente> root = cq.from(Cliente.class);

        Predicate dniPredicate = cb.equal(root.get("dni"), dni);
        cq.select(cb.count(root)).where(dniPredicate);

        Long count = entityManager.createQuery(cq).getSingleResult();
        return count > 0;
    }

    @Override
    public boolean existsById(Long id) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Cliente> root = cq.from(Cliente.class);

        Predicate idPredicate = cb.equal(root.get("id"), id);
        cq.select(cb.count(root)).where(idPredicate);

        Long count = entityManager.createQuery(cq).getSingleResult();
        return count > 0;
    }

    @Override
    public boolean existsByEmail(String email) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Cliente> root = cq.from(Cliente.class);

        Predicate emailPredicate = cb.equal(root.get("email"), email);
        cq.select(cb.count(root)).where(emailPredicate);

        Long count = entityManager.createQuery(cq).getSingleResult();
        return count > 0;
    }
	@Override
	public Cliente findByEmail(String email) {
	    CriteriaBuilder cb = entityManager.getCriteriaBuilder();
	    CriteriaQuery<Cliente> cq = cb.createQuery(Cliente.class);
	    Root<Cliente> root = cq.from(Cliente.class);

	    Predicate emailPredicate = cb.equal(root.get("email"), email);
	    cq.where(emailPredicate);

	    List<Cliente> result = entityManager.createQuery(cq).getResultList();
	    return result.isEmpty() ? null : result.get(0);
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends Cliente> S saveAndFlush(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Cliente> List<S> saveAllAndFlush(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAllInBatch(Iterable<Cliente> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllInBatch() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Cliente getOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cliente getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cliente getReferenceById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Cliente> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Cliente> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Cliente> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cliente> findAllById(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Cliente> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Cliente> findById(Long id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(Cliente entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllById(Iterable<? extends Long> ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Iterable<? extends Cliente> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Cliente> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Cliente> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Cliente> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public <S extends Cliente> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Cliente> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends Cliente> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <S extends Cliente, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
		// TODO Auto-generated method stub
		return null;
	}


}