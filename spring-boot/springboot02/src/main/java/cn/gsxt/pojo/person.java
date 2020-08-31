package cn.gsxt.pojo;

import org.hibernate.validator.constraints.Length;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Component
@ConfigurationProperties(prefix = "person")
@Validated
public class person {
    private String name;
    @Length(max = 5)
    private String email;
    private Integer age;
    private Boolean happy;
    private Date bitrh;
    private Map<String, Object> maps;
    private List<Object> lists;
    private Dog dog;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public person() {
    }


    public person(String name, @Email @Length(max = 5) String email, Integer age, Boolean happy, Date bitrh, Map<String, Object> maps, List<Object> lists, Dog dog) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.happy = happy;
        this.bitrh = bitrh;
        this.maps = maps;
        this.lists = lists;
        this.dog = dog;
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

    public Boolean getHappy() {
        return happy;
    }

    public void setHappy(Boolean happy) {
        this.happy = happy;
    }

    public Date getBitrh() {
        return bitrh;
    }

    public void setBitrh(Date bitrh) {
        this.bitrh = bitrh;
    }

    public Map<String, Object> getMaps() {
        return maps;
    }

    public void setMaps(Map<String, Object> maps) {
        this.maps = maps;
    }

    public List<Object> getLists() {
        return lists;
    }

    public void setLists(List<Object> lists) {
        this.lists = lists;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    @Override
    public String toString() {
        return "person{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", happy=" + happy +
                ", bitrh=" + bitrh +
                ", maps=" + maps +
                ", lists=" + lists +
                ", dog=" + dog +
                '}';
    }
}
