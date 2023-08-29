package ru.tim.mvc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.tim.mvc.dao.PersonDao;
import ru.tim.mvc.model.Person;
import java.util.List;
import java.util.Optional;


@Service
@Transactional(readOnly = true)
public class PeopleServiceImpl  {

    private  PersonDao personDao;

    @Autowired
    public PeopleServiceImpl(PersonDao personDao) {
        this.personDao = personDao;
    }


    public List<Person> findAll() {
       return personDao.showAll();
    }

    public Person findById(int id){
        Optional<Person> optional = Optional.ofNullable(personDao.showById(id));
        return optional.orElse(null);
    }

    @Transactional
    public void save(Person person){
        personDao.create(person);
    }

    @Transactional
    public void update(int id, Person newPerson){
        newPerson.setId(id);
        personDao.update(id, newPerson);
    }

    @Transactional
    public void delete(int id){
        personDao.delete(id);
    }



}
