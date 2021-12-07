package javaminor.resource.model;

import javax.persistence.*;

@Entity
@Table(name = "pet")
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id")
    private Owner owner;

    @Column(name = "species", nullable = false, length = 50)
    private String species;

    @Column(name = "breed", nullable = false, length = 50)
    private String breed;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "age", nullable = false, length = 3)
    private Integer age;

    public Pet(Owner owner, String species, String breed, String name, Integer age) {
        this.owner = owner;
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

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
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