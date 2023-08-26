package ru.tim.mvc.PersonDao;

import org.springframework.stereotype.Component;
import ru.tim.mvc.model.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDao {
    private static int ID_NUM = 0;
    List<Person> list = new ArrayList<>();

    {
        list.add(new Person(++ID_NUM, "Tim"));
        list.add(new Person(++ID_NUM, "Sam"));
        list.add(new Person(++ID_NUM, "Tom"));
        list.add(new Person(++ID_NUM, "Mary"));
        list.add(new Person(++ID_NUM, "Mia"));


    }

    public List<Person> index(){
        return list;
    }

    public Person show(int id){
        return list.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

//    public void create(String name){
//        list.add(new Person(++ID_NUM, name));
//    }

    public void create(Person person){
        person.setId(++ID_NUM);
        list.add(person);
    }

    public void update(int id, Person newPerson){
        Person personTOBeUpdated = show(id);
        personTOBeUpdated.setName(newPerson.getName());
    }


    public void delete(int id) {
        list.removeIf(el->el.getId()==id);
    }
}
