package nhlstenden.javaminor.resource.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import nhlstenden.javaminor.resource.exception.NoDataFoundException;
import nhlstenden.javaminor.resource.model.domain.Owner;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class OwnerRepository {
    ObjectMapper mapper = new ObjectMapper();

    private final HashMap<Integer, Owner> owners;
    private int ownerIndex = 1;

    public OwnerRepository() {
        this.owners = new HashMap<>();
//        initRepository();
    }

//    private void initRepository() {
//        addOwner(new Owner("Ruben", 24, "Emmen"));
//        addOwner(new Owner("Klaas", 44, "Zwolle"));
//        addOwner(new Owner("Pietje", 12, "Emmen"));
//        addOwner(new Owner("Sander", 27, "Groningen"));
//    }

    public HashMap<Integer, Owner> getOwners() {
        return owners;
    }

    public Owner getOwnerById(Integer id) {
        if (!owners.containsKey(id)) throw new NoDataFoundException(String.format("Owner with ID %d does not exist.", id));

        return owners.get(id);
    }

    public HashMap<Integer, Owner> getOwnersByName(String name) {
        HashMap<Integer, Owner> ownersWithNames = new HashMap<>();

        for(Map.Entry<Integer, Owner> entry : owners.entrySet()) {
            if(entry.getValue().getName().contains(name)) {
                ownersWithNames.put(entry.getKey(), entry.getValue());
            }
        }

        if (ownersWithNames.isEmpty()) throw new NoDataFoundException(String.format("Owner with name %s does not exist.", name));

        return ownersWithNames;
    }

    public Owner addOwner(Owner owner) {
        owners.put(ownerIndex, owner);
        ownerIndex++;

        return owner;
    }

    public Owner putOwner(Integer id, Owner owner) {
        owners.put(id, owner);

        return owner;
    }

    public Owner patchOwner(Integer id, Owner owner) {
        if (!owners.containsKey(id)) throw new NoDataFoundException(String.format("Owner with ID %d does not exist.", id));

        Owner updatedPet = owners.get(id);

        if(owner.getName() != null) {
            owners.get(id).setName(owner.getName());
        }

        if(owner.getAge() != null) {
            owners.get(id).setAge(owner.getAge());
        }

        if(owner.getCity() != null) {
            owners.get(id).setCity(owner.getCity());
        }

        return updatedPet;
    }

    public void deleteOwner(int id) {
        if (!owners.containsKey(id)) throw new NoDataFoundException(String.format("Owner with ID %d does not exist.", id));

        owners.remove(id);
    }
}
