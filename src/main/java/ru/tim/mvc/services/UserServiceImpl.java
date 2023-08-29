package ru.tim.mvc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.tim.mvc.dao.PersonDao;
import ru.tim.mvc.model.Person;

import java.util.List;
import java.util.Optional;


@Service
public class UserServiceImpl
        implements UserService {

    private PersonDao personDao;

    @Autowired
    public UserServiceImpl(PersonDao personDao) {
        this.personDao = personDao;
    }

    @Override
    public List<Person> findAll() {
        return personDao.showAll();
    }
    @Override
    public Person findById(int id) {
        Optional<Person> optional = Optional.ofNullable(personDao.showById(id));
        return optional.orElse(null);
    }

    @Override
    public void save(Person person) {
        personDao.create(person);
    }

    @Override
    public void update(int id, Person newPerson) {
        newPerson.setId(id);
        personDao.update(id, newPerson);
    }

    @Override
    public void delete(int id) {
        personDao.delete(id);
    }


}
