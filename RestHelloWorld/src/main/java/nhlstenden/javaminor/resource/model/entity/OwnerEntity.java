package nhlstenden.javaminor.resource.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "owner")
public class OwnerEntity {
    @Id
//    @GenericGenerator(name="ownerIdGenerator", strategy = "increment")
//    @GeneratedValue(generator = "ownerIdGenerator")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JsonIgnore
    private List<PetEntity> petEntities = new ArrayList<>();

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "age", nullable = false, length = 3)
    private Integer age;

    @Column(name = "city", nullable = false, length = 50)
    private String city;

    public OwnerEntity(String name, Integer age, String city) {
        this.name = name;
        this.age = age;
        this.city = city;
    }

    public OwnerEntity() {
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

    public void addPetEntity(PetEntity petEntity) {
        petEntities.add(petEntity);
        petEntity.setOwner(this);
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
