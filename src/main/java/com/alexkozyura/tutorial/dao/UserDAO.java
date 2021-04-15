package com.alexkozyura.tutorial.dao;

import com.alexkozyura.tutorial.models.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDAO {
    private static int PEOPLE_COUNT;
    private List<User> users;

    {
        users = new ArrayList<>();

        users.add(new User(++PEOPLE_COUNT, "John", 24, "john@connor.it"));
        users.add(new User(++PEOPLE_COUNT, "Jack", 45, "jack@mini.com"));
        users.add(new User(++PEOPLE_COUNT, "Jasper", 57, "jasper@noname.ru"));
        users.add(new User(++PEOPLE_COUNT, "Jayson", 35, "jayson@vrh.com"));
    }

    public List<User> index() {
        return users;
    }

    public User show(int id) {
        return users.stream().filter(user -> user.getId() == id).findAny().orElse(null);
    }

    public void save(User user) {
        user.setId(++PEOPLE_COUNT);
        users.add(user);
    }

    public void update(int id, User updatedUser) {
        User userToBeUpdated = show(id);
        userToBeUpdated.setName(updatedUser.getName());
        userToBeUpdated.setAge(updatedUser.getAge());
        userToBeUpdated.setEmail(updatedUser.getEmail());
    }

    public void delete(int id) {
        users.removeIf(user -> user.getId() == id);
    }
}
