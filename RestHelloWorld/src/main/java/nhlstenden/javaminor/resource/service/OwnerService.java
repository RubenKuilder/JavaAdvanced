package nhlstenden.javaminor.resource.service;

import nhlstenden.javaminor.resource.model.domain.Owner;
import nhlstenden.javaminor.resource.model.entity.OwnerEntityMapper;
import nhlstenden.javaminor.resource.repository.OwnerEntityRepository;
import org.springframework.stereotype.Service;

import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class OwnerService {
    private final OwnerEntityRepository ownerEntityRepository;

    private final OwnerEntityMapper ownerEntityMapper;

    public OwnerService(OwnerEntityRepository ownerEntityRepository, OwnerEntityMapper ownerEntityMapper) {
        this.ownerEntityRepository = ownerEntityRepository;
        this.ownerEntityMapper = ownerEntityMapper;
    }

    public List<Owner> get() {
        return ownerEntityMapper.mapFromEntityList(ownerEntityRepository.get());
    }

    public Owner getById(long id) {
        return ownerEntityMapper.mapFromEntity(ownerEntityRepository.getById(id));
    }

    public List<Owner> getByName(String name) {
        return ownerEntityMapper.mapFromEntityList(ownerEntityRepository.getByName(name));
    }

    public void delete(long id) {
        ownerEntityRepository.delete(id);
    }

    public Owner persist(Owner owner) {
        return ownerEntityMapper.mapFromEntity(ownerEntityRepository.persist(ownerEntityMapper.mapToEntity(owner)));
    }

    public Owner put(long id, Owner owner) {
        return ownerEntityMapper.mapFromEntity(ownerEntityRepository.put(id, ownerEntityMapper.mapToEntity(owner)));
    }

    public Owner patch(long id, Owner owner) {
        return ownerEntityMapper.mapFromEntity(ownerEntityRepository.patch(id, ownerEntityMapper.mapToEntity(owner)));
    }
}
