package nhlstenden.javaminor.resources;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class Eigenaar {
    @NotBlank
    @Size(max = 50)
    private String naam;

    @NotBlank
    @Positive
    private int age;

    @NotBlank
    @Size(max = 50)
    private String woonplaats;

    public Eigenaar(String naam, int age, String woonplaats) {
        this.naam = naam;
        this.age = age;
        this.woonplaats = woonplaats;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getWoonplaats() {
        return woonplaats;
    }

    public void setWoonplaats(String woonplaats) {
        this.woonplaats = woonplaats;
    }
}
