package nhlstenden.javaminor.resources;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/dieren")
public class DierController {
    ObjectMapper mapper = new ObjectMapper();

    HashMap<Integer, Dier> dieren = new HashMap<>();

    public DierController() {
        this.dieren.put(0, new Dier("Dog", "Podenco Andaluz", "Koen", 3));
        this.dieren.put(1, new Dier("Dog", "Podenco Canario", "Olivier", 11));
        this.dieren.put(2, new Dier("Dog", "Labrador", "Katja", 5));
        this.dieren.put(3, new Dier("Cat", "", "Joris", 7));
    }

    @GetMapping()
    public String getDieren() throws JsonProcessingException {
        return mapper.writeValueAsString(dieren);
    }

    @GetMapping("/{id}")
    public String getDierById(@PathVariable int id) throws JsonProcessingException {
        Dier dier = dieren.get(id);

        return mapper.writeValueAsString(dier);
    }

    @GetMapping(params = "name")
    public String getDierByName(@RequestParam String name) throws JsonProcessingException {
        ArrayList<Dier> dierenMetNamen = new ArrayList<>();

        for(Map.Entry<Integer, Dier> entry : dieren.entrySet()) {
            if(entry.getValue().getName().contains(name)) {
                dierenMetNamen.add(entry.getValue());
            }
        }

        return mapper.writeValueAsString(dierenMetNamen);
    }

    // TODO: Validation
    @PostMapping
    public String addDieren(@RequestBody @Valid Dier dier) throws JsonProcessingException {
        int hashmapSize = dieren.size();
        dieren.put(hashmapSize, dier);

        return mapper.writeValueAsString(dier);
    }
}
