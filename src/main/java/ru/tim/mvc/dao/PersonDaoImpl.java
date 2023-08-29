package ru.tim.mvc.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.tim.mvc.model.Person;
import javax.persistence.EntityManager;
import java.util.List;


@Repository
@Transactional
public class PersonDaoImpl implements PersonDao{

    private  EntityManager entityManager;

    @Autowired
    public PersonDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;

    }
    @Override
    public List<Person> showAll() {
        List<Person> personList = entityManager.createQuery("select p from Person p", Person.class).getResultList();
        return personList;
    }
    @Override
    public Person showById(int id) {
        return entityManager.find(Person.class, id);

    }
    @Override
    public void create(Person person) {
        entityManager.persist(person);
    }
    @Override
    public void update(int id, Person newPerson) {
        Person ToUpdatePerson = entityManager.find(Person.class, id);
        ToUpdatePerson.setName(newPerson.getName());

    }
    @Override
    public void delete(int id) {
        entityManager.remove(entityManager.find(Person.class, id));
    }
  }
