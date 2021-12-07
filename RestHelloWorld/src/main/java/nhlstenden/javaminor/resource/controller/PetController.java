package nhlstenden.javaminor.resource.controller;

import nhlstenden.javaminor.resource.model.domain.Pet;
import nhlstenden.javaminor.resource.service.PetService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/pets")
public class PetController {
    private final PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    @GetMapping
    public ResponseEntity<List<Pet>> getPets() {
        return ResponseEntity.ok(petService.get());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pet> getPetById(@PathVariable long id) {
        return ResponseEntity.ok(petService.getById(id));
//        return ResponseEntity.ok(petRepository.getPetById(id));
    }

    @GetMapping(params = "name")
    public ResponseEntity<List<Pet>> getPetsByName(@RequestParam String name) {
        return ResponseEntity.ok(petService.getByName(name));
    }

    @PostMapping
    public ResponseEntity<Pet> addPet(@RequestBody @Valid Pet pet) {
        return ResponseEntity.ok(petService.persist(pet));
//        return ResponseEntity.ok(petRepository.addPet(pet));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pet> putPet(@PathVariable long id, @RequestBody @Valid Pet pet) {
        return ResponseEntity.ok(petService.put(id, pet));
//        return ResponseEntity.ok(petRepository.putPet(id, pet));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Pet> patchPet(@PathVariable int id, @RequestBody Pet pet) {
        return ResponseEntity.ok(petService.patch(id, pet));
//        return ResponseEntity.ok(petRepository.patchPet(id, pet));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePet(@PathVariable int id) {
        petService.delete(id);
        return ResponseEntity.ok(String.format("Pet with ID %d deleted.", id));
    }
}
