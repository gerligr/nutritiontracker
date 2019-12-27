package com.valiit.listedcompaniesapi.model;

public class PersonMenu {
    private int id;
    private int personId;
    private String breakfast;
    private int breakfastAmount;
    private String lunchsnack;
    private int lunchsnackAmount;
    private String lunch;
    private int lunchAmount;
    private String dinnersnack;
    private int dinnersnackAmount;
    private String dinner;
    private int dinnerAmount;

    public PersonMenu() {
    }

    public PersonMenu(int id, int personId, String breakfast, int breakfastAmount, String lunchsnack, int lunchsnackAmount, String lunch, int lunchAmount, String dinnersnack, int dinnersnackAmount, String dinner, int dinnerAmount) {
        this.id = id;
        this.personId = personId;
        this.breakfast = breakfast;
        this.breakfastAmount = breakfastAmount;
        this.lunchsnack = lunchsnack;
        this.lunchsnackAmount = lunchsnackAmount;
        this.lunch = lunch;
        this.lunchAmount = lunchAmount;
        this.dinnersnack = dinnersnack;
        this.dinnersnackAmount = dinnersnackAmount;
        this.dinner = dinner;
        this.dinnerAmount = dinnerAmount;
    }

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

    public String getBreakfast() {
        return breakfast;
    }

    public void setBreakfast(String breakfast) {
        this.breakfast = breakfast;
    }

    public int getBreakfastAmount() {
        return breakfastAmount;
    }

    public void setBreakfastAmount(int breakfastAmount) {
        this.breakfastAmount = breakfastAmount;
    }

    public String getLunchsnack() {
        return lunchsnack;
    }

    public void setLunchsnack(String lunchsnack) {
        this.lunchsnack = lunchsnack;
    }

    public int getLunchsnackAmount() {
        return lunchsnackAmount;
    }

    public void setLunchsnackAmount(int lunchsnackAmount) {
        this.lunchsnackAmount = lunchsnackAmount;
    }

    public String getLunch() {
        return lunch;
    }

    public void setLunch(String lunch) {
        this.lunch = lunch;
    }

    public int getLunchAmount() {
        return lunchAmount;
    }

    public void setLunchAmount(int lunchAmount) {
        this.lunchAmount = lunchAmount;
    }

    public String getDinnersnack() {
        return dinnersnack;
    }

    public void setDinnersnack(String dinnersnack) {
        this.dinnersnack = dinnersnack;
    }

    public int getDinnersnackAmount() {
        return dinnersnackAmount;
    }

    public void setDinnersnackAmount(int dinnersnackAmount) {
        this.dinnersnackAmount = dinnersnackAmount;
    }

    public String getDinner() {
        return dinner;
    }

    public void setDinner(String dinner) {
        this.dinner = dinner;
    }

    public int getDinnerAmount() {
        return dinnerAmount;
    }

    public void setDinnerAmount(int dinnerAmount) {
        this.dinnerAmount = dinnerAmount;
    }
}
