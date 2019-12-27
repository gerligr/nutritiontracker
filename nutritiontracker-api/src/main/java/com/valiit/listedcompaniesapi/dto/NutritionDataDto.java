package com.valiit.listedcompaniesapi.dto;

public class NutritionDataDto {
    private int id;
    private int personId;
    private String gender;
    private int age;
    private String physicalActivity;
    private int energy;
    private int proteinMin;
    private int proteinMax;
    private int fatMin;
    private int fatMax;
    private int carbMin;
    private int carbMax;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhysicalActivity() {
        return physicalActivity;
    }

    public void setPhysicalActivity(String physicalActivity) {
        this.physicalActivity = physicalActivity;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public int getProteinMin() {
        return proteinMin;
    }

    public void setProteinMin(int proteinMin) {
        this.proteinMin = proteinMin;
    }

    public int getProteinMax() {
        return proteinMax;
    }

    public void setProteinMax(int proteinMax) {
        this.proteinMax = proteinMax;
    }

    public int getFatMin() {
        return fatMin;
    }

    public void setFatMin(int fatMin) {
        this.fatMin = fatMin;
    }

    public int getFatMax() {
        return fatMax;
    }

    public void setFatMax(int fatMax) {
        this.fatMax = fatMax;
    }

    public int getCarbMin() {
        return carbMin;
    }

    public void setCarbMin(int carbMin) {
        this.carbMin = carbMin;
    }

    public int getCarbMax() {
        return carbMax;
    }

    public void setCarbMax(int carbMax) {
        this.carbMax = carbMax;
    }
}

