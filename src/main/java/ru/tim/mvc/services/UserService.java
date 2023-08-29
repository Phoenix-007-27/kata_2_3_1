package ru.tim.mvc.services;

import ru.tim.mvc.model.Person;
import java.util.List;

public interface UserService {

    List<Person> findAll();

    Person findById(int id);

    void save(Person person);

    void update(int id, Person newPerson);

    void delete(int id);

}
