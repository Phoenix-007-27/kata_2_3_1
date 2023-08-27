package ru.tim.mvc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.tim.mvc.model.Person;

@Repository
public interface PeopleRepository extends JpaRepository<Person, Integer> {

}
