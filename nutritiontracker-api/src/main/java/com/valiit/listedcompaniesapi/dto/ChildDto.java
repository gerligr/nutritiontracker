package com.valiit.listedcompaniesapi.dto;

import com.valiit.listedcompaniesapi.model.CalculateResponse;
import com.valiit.listedcompaniesapi.model.NutritionData;

public class ChildDto {
    private int id;
    private String name;
    private String photo;
    private int age;
    private String gender;
    private String physicalActivity;
    private int parentId;
    private PersonMenuDto menu;
    private CalculateResponseDto calculation;
    private NutritionDataDto nutrition;

    public NutritionDataDto getNutrition() {
        return nutrition;
    }

    public void setNutrition(NutritionDataDto nutrition) {
        this.nutrition = nutrition;
    }

    public CalculateResponseDto getCalculation() {
        return calculation;
    }

    public void setCalculation(CalculateResponseDto calculation) {
        this.calculation = calculation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhysicalActivity() {
        return physicalActivity;
    }

    public void setPhysicalActivity(String physicalActivity) {
        this.physicalActivity = physicalActivity;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public PersonMenuDto getMenu() {
        return menu;
    }

    public void setMenu(PersonMenuDto menu) {
        this.menu = menu;
    }
}
