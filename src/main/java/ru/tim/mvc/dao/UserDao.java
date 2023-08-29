package ru.tim.mvc.dao;


import ru.tim.mvc.model.User;
import java.util.List;

public interface UserDao {

     List<User> showAll();
     User showById(int id);
     void create(User user);
     void update(int id, User newPerson);
     void delete(int id);


}
