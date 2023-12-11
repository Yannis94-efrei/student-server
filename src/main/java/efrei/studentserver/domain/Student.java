package efrei.studentserver.domain;

import jakarta.persistence.*;

@Entity
public class Student {
    @Id
    @SequenceGenerator(
            name = "sequenceGenerator",
            sequenceName = "RTDS_ADSINPUT_SEQ",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "sequenceGenerator")
    private Integer id;
    private Integer age;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
