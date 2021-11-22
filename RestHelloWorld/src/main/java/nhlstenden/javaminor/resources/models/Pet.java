package nhlstenden.javaminor.resources.models;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class Pet {
    @NotBlank
    @Size(max = 50)
    private String species;

    private String breed;

    @NotBlank
    @Size(max = 50)
    private String name;

    @Positive
    private Integer age;

    @Positive
    private Integer ownerId;

    public Pet(String species, String breed, String name, Integer age, Integer ownerId) {
        this.species = species;
        this.breed = breed;
        this.name = name;
        this.age = age;
        this.ownerId = ownerId;
    }

    public Pet() {
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }
}
