package com.valiit.listedcompaniesapi.model;

public class Child {
    private int id;
    private String name;
    private String photo;
    private int age;
    private String gender;
    private String physicalActivity;
    private int parentId;
    private PersonMenu menu;
    private CalculateResponse calculation;
    private NutritionData nutrition;

    public Child() {

    }

    public Child(int id, String name, String photo, int age, String gender, String physicalActivity) {
        this.id = id;
        this.name = name;
        this.photo = photo;
        this.age = age;
        this.gender = gender;
        this.physicalActivity = physicalActivity;
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

    public CalculateResponse getCalculation() {
        return calculation;
    }

    public void setCalculation(CalculateResponse calculation) {
        this.calculation = calculation;
    }

    public PersonMenu getMenu() {
        return menu;
    }

    public void setMenu(PersonMenu menu) {
        this.menu = menu;
    }

    public NutritionData getNutrition() {
        return nutrition;
    }

    public void setNutrition(NutritionData nutrition) {
        this.nutrition = nutrition;
    }
}
