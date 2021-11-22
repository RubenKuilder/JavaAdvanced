package nhlstenden.javaminor.resources.controllers;

import nhlstenden.javaminor.resources.models.Owner;
import nhlstenden.javaminor.resources.repositories.OwnerRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;

@RestController
@RequestMapping("/owners")
public class OwnerController {
    private final OwnerRepository ownerRepository;

    public OwnerController(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @GetMapping
    public ResponseEntity<HashMap<Integer, Owner>> getOwners() {
        return ResponseEntity.ok(ownerRepository.getOwners());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Owner> getOwnerById(@PathVariable int id) {
        return ResponseEntity.ok(ownerRepository.getOwnerById(id));
    }

    @GetMapping(params = "name")
    public ResponseEntity<HashMap<Integer, Owner>> getOwnersByName(@RequestParam String name) {
        return ResponseEntity.ok(ownerRepository.getOwnersByName(name));
    }

    @PostMapping
    public ResponseEntity<Owner> addOwner(@RequestBody @Valid Owner owner) {
        return ResponseEntity.ok(ownerRepository.addOwner(owner));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Owner> putOwner(@PathVariable int id, @RequestBody @Valid Owner owner) {
        return ResponseEntity.ok(ownerRepository.putOwner(id, owner));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Owner> patchOwner(@PathVariable int id, @RequestBody Owner owner) {
        return ResponseEntity.ok(ownerRepository.patchOwner(id, owner));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOwner(@PathVariable int id) {
        ownerRepository.deleteOwner(id);
        return ResponseEntity.ok(String.format("Owner with id %d deleted.", id));
    }
}
