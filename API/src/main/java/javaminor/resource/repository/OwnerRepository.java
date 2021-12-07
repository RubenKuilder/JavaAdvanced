package javaminor.resource.repository;

import javaminor.resource.model.Owner;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class OwnerRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public Owner persist(Owner owner) {
        entityManager.persist(owner);
        return owner;
    }

    public List<Owner> get() {
        TypedQuery<Owner> query = entityManager.createQuery("SELECT o FROM OwnerEntity o", Owner.class);
        return query.getResultList();
    }
}
