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

        users.add(new User(++PEOPLE_COUNT, "John"));
        users.add(new User(++PEOPLE_COUNT, "Jack"));
        users.add(new User(++PEOPLE_COUNT, "Jasper"));
        users.add(new User(++PEOPLE_COUNT, "Jayson"));
    }

    public List<User> index() {
        return users;
    }

    public User show(int id) {
        return users.stream().filter(user -> user.getId() == id).findAny().orElse(null);
    }
}
