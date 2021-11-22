package nhlstenden.javaminor.resources.models;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class Owner {
    @NotBlank
    @Size(max = 50)
    private String name;

    @Positive
    private Integer age;

    @NotBlank
    @Size(max = 50)
    private String city;

    public Owner(String name, Integer age, String city) {
        this.name = name;
        this.age = age;
        this.city = city;
    }

    public Owner() {
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
