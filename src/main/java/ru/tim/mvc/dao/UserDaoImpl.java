package ru.tim.mvc.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.tim.mvc.model.User;
import javax.persistence.EntityManager;
import java.util.List;


@Repository
@Transactional
public class UserDaoImpl implements UserDao {

    private  EntityManager entityManager;

    @Autowired
    public UserDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;

    }
    @Override
    public List<User> showAll() {
        List<User> userList = entityManager.createQuery("select p from User p", User.class).getResultList();
        return userList;
    }
    @Override
    public User showById(int id) {
        return entityManager.find(User.class, id);

    }
    @Override
    public void create(User user) {
        entityManager.persist(user);
    }
    @Override
    public void update(int id, User newUser) {
        User toUpdateUser = entityManager.find(User.class, id);
        toUpdateUser.setName(newUser.getName());
        toUpdateUser.setAge(newUser.getAge());


    }
    @Override
    public void delete(int id) {
        entityManager.remove(entityManager.find(User.class, id));
    }
  }
