package com.valiit.listedcompaniesapi.model;

public class Menu {
    private int id;
    private String name;
    private int energy;
    private int protein;
    private int fat;
    private int carb;
    private String ingredients;
    private String instructions;

    public Menu() {
    }

    public Menu(int id, String name, int energy, int protein, int fat, int carb, String ingredients, String instructions) {
        this.id = id;
        this.name = name;
        this.energy = energy;
        this.protein = protein;
        this.fat = fat;
        this.carb = carb;
        this.ingredients = ingredients;
        this.instructions = instructions;
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

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public int getProtein() {
        return protein;
    }

    public void setProtein(int protein) {
        this.protein = protein;
    }

    public int getFat() {
        return fat;
    }

    public void setFat(int fat) {
        this.fat = fat;
    }

    public int getCarb() {
        return carb;
    }

    public void setCarb(int carb) {
        this.carb = carb;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }
}
