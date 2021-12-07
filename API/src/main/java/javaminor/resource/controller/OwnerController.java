package javaminor.resource.controller;

import javaminor.resource.model.Owner;
import javaminor.resource.service.OwnerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @PostMapping
    public ResponseEntity<Owner> addOwner(@RequestBody @Valid Owner owner) {
        return ResponseEntity.ok(ownerService.persist(owner));
    }
}
