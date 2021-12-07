package nhlstenden.javaminor.resource.repository;

import nhlstenden.javaminor.resource.exception.NoDataFoundException;
import nhlstenden.javaminor.resource.model.domain.Owner;
import nhlstenden.javaminor.resource.model.domain.Pet;
import nhlstenden.javaminor.resource.model.entity.OwnerEntity;
import nhlstenden.javaminor.resource.model.entity.OwnerEntityMapper;
import nhlstenden.javaminor.resource.model.entity.PetEntity;
import nhlstenden.javaminor.resource.model.entity.PetEntityMapper;
import org.hibernate.Hibernate;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class OwnerEntityRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public OwnerEntity persist(OwnerEntity ownerEntity) {
        entityManager.persist(ownerEntity);
        return getById(ownerEntity.getId());
    }

    public List<OwnerEntity> get() {
        TypedQuery<OwnerEntity> query = entityManager.createQuery("SELECT o FROM OwnerEntity o", OwnerEntity.class);
        return query.getResultList();
    }

    public OwnerEntity getById(long id) {
        return entityManager.find(OwnerEntity.class, id);
    }

    public List<OwnerEntity> getByName(String name) {
        TypedQuery<OwnerEntity> query = entityManager.createQuery("SELECT o FROM OwnerEntity o WHERE o.name LIKE :name", OwnerEntity.class);
        query.setParameter("name", '%' + name + '%');
        return query.getResultList();
    }

    public void delete(long id) {
        entityManager.remove(getById(id));
    }

    public void deletePet(long id, PetEntity petEntity) {
        OwnerEntity ownerEntity = getById(id);
        ownerEntity.getPetEntities().remove(petEntity);
    }

    public OwnerEntity put(long id, OwnerEntity ownerEntity) {
        ownerEntity.setId(id);
        return entityManager.merge(ownerEntity);
    }

    public OwnerEntity patch(long id, OwnerEntity ownerEntity) {
        if (getById(id) == null)
            throw new NoDataFoundException(String.format("Pet with ID %d does not exist.", id));

        OwnerEntity updatedOwner = getById(id);

        if (ownerEntity.getPetEntities() != null) {
            updatedOwner.setPetEntities(ownerEntity.getPetEntities());
        }

        if (ownerEntity.getName() != null) {
            updatedOwner.setName(ownerEntity.getName());
        }

        if (ownerEntity.getAge() != null) {
            updatedOwner.setAge(ownerEntity.getAge());
        }

        if (ownerEntity.getCity() != null) {
            updatedOwner.setCity(ownerEntity.getCity());
        }

        return updatedOwner;
    }
}
