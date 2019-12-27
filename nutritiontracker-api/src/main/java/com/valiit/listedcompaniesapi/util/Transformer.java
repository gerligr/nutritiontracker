package com.valiit.listedcompaniesapi.util;

import com.valiit.listedcompaniesapi.dto.*;
import com.valiit.listedcompaniesapi.model.*;

public class Transformer {

    public static Company toCompanyModel(CompanyDto initialObject) {
        if (initialObject == null) {
            return null;
        }

        Company resultingObject = new Company();
        resultingObject.setId(initialObject.getId());
        resultingObject.setName(initialObject.getName());
        resultingObject.setLogo(initialObject.getLogo());
        resultingObject.setEstablished(initialObject.getEstablished());
        resultingObject.setEmployees(initialObject.getEmployees());
        resultingObject.setRevenue(initialObject.getRevenue());
        resultingObject.setNetIncome(initialObject.getNetIncome());
        resultingObject.setSecurities(initialObject.getSecurities());
        resultingObject.setSecurityPrice(initialObject.getSecurityPrice());
        resultingObject.setDividends(initialObject.getDividends());
        return resultingObject;
    }

    public static CompanyDto toCompanyDto(Company initialObject) {
        if (initialObject == null) {
            return null;
        }

        CompanyDto resultingObject = new CompanyDto();
        resultingObject.setId(initialObject.getId());
        resultingObject.setName(initialObject.getName());
        resultingObject.setLogo(initialObject.getLogo());
        resultingObject.setEstablished(initialObject.getEstablished());
        resultingObject.setEmployees(initialObject.getEmployees());
        resultingObject.setRevenue(initialObject.getRevenue());
        resultingObject.setNetIncome(initialObject.getNetIncome());
        resultingObject.setSecurities(initialObject.getSecurities());
        resultingObject.setSecurityPrice(initialObject.getSecurityPrice());
        resultingObject.setDividends(initialObject.getDividends());

        if (initialObject.getSecurities() > 0 && initialObject.getSecurityPrice() > 0) {
            Double marketCapitalization = Helper.round(initialObject.getSecurities() * initialObject.getSecurityPrice());
            resultingObject.setMarketCapitalization(marketCapitalization);
        }

        if (initialObject.getSecurityPrice() > 0 && initialObject.getDividends() > 0) {
            Double dividendYield = Helper.round(initialObject.getDividends() / initialObject.getSecurityPrice());
            resultingObject.setDividendYield(dividendYield);
        }

        return resultingObject;
    }

    public static Child toChildModel(ChildDto initialObject) {
        if (initialObject == null) {
            return null;
        }
        Child resultingObject = new Child();
        resultingObject.setId(initialObject.getId());
        resultingObject.setName(initialObject.getName());
        resultingObject.setPhoto(initialObject.getPhoto());
        resultingObject.setAge(initialObject.getAge());
        resultingObject.setGender(initialObject.getGender());
        resultingObject.setPhysicalActivity(initialObject.getPhysicalActivity());
        resultingObject.setParentId(initialObject.getParentId());
        return resultingObject;
    }

    public static CalculateResponseDto toCalculateResponseDto(CalculateResponse initialObject) {
        if (initialObject == null) {
            return null;
        }
        CalculateResponseDto resultingObject = new CalculateResponseDto();
        resultingObject.setTotalEnergy(initialObject.getTotalEnergy());
        resultingObject.setTotalProteins(initialObject.getTotalProteins());
        resultingObject.setTotalFats(initialObject.getTotalFats());
        resultingObject.setTotalCarbs(initialObject.getTotalCarbs());
        resultingObject.setChildId(initialObject.getChildId());
        return resultingObject;
    }

    public static CalculateResponse toCalculateResponse(CalculateResponseDto initialObject) {
        if (initialObject == null) {
            return null;
        }
        CalculateResponse resultingObject = new CalculateResponse();
        resultingObject.setTotalEnergy(initialObject.getTotalEnergy());
        resultingObject.setTotalProteins(initialObject.getTotalProteins());
        resultingObject.setTotalFats(initialObject.getTotalFats());
        resultingObject.setTotalCarbs(initialObject.getTotalCarbs());
        resultingObject.setChildId(initialObject.getChildId());
        return resultingObject;

    }

    public static PersonMenuDto toPersonMenuDto(PersonMenu initialObject) {
        if (initialObject == null) {
            return null;
        }
        PersonMenuDto resultingObject = new PersonMenuDto();
        resultingObject.setId(initialObject.getId());
        resultingObject.setPersonId(initialObject.getPersonId());
        resultingObject.setBreakfast(initialObject.getBreakfast());
        resultingObject.setBreakfastAmount(initialObject.getBreakfastAmount());
        resultingObject.setLunchsnack(initialObject.getLunchsnack());
        resultingObject.setLunchsnackAmount(initialObject.getLunchsnackAmount());
        resultingObject.setLunch(initialObject.getLunch());
        resultingObject.setLunchAmount(initialObject.getLunchAmount());
        resultingObject.setDinnersnack(initialObject.getDinnersnack());
        resultingObject.setDinnersnackAmount(initialObject.getDinnersnackAmount());
        resultingObject.setDinner(initialObject.getDinner());
        resultingObject.setDinnerAmount(initialObject.getDinnerAmount());
        return resultingObject;
    }

    public static PersonMenu toPersonMenuModel(PersonMenuDto initialObject) {
        if (initialObject == null) {
            return null;
        }
        PersonMenu resultingObject = new PersonMenu();
        resultingObject.setId(initialObject.getId());
        resultingObject.setPersonId(initialObject.getPersonId());
        resultingObject.setBreakfast(initialObject.getBreakfast());
        resultingObject.setBreakfastAmount(initialObject.getBreakfastAmount());
        resultingObject.setLunchsnack(initialObject.getLunchsnack());
        resultingObject.setLunchsnackAmount(initialObject.getLunchsnackAmount());
        resultingObject.setLunch(initialObject.getLunch());
        resultingObject.setLunchAmount(initialObject.getLunchAmount());
        resultingObject.setDinnersnack(initialObject.getDinnersnack());
        resultingObject.setDinnersnackAmount(initialObject.getDinnersnackAmount());
        resultingObject.setDinner(initialObject.getDinner());
        resultingObject.setDinnerAmount(initialObject.getDinnerAmount());
        return resultingObject;
    }

    public static ChildDto toChildDto(Child initialObject) {
        if (initialObject == null) {
            return null;
        }
        ChildDto resultingObject = new ChildDto();
        resultingObject.setId(initialObject.getId());
        resultingObject.setName(initialObject.getName());
        resultingObject.setPhoto(initialObject.getPhoto());
        resultingObject.setAge(initialObject.getAge());
        resultingObject.setGender(initialObject.getGender());
        resultingObject.setPhysicalActivity(initialObject.getPhysicalActivity());
        resultingObject.setParentId(initialObject.getParentId());
        resultingObject.setMenu(toPersonMenuDto(initialObject.getMenu()));
        resultingObject.setCalculation(toCalculateResponseDto(initialObject.getCalculation()));
        resultingObject.setNutrition(toNutritionDataDto(initialObject.getNutrition()));
        return resultingObject;
    }



    public static NutritionDataDto toNutritionDataDto(NutritionData initialObject) {
        if (initialObject == null) {
            return null;
        }
        NutritionDataDto resultingObject = new NutritionDataDto();
        resultingObject.setId(initialObject.getId());
        resultingObject.setAge(initialObject.getAge());
        resultingObject.setGender(initialObject.getGender());
        resultingObject.setPhysicalActivity(initialObject.getPhysicalActivity());
        resultingObject.setEnergy(initialObject.getEnergy());
        resultingObject.setProteinMin(initialObject.getProteinMin());
        resultingObject.setProteinMax(initialObject.getProteinMax());
        resultingObject.setFatMin(initialObject.getFatMin());
        resultingObject.setFatMax(initialObject.getFatMax());
        resultingObject.setCarbMin(initialObject.getCarbMin());
        resultingObject.setCarbMax(initialObject.getCarbMax());
        return resultingObject;
    }


}
