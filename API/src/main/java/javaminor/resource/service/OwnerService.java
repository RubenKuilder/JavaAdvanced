package javaminor.resource.service;

import javaminor.resource.model.Owner;
import javaminor.resource.repository.OwnerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OwnerService {
    private final OwnerRepository ownerRepository;

    public OwnerService(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    public Owner persist(Owner owner) {
        return ownerRepository.persist(owner);
    }

    public List<Owner> get() {
        return ownerRepository.get();
    }
//
//    public Owner getById(long id) {
//        return ownerRepository.getById(id);
//    }
//
//    public List<Owner> getByName(String name) {
//        return ownerRepository.getByName(name);
//    }
//
//    public void delete(long id) {
//        ownerRepository.delete(id);
//    }
//
//    public Owner put(long id, Owner owner) {
//        return ownerRepository.put(id, owner);
//    }
//
//    public Owner patch(long id, Owner owner) {
//        return ownerRepository.patch(id, owner);
//    }
}
