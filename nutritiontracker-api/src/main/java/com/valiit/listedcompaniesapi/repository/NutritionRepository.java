package com.valiit.listedcompaniesapi.repository;

import com.valiit.listedcompaniesapi.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class NutritionRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public NutritionData getChildNutritionData(int childId) {
        List<NutritionData> nutrition = jdbcTemplate.query("SELECT p.id as person_id, dc.id, dc.energy, dc.protein_min, dc.protein_max, dc.fat_min, dc.fat_max, dc.carb_min, dc.carb_max " +
                "FROM data_calculation dc " +
                "INNER JOIN person p ON p.age = dc.age AND p.gender = dc.gender AND p.physical_activity = dc.physical_activity WHERE p.id = ?",
                new Object[]{childId}, mapDataRows);
        return nutrition.size() > 0 ? nutrition.get(0) : null;
    }
    private RowMapper<NutritionData> mapDataRows = (rs, rowNum) -> {
        NutritionData nutritionData = new NutritionData();
        nutritionData.setId(rs.getInt("id"));
        nutritionData.setPersonId(rs.getInt("person_id"));
        nutritionData.setEnergy(rs.getInt("energy"));
        nutritionData.setProteinMin(rs.getInt("protein_min"));
        nutritionData.setProteinMax(rs.getInt("protein_max"));
        nutritionData.setFatMin(rs.getInt("fat_min"));
        nutritionData.setFatMax(rs.getInt("fat_max"));
        nutritionData.setCarbMin(rs.getInt("carb_min"));
        nutritionData.setCarbMax(rs.getInt("carb_max"));
        return nutritionData;
    };

    // getmenu, lapse ID kaasa
    public PersonMenu getChildMenuData(int childId) {
        List<PersonMenu> menu = jdbcTemplate.query("SELECT id, person_id, breakfast, breakfast_amount, lunchsnack, lunchsnack_amount, lunch, lunch_amount, dinnersnack, " +
                        "                        dinnersnack_amount, dinner, dinner_amount FROM person_menu WHERE person_id = ?",
                new Object[]{childId}, mapMenuRows);
        return menu.size() > 0 ? menu.get(0) : null;
    }
    private RowMapper<PersonMenu> mapMenuRows = (rs, rowNum) -> {
        PersonMenu personMenu = new PersonMenu();
        personMenu.setId(rs.getInt("id"));
        personMenu.setPersonId(rs.getInt("person_id"));
        personMenu.setBreakfast(rs.getString("breakfast"));
        personMenu.setBreakfastAmount(rs.getInt("breakfast_amount"));
        personMenu.setLunchsnack(rs.getString("lunchsnack"));
        personMenu.setLunchsnackAmount(rs.getInt("lunchsnack_amount"));
        personMenu.setLunch(rs.getString("lunch"));
        personMenu.setLunchAmount(rs.getInt("lunch_amount"));
        personMenu.setDinnersnack(rs.getString("dinnersnack"));
        personMenu.setDinnersnackAmount(rs.getInt("dinnersnack_amount"));
        personMenu.setDinner(rs.getString("dinner"));
        personMenu.setDinnerAmount(rs.getInt("dinner_amount"));
        return personMenu;
    };


    public void addMenu(PersonMenu personMenu) {
        jdbcTemplate.update(
                "insert into person_menu (id, person_id, breakfast, breakfast_amount, lunchsnack, lunchsnack_amount, lunch, lunch_amount, dinnersnack, " +
                        "dinnersnack_amount, dinner, dinner_amount) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                personMenu.getId(), personMenu.getPersonId(), personMenu.getBreakfast(), personMenu.getBreakfastAmount(), personMenu.getLunchsnack(), personMenu.getLunchsnackAmount(),
                personMenu.getLunch(), personMenu.getLunchAmount(), personMenu.getDinnersnack(), personMenu.getDinnersnackAmount(), personMenu.getDinner(),
                personMenu.getDinnerAmount()
        );
    }

    public void updateMenu(PersonMenu personMenu) {
        jdbcTemplate.update(
                "update person_menu set person_id = ?, breakfast = ?, breakfast_amount = ?, lunchsnack = ?, lunchsnack_amount = ?, lunch = ?, lunch_amount = ?, dinnersnack = ?, dinnersnack_amount = ?, dinner = ?, dinner_amount = ? where id = ?",
                personMenu.getPersonId(), personMenu.getBreakfast(), personMenu.getBreakfastAmount(), personMenu.getLunchsnack(), personMenu.getLunchsnackAmount(),
                personMenu.getLunch(), personMenu.getLunchAmount(), personMenu.getDinnersnack(), personMenu.getDinnersnackAmount(), personMenu.getDinner(),
                personMenu.getDinnerAmount(), personMenu.getId()
        );
    }

    public boolean personMenuExists(PersonMenu personMenu) {
        Integer count = jdbcTemplate.queryForObject("select count(person_id) from person_menu where person_id = ?", new Object[]{personMenu.getPersonId()}, Integer.class);
        return count != null && count > 0;
    }

    public CalculateResponse getChildMenuCalculation(int childId) {
        List<CalculateResponse> calculation = jdbcTemplate.query("select sum(menucalcs.energy) as energy, sum(menucalcs.protein) as protein, sum(menucalcs.fat) as fat, sum(menucalcs.carb) as carb " +
                "from(select(m.energy * pm.breakfast_amount / 100) as energy, (m.protein * pm.breakfast_amount / 100) as protein, (m.fat * pm.breakfast_amount / 100) as fat, (m.carb * pm.breakfast_amount / 100) as carb " +
                "from menu m inner join person_menu pm on m.id = pm.breakfast where pm.person_id = ? union all " +
                "select(m.energy * pm.lunchsnack_amount / 100) as energy, (m.protein * pm.lunchsnack_amount / 100) as protein, (m.fat * pm.lunchsnack_amount / 100) as fat, (m.carb * pm.lunchsnack_amount / 100) as carb " +
                "from menu m inner join person_menu pm on m.id = pm.lunchsnack where pm.person_id = ? union all " +
                "select(m.energy * pm.lunch_amount / 100) as energy, (m.protein * pm.lunch_amount / 100) as protein, (m.fat * pm.lunch_amount / 100) as fat, (m.carb * pm.lunch_amount / 100) as carb "+
                "from menu m inner join person_menu pm on m.id = pm.lunch where pm.person_id = ? union all " +
                "select(m.energy * pm.dinnersnack_amount / 100) as energy, (m.protein * pm.dinnersnack_amount / 100) as protein, (m.fat * pm.dinnersnack_amount / 100) as fat, (m.carb * pm.dinnersnack_amount / 100) as carb " +
                "from menu m inner join person_menu pm on m.id = pm.dinnersnack where pm.person_id = ? union all " +
                "select(m.energy * pm.dinner_amount / 100) as energy, (m.protein * pm.dinner_amount / 100) as protein, (m.fat * pm.dinner_amount / 100) as fat, (m.carb * pm.dinner_amount / 100) as carb " +
                "from menu m inner join person_menu pm on m.id = pm.dinner where pm.person_id = ? ) menucalcs", new Object[]{childId, childId, childId, childId, childId}, mapMenuCalcsRows);

        return calculation.size() > 0 ? calculation.get(0) : null;
    }

    private RowMapper<CalculateResponse> mapMenuCalcsRows = (rs, rowNum) -> {
        CalculateResponse calculateResponse = new CalculateResponse();
        calculateResponse.setTotalEnergy(rs.getInt("energy"));
        calculateResponse.setTotalProteins(rs.getInt("protein"));
        calculateResponse.setTotalFats(rs.getInt("fat"));
        calculateResponse.setTotalCarbs(rs.getInt("carb"));

        return calculateResponse;
    };


}
