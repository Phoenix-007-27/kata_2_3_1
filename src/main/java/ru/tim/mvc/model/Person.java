package ru.tim.mvc.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Person")
public class Person {


    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "name should not be empty")
    @Size(min = 2, max = 10, message = "min 2 and max 10 letters")
//    @Email(message = "email wrong")
    @Column
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person() {

    }

    public Person(String name) {
        this.name = name;
    }
}
