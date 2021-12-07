package nhlstenden.javaminor.resource.controller;

import nhlstenden.javaminor.resource.model.domain.Owner;
import nhlstenden.javaminor.resource.repository.OwnerRepository;
import nhlstenden.javaminor.resource.service.OwnerService;
import nhlstenden.javaminor.resource.service.PetService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/owners")
public class OwnerController {
    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @GetMapping
    public ResponseEntity<List<Owner>> getOwners() {
        return ResponseEntity.ok(ownerService.get());
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<Owner> getOwnerById(@PathVariable int id) {
//        return ResponseEntity.ok(ownerRepository.getOwnerById(id));
//    }
//
//    @GetMapping(params = "name")
//    public ResponseEntity<HashMap<Integer, Owner>> getOwnersByName(@RequestParam String name) {
//        return ResponseEntity.ok(ownerRepository.getOwnersByName(name));
//    }

    @PostMapping
    public ResponseEntity<Owner> addOwner(@RequestBody @Valid Owner owner) {
        return ResponseEntity.ok(ownerService.persist(owner));
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<Owner> putOwner(@PathVariable int id, @RequestBody @Valid Owner owner) {
//        return ResponseEntity.ok(ownerRepository.putOwner(id, owner));
//    }
//
//    @PatchMapping("/{id}")
//    public ResponseEntity<Owner> patchOwner(@PathVariable int id, @RequestBody Owner owner) {
//        return ResponseEntity.ok(ownerRepository.patchOwner(id, owner));
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOwner(@PathVariable int id) {
        ownerService.delete(id);
        return ResponseEntity.ok(String.format("Owner with id %d deleted.", id));
    }
}
