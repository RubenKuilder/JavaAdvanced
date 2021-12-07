package nhlstenden.javaminor.resource.service;

import nhlstenden.javaminor.resource.model.domain.Pet;
import nhlstenden.javaminor.resource.model.entity.OwnerEntityMapper;
import nhlstenden.javaminor.resource.model.entity.PetEntityMapper;
import nhlstenden.javaminor.resource.repository.PetEntityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService {
    private final PetEntityRepository petEntityRepository;

    private final PetEntityMapper petEntityMapper;

    public PetService(PetEntityRepository petEntityRepository, PetEntityMapper petEntityMapper) {
        this.petEntityRepository = petEntityRepository;
        this.petEntityMapper = petEntityMapper;
    }

    public List<Pet> get() {
        return petEntityMapper.mapFromEntityList(petEntityRepository.get());
    }

    public Pet getById(long id) {
        return petEntityMapper.mapFromEntity(petEntityRepository.getById(id));
    }

    public List<Pet> getByName(String name) {
        return petEntityMapper.mapFromEntityList(petEntityRepository.getByName(name));
    }

    public void delete(long id) {
        petEntityRepository.delete(id);
    }

    public Pet persist(Pet pet) {
        return petEntityMapper.mapFromEntity(petEntityRepository.persist(petEntityMapper.mapToEntity(pet)));
    }

    public Pet put(long id, Pet pet) {
        return petEntityMapper.mapFromEntity(petEntityRepository.put(id, petEntityMapper.mapToEntity(pet)));
    }

    public Pet patch(long id, Pet pet) {
        return petEntityMapper.mapFromEntity(petEntityRepository.patch(id, petEntityMapper.mapToEntity(pet)));
    }
}
