package ru.tim.mvc.services;

import ru.tim.mvc.model.User;
import java.util.List;

public interface UserService {

    List<User> findAll();

    User findById(int id);

    void save(User user);

    void update(int id, User newUser);

    void delete(int id);

}
