package nhlstenden.javaminor.repository;

import nhlstenden.javaminor.config.TestConfiguration;
import nhlstenden.javaminor.resource.model.domain.Owner;
import nhlstenden.javaminor.resource.model.entity.OwnerEntity;
import nhlstenden.javaminor.resource.repository.OwnerEntityRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.transaction.Transactional;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = TestConfiguration.class)
@Transactional
public class OwnerRepositoryTest {
    @Autowired
    private OwnerEntityRepository ownerEntityRepository;

    @Test
    @DisplayName("Test persist owner")
    public void testPersistOwner() {
        OwnerEntity ownerEntityToPersist = new OwnerEntity("Ruben test", 14, "Leeuwarden");
        OwnerEntity persistedOwnerEntity = ownerEntityRepository.persist(ownerEntityToPersist);
        assertThat(persistedOwnerEntity.getName(), is(ownerEntityToPersist.getName()));
    }

    @Test
    @DisplayName("Test pets")
    public void testGetOwners() {
        Collection<OwnerEntity> ownerEntities = ownerEntityRepository.get();
        assertThat(ownerEntities.isEmpty(), is(false));
    }

    @Test
    @DisplayName("Test get owner by ID")
    public void testGetOwnerById() {
        OwnerEntity ownerEntity = ownerEntityRepository.getById(1);
        assertEquals("Ruben", ownerEntity.getName());
    }

    @Test
    @DisplayName("Test get owner by name")
    public void testGetOwnerByName() {
        Collection<OwnerEntity> ownerEntities = ownerEntityRepository.getByName("Koe");
        assertThat(ownerEntities.isEmpty(), is(false));
    }

    @Test
    @DisplayName("Test delete owner")
    public void testDeleteOwner() {
        ownerEntityRepository.delete(2);
        Collection<OwnerEntity> ownerEntities = ownerEntityRepository.get();
        assertThat(ownerEntities.size(), is(1));
    }

    @Test
    @DisplayName("Test put owner")
    public void testPutOwner() {
        OwnerEntity ownerEntityToPut = new OwnerEntity("Ruben test", 14, "Leeuwarden");
        OwnerEntity puttedOwnerEntity = ownerEntityRepository.put(1, ownerEntityToPut);
        assertThat(puttedOwnerEntity.getName(), is(ownerEntityToPut.getName()));
    }

    @Test
    @DisplayName("Test patch owner")
    public void testPatchOwner() {
        OwnerEntity ownerEntityToPatch = new OwnerEntity("Ruben test", null, null);
        OwnerEntity patchedOwnerEntity = ownerEntityRepository.patch(1, ownerEntityToPatch);
        assertThat(patchedOwnerEntity.getName(), is(ownerEntityToPatch.getName()));
    }
}
