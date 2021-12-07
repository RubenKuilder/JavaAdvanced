package nhlstenden.javaminor.resource.repository;

import nhlstenden.javaminor.resource.exception.NoDataFoundException;
import nhlstenden.javaminor.resource.model.domain.Pet;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class PetRepository {
    private final HashMap<Integer, Pet> pets;
    private int petIndex = 1;

    public PetRepository() {
         this.pets = new HashMap<>();
//         initRepository();
    }

//    private void initRepository() {
//        addPet(new Pet("Dog", "Podenco Andaluz", "Koen", 3, 1));
//        addPet(new Pet("Dog", "Podenco Canario", "Olivier", 11, 2));
//        addPet(new Pet("Dog", "Labrador", "Katja", 5, 3));
//        addPet(new Pet("Cat", "", "Joris", 7, 4));
//    }

    public HashMap<Integer, Pet> getPets() {
        if (pets.isEmpty()) throw new NoDataFoundException("No pets were found");

        return pets;
    }

    public Pet getPetById(Integer id) {
        if (!pets.containsKey(id)) throw new NoDataFoundException(String.format("Pet with ID %d does not exist.", id));

        return pets.get(id);
    }

    public HashMap<Integer, Pet> getPetsByName(String name) {
        HashMap<Integer, Pet> petsWithNames = new HashMap<>();

        for(Map.Entry<Integer, Pet> entry : pets.entrySet()) {
            if(entry.getValue().getName().contains(name)) {
                petsWithNames.put(entry.getKey(), entry.getValue());
            }
        }

        if (petsWithNames.isEmpty()) throw new NoDataFoundException(String.format("Pet with name %s does not exist.", name));

        return petsWithNames;
    }

    public Pet addPet(Pet pet) {
        pets.put(petIndex, pet);
        petIndex++;

        return pet;
    }

    public Pet putPet(Integer id, Pet pet) {
        pets.put(id, pet);

        return pet;
    }

    public Pet patchPet(Integer id, Pet pet) {
        if (!pets.containsKey(id)) throw new NoDataFoundException(String.format("Pet with ID %d does not exist.", id));

        Pet updatedPet = pets.get(id);

        if(pet.getSpecies() != null) {
            pets.get(id).setSpecies(pet.getSpecies());
        }

        if(pet.getBreed() != null) {
            pets.get(id).setBreed(pet.getBreed());
        }

        if(pet.getName() != null) {
            pets.get(id).setName(pet.getName());
        }

        if(pet.getAge() != null) {
            pets.get(id).setAge(pet.getAge());
        }

//        if(pet.getOwnerId() != null) {
//            pets.get(id).setOwnerId(pet.getOwnerId());
//        }

        return updatedPet;
    }

    public void deletePet(int id) {
        if (!pets.containsKey(id)) throw new NoDataFoundException(String.format("Pet with ID %d does not exist.", id));

        pets.remove(id);
    }
}
