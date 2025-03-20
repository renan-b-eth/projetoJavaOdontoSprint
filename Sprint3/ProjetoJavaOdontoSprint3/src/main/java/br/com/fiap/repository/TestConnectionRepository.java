package br.com.fiap.repository;

import br.com.fiap.banco.PersistenceContext;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

@Repository
public class TestConnectionRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public boolean isConnected() {
        return entityManager.unwrap(Session.class).isConnected();
    }
}
