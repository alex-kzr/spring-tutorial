package com.alexkozyura.tutorial.dao;

import com.alexkozyura.tutorial.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<User> index() {
        return jdbcTemplate.query("SELECT * FROM app_user",
                new BeanPropertyRowMapper<>(User.class));
    }

    public User show(int id) {
        return jdbcTemplate.query("SELECT * FROM app_user WHERE id=?",
                new BeanPropertyRowMapper<>(User.class),
                id)
                    .stream()
                    .findAny()
                    .orElse(null);
    }

    public void save(User user) {
        jdbcTemplate.update("INSERT INTO app_user VALUES (1, ?, ?, ?)",
                user.getName(),
                user.getAge(),
                user.getEmail());
    }

    public void update(int id, User updatedUser) {
        jdbcTemplate.update("UPDATE app_user SET name=?, age=?, email=? WHERE id=?",
                updatedUser.getName(),
                updatedUser.getAge(),
                updatedUser.getEmail(),
                updatedUser.getId());
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM app_user WHERE id=?", id);
    }
}
