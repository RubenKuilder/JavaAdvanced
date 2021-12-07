package nhlstenden.javaminor.resource.model.entity;

import nhlstenden.javaminor.resource.model.domain.Pet;
import nhlstenden.javaminor.resource.repository.OwnerEntityRepository;
import nhlstenden.javaminor.util.EntityMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PetEntityMapper implements EntityMapper<PetEntity, Pet> {
    private final OwnerEntityRepository ownerEntityRepository;

    public PetEntityMapper(OwnerEntityRepository ownerEntityRepository) {
        this.ownerEntityRepository = ownerEntityRepository;
    }

    @Override
    public Pet mapFromEntity(PetEntity petEntity) {
        return new Pet(
                petEntity.getId(),
                petEntity.getOwner().getId(),
                petEntity.getSpecies(),
                petEntity.getBreed(),
                petEntity.getName(),
                petEntity.getAge()
        );
    }

    @Override
    public PetEntity mapToEntity(Pet pet) {
        OwnerEntity ownerEntity = ownerEntityRepository.getById(pet.getOwner_id());

        return new PetEntity(
                ownerEntity,
                pet.getSpecies(),
                pet.getBreed(),
                pet.getName(),
                pet.getAge()
        );
    }

    public List<Pet> mapFromEntityList(List<PetEntity> entities) {
        List<Pet> myFinalList = new ArrayList<>();
        for (PetEntity entity : entities) {
            myFinalList.add(mapFromEntity(entity));
        }

        return myFinalList;
    }
}
