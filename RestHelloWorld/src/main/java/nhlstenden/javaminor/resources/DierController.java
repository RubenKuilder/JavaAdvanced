package nhlstenden.javaminor.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dieren")
public class DierController {
    @GetMapping
    public String getDieren() {
        return "Hello dieren!";
//        return new Dier("Dog", "Podenco Andaluz", "Koen", 3);
    }
}
