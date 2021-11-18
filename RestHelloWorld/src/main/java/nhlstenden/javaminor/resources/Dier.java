package nhlstenden.javaminor.resources;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class Dier {
    @NotBlank
    @Size(max = 50)
    private String species;

    private String breed;

    @NotBlank
    @Size(max = 50)
    private String name;

    @NotBlank
    @Positive
    private int age;

    public Dier(String species, String breed, String name, int age) {
        this.species = species;
        this.breed = breed;
        this.name = name;
        this.age = age;
    }
}
