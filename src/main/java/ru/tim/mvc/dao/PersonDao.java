package ru.tim.mvc.dao;


import ru.tim.mvc.model.Person;
import java.util.List;

public interface PersonDao {

     List<Person> showAll();
     Person showById(int id);
     void create(Person person);
     void update(int id, Person newPerson);
     void delete(int id);


}
