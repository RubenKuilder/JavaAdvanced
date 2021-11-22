package nhlstenden.javaminor.resources.controllers;

import nhlstenden.javaminor.resources.models.Pet;
import nhlstenden.javaminor.resources.repositories.PetRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.HashMap;

@RestController
@RequestMapping("/pets")
public class PetController {
    private final PetRepository petRepository;

    public PetController(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @GetMapping
    public ResponseEntity<HashMap<Integer, Pet>> getPets() {
        return ResponseEntity.ok(petRepository.getPets());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pet> getPetById(@PathVariable int id) {
        return ResponseEntity.ok(petRepository.getPetById(id));
    }

    @GetMapping(params = "name")
    public ResponseEntity<HashMap<Integer, Pet>> getPetsByName(@RequestParam String name) {
        return ResponseEntity.ok(petRepository.getPetsByName(name));
    }

    @PostMapping
    public ResponseEntity<Pet> addPet(@RequestBody @Valid Pet pet) {
        return ResponseEntity.ok(petRepository.addPet(pet));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pet> putPet(@PathVariable int id, @RequestBody @Valid Pet pet) {
        return ResponseEntity.ok(petRepository.putPet(id, pet));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Pet> patchPet(@PathVariable int id, @RequestBody Pet pet) {
        return ResponseEntity.ok(petRepository.patchPet(id, pet));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePet(@PathVariable int id) {
        petRepository.deletePet(id);
        return ResponseEntity.ok(String.format("Pet with ID %d deleted.", id));
    }
}

// TODO: Exception handlers (NoDataFoundException in de repositories)
