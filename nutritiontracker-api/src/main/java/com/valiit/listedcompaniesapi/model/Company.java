package com.valiit.listedcompaniesapi.model;

import java.time.LocalDate;

public class Company {

    private Integer id;
    private String name;
    private String logo;
    private LocalDate established;
    private Integer employees;
    private Double revenue;
    private Double netIncome;
    private Integer securities;
    private Double securityPrice;
    private Double dividends;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public LocalDate getEstablished() {
        return established;
    }

    public void setEstablished(LocalDate established) {
        this.established = established;
    }

    public Integer getEmployees() {
        return employees;
    }

    public void setEmployees(Integer employees) {
        this.employees = employees;
    }

    public Double getRevenue() {
        return revenue;
    }

    public void setRevenue(Double revenue) {
        this.revenue = revenue;
    }

    public Double getNetIncome() {
        return netIncome;
    }

    public void setNetIncome(Double netIncome) {
        this.netIncome = netIncome;
    }

    public Integer getSecurities() {
        return securities;
    }

    public void setSecurities(Integer securities) {
        this.securities = securities;
    }

    public Double getSecurityPrice() {
        return securityPrice;
    }

    public void setSecurityPrice(Double securityPrice) {
        this.securityPrice = securityPrice;
    }

    public Double getDividends() {
        return dividends;
    }

    public void setDividends(Double dividends) {
        this.dividends = dividends;
    }
}
