package com.valiit.listedcompaniesapi.repository;

import com.valiit.listedcompaniesapi.model.Child;
import com.valiit.listedcompaniesapi.model.Company;
import com.valiit.listedcompaniesapi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ChildRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void addChild(Child child) {
        jdbcTemplate.update(
                "insert into person (user_id, name, photo, age, gender, physical_activity) values (?, ?, ?, ?, ?, ?)",
                child.getParentId(), child.getName(), child.getPhoto(), child.getAge(), child.getGender(), child.getPhysicalActivity()
        );
    }

    public void updateChild(Child child) {
        jdbcTemplate.update(
                "update person set user_id = ?, name = ?, photo = ?, age = ?, gender = ?, physical_activity = ? where id = ?",
                child.getParentId(), child.getName(), child.getPhoto(), child.getAge(), child.getGender(), child.getPhysicalActivity(), child.getId()
        );
    }

    public void deleteChild(int id) {
        jdbcTemplate.update("delete from person where id = ?", id);
    }

    public List<Child> getUserChildren(int userId) {
        return jdbcTemplate.query("select * from person where user_id = ?", new Object[]{userId}, mapChildRows);
//        return children.size() > 0 ? (List<Child>) children.get(0) : null;
    }
    public Child getChild(int id) {
        List<Child> children = jdbcTemplate.query("select * from person where id = ?", new Object[]{id}, mapChildRows);
        return children.size() > 0 ? children.get(0) : null;
    }

    private RowMapper<Child> mapChildRows = (rs, rowNum) -> {
        Child child = new Child();
        child.setId(rs.getInt("id"));
        child.setName(rs.getString("name"));
        child.setPhoto(rs.getString("photo"));
        child.setAge(rs.getInt("age"));
        child.setGender(rs.getString("gender"));
        child.setPhysicalActivity(rs.getString("physical_activity"));
        child.setParentId(rs.getInt("user_id"));
        return child;
    };
}


