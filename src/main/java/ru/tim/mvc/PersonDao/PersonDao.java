//package ru.tim.mvc.PersonDao;
//
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//import ru.tim.mvc.model.Person;
//
//import java.util.List;
//
////@Component
//@Service
//public class PersonDao {
//
//    private final SessionFactory sessionFactory;
//
//    @Autowired
//    public PersonDao(SessionFactory sessionFactory) {
//        this.sessionFactory = sessionFactory;
//    }
//
//
//    @Transactional(readOnly = true)
//    public List<Person> index() {
//        Session session = sessionFactory.getCurrentSession();
//        List<Person> personList = session.createQuery("select p from Person p", Person.class).getResultList();
//        return personList;
//    }
//
//    @Transactional
//    public Person show(int id) {
//
//        Session session = sessionFactory.getCurrentSession();
//        return session.get(Person.class, id);
//
//    }
//
//    @Transactional
//    public void create(Person person) {
//        Session session = sessionFactory.getCurrentSession();
//        session.save(person);
//    }
//
//    @Transactional
//    public void update(int id, Person newPerson) {
//        Session session = sessionFactory.getCurrentSession();
//        Person ToUpdatePerson = session.get(Person.class, id);
//        ToUpdatePerson.setName(newPerson.getName());
//
//    }
//
//    @Transactional
//    public void delete(int id) {
//        Session session = sessionFactory.getCurrentSession();
//        session.remove(session.get(Person.class, id));
//
//    }
//}
