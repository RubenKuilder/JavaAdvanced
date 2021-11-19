package nhlstenden.javaminor.resources;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/eigenaren")
public class EigenaarController {
    ObjectMapper mapper = new ObjectMapper();

    @GetMapping
    public String getEigenaren() {
        Eigenaar eigenaar = new Eigenaar("Ruben Kuilder", 24, "Emmen");
        try {
            String eigenaarAsString = mapper.writeValueAsString(eigenaar);

            return eigenaarAsString;
        } catch (JsonProcessingException e) {
            return "JsonProcessingException";
        }
    }
}
