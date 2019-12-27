package com.valiit.listedcompaniesapi.repository;

import com.valiit.listedcompaniesapi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public boolean userExists(String username) {
        Integer count = jdbcTemplate.queryForObject(
                "select count(id) from user where username = ?",
                new Object[]{username},
                Integer.class
        );
        return count != null && count > 0;
    }

    public void addUser(User user) {
        jdbcTemplate.update("insert into `user` (`username`, `password`, `name`, `email`) values (?, ?, ?, ?)",
                user.getUsername(), user.getPassword(), user.getName(), user.getEmail());
    }

    public User getUserByUsername(String username) {
        List<User> users = jdbcTemplate.query(
                "select * from `user` where `username` = ?",
                new Object[]{username},
                (rs, rowNum) -> new User(rs.getInt("id"), rs.getString("username"), rs.getString("name"), rs.getString("password"), rs.getString("email"))
        );
        return users.size() > 0 ? users.get(0) : null;
    }
}
