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

    // The empty constructor is used by Jackson
    // To deserialize it first constructs an object using this
    // and then populates it by using setters
    public Dier() {
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
