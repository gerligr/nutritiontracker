package com.valiit.listedcompaniesapi.model;

import com.valiit.listedcompaniesapi.dto.PersonMenuDto;

public class CalculateResponse {
    private int totalEnergy;
    private int totalProteins;
    private int totalFats;
    private int totalCarbs;
    private int childId;
    private PersonMenuDto personMenu;

    public CalculateResponse() {
    }

    public CalculateResponse(int totalEnergy, int totalProteins, int totalFats, int totalCarbs, int childId, PersonMenuDto personMenu) {
        this.totalEnergy = totalEnergy;
        this.totalProteins = totalProteins;
        this.totalFats = totalFats;
        this.totalCarbs = totalCarbs;
        this.childId = childId;
        this.personMenu = personMenu;
    }

    public int getTotalEnergy() {
        return totalEnergy;
    }

    public void setTotalEnergy(int totalEnergy) {
        this.totalEnergy = totalEnergy;
    }

    public int getTotalProteins() {
        return totalProteins;
    }

    public void setTotalProteins(int totalProteins) {
        this.totalProteins = totalProteins;
    }

    public int getTotalFats() {
        return totalFats;
    }

    public void setTotalFats(int totalFats) {
        this.totalFats = totalFats;
    }

    public int getTotalCarbs() {
        return totalCarbs;
    }

    public void setTotalCarbs(int totalCarbs) {
        this.totalCarbs = totalCarbs;
    }

    public int getChildId() {
        return childId;
    }

    public void setChildId(int childId) {
        this.childId = childId;
    }

    public PersonMenuDto getPersonMenu() {
        return personMenu;
    }

    public void setPersonMenu(PersonMenuDto personMenu) {
        this.personMenu = personMenu;
    }
}
