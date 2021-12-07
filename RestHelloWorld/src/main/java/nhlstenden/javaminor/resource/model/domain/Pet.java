package nhlstenden.javaminor.resource.model.domain;

import nhlstenden.javaminor.resource.model.entity.OwnerEntity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class Pet {
    private long id;

    private long owner_id;

    @NotBlank
    @Size(max = 50)
    private String species;

    private String breed;

    @NotBlank
    @Size(max = 50)
    private String name;

    @Positive
    private Integer age;

    public Pet(long id, long owner_id, String species, String breed, String name, Integer age) {
        this.id = id;
        this.owner_id = owner_id;
        this.species = species;
        this.breed = breed;
        this.name = name;
        this.age = age;
    }

    public Pet() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(long owner_id) {
        this.owner_id = owner_id;
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
}
