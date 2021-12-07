package nhlstenden.javaminor.resource.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import nhlstenden.javaminor.resource.exception.NoDataFoundException;
import nhlstenden.javaminor.resource.model.domain.Pet;
import nhlstenden.javaminor.resource.model.entity.OwnerEntity;
import nhlstenden.javaminor.resource.model.entity.PetEntity;
import nhlstenden.javaminor.resource.model.entity.PetEntityMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class PetEntityRepository {
    @PersistenceContext
    private EntityManager entityManager;

    private OwnerEntityRepository ownerEntityRepository;

    public PetEntityRepository(OwnerEntityRepository ownerEntityRepository) {
        this.ownerEntityRepository = ownerEntityRepository;
    }

    public PetEntity persist(PetEntity petEntity) {
        ownerEntityRepository.getById(petEntity.getOwner().getId()).addPetEntity(petEntity);
        entityManager.persist(petEntity);
        return getById(petEntity.getId());
    }

    public List<PetEntity> get() {
        TypedQuery<PetEntity> query = entityManager.createQuery("SELECT p FROM PetEntity p", PetEntity.class);
        return query.getResultList();
    }

    public PetEntity getById(long id) {
        return entityManager.find(PetEntity.class, id);
    }

    public List<PetEntity> getByName(String name) {
        TypedQuery<PetEntity> query = entityManager.createQuery("SELECT p FROM PetEntity p WHERE p.name LIKE :name", PetEntity.class);
        query.setParameter("name", '%' + name + '%');
        return query.getResultList();
    }

    public void delete(long id) {
        PetEntity petEntityToDelete = getById(id);
        OwnerEntity ownerEntity = petEntityToDelete.getOwner();

        ownerEntityRepository.deletePet(ownerEntity.getId(), petEntityToDelete);
        ownerEntityRepository.persist(ownerEntity);
        entityManager.remove(entityManager.contains(petEntityToDelete) ? petEntityToDelete : entityManager.merge(petEntityToDelete));
    }

    public PetEntity put(long id, PetEntity petEntity) {
        petEntity.setId(id);
        return entityManager.merge(petEntity);
    }

    public PetEntity patch(long id, PetEntity petEntity) {
        if (getById(id) == null)
            throw new NoDataFoundException(String.format("Pet with ID %d does not exist.", id));

        PetEntity updatedPet = getById(id);

        if (petEntity.getOwner() != null) {
            updatedPet.setOwner(petEntity.getOwner());
        }

        if (petEntity.getSpecies() != null) {
            updatedPet.setSpecies(petEntity.getSpecies());
        }

        if (petEntity.getBreed() != null) {
            updatedPet.setBreed(petEntity.getBreed());
        }

        if (petEntity.getName() != null) {
            updatedPet.setName(petEntity.getName());
        }

        if (petEntity.getAge() != null) {
            updatedPet.setAge(petEntity.getAge());
        }

        return updatedPet;
    }
}
