package javaminor.resource.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "owner")
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    private List<Pet> pets = new ArrayList<>();

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "age", nullable = false, length = 3)
    private Integer age;

    @Column(name = "city", nullable = false, length = 50)
    private String city;

    public Owner(String name, Integer age, String city) {
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

    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
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