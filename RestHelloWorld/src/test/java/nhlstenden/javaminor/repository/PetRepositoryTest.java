package nhlstenden.javaminor.repository;

import nhlstenden.javaminor.config.TestConfiguration;
import nhlstenden.javaminor.resource.model.domain.Pet;
import nhlstenden.javaminor.resource.model.entity.OwnerEntity;
import nhlstenden.javaminor.resource.model.entity.PetEntity;
import nhlstenden.javaminor.resource.repository.PetEntityRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.transaction.Transactional;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = TestConfiguration.class)
@Transactional
public class PetRepositoryTest {
    @Autowired
    private PetEntityRepository petEntityRepository;

//    @Test
//    @DisplayName("Test persist owner")
//    //TODO: fix error
//    public void testPersistOwner() {
//        OwnerEntity ownerEntityToPersist = new PetEntity("Ruben test", 14, "Leeuwarden");
//        OwnerEntity persistedOwnerEntity = petEntityRepository.persist(ownerEntityToPersist);
//        assertThat(persistedOwnerEntity.getName(), is(ownerEntityToPersist.getName()));
//    }

    @Test
    @DisplayName("Test get pets")
    public void testGetPets() {
        Collection<PetEntity> petEntities = petEntityRepository.get();
        System.out.println(petEntities);
        assertThat(petEntities.isEmpty(), is(false));
    }

    @Test
    @DisplayName("Test get pet by ID")
    public void testGetPetById() {
        PetEntity petEntity = petEntityRepository.getById(1);
        assertEquals("Koen", petEntity.getName());
    }

    @Test
    @DisplayName("Test get pet by name")
    public void testGetPetByName() {
        Collection<PetEntity> petEntities = petEntityRepository.getByName("Koe");
        assertThat(petEntities.isEmpty(), is(false));
    }

    @Test
    @DisplayName("Test delete pet")
    public void testDeletePet() {
        petEntityRepository.delete(2);
        Collection<PetEntity> petEntities = petEntityRepository.get();
        assertThat(petEntities.size(), is(1));
    }

    @Test
    @DisplayName("Test put pet")
    public void testPutPet() {
        OwnerEntity ownerEntity = new OwnerEntity();
        ownerEntity.setId(1);
        PetEntity petEntityToPut = new PetEntity(ownerEntity, "Dog", "Podenco", "Test naam", 6);
        PetEntity puttedPetEntity = petEntityRepository.put(1, petEntityToPut);
        assertThat(puttedPetEntity.getName(), is(petEntityToPut.getName()));
    }

    @Test
    @DisplayName("Test patch pet")
    public void testPatchPet() {
        OwnerEntity ownerEntity = new OwnerEntity();
        ownerEntity.setId(1);
        PetEntity petEntityToPatch = new PetEntity(ownerEntity, "Cat", null, null, null);
        PetEntity patchedPetEntity = petEntityRepository.patch(1, petEntityToPatch);
        assertThat(patchedPetEntity.getSpecies(), is(petEntityToPatch.getSpecies()));
    }
}
