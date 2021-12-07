package nhlstenden.javaminor.resource.model.domain;

import nhlstenden.javaminor.resource.model.entity.PetEntity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.util.List;

public class Owner {
    private long id;

    private List<PetEntity> petEntities;

    @NotBlank
    @Size(max = 50)
    private String name;

    @Positive
    private Integer age;

    @NotBlank
    @Size(max = 50)
    private String city;

    public Owner(long id, List<PetEntity> petEntities, String name, Integer age, String city) {
        this.id = id;
        this.petEntities = petEntities;
        this.name = name;
        this.age = age;
        this.city = city;
    }

    public Owner() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<PetEntity> getPetEntities() {
        return petEntities;
    }

    public void setPetEntities(List<PetEntity> petEntities) {
        this.petEntities = petEntities;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
