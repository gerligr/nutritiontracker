package com.valiit.listedcompaniesapi.service;

import com.valiit.listedcompaniesapi.dto.*;
import com.valiit.listedcompaniesapi.model.*;
import com.valiit.listedcompaniesapi.repository.ChildRepository;
import com.valiit.listedcompaniesapi.repository.NutritionRepository;
import com.valiit.listedcompaniesapi.util.Transformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class NutritionDataService {

    @Autowired
    private NutritionRepository nutritionRepository;

    @Autowired
    private ChildRepository childRepository;


    public NutritionDataDto getChildNutritionData(int id) {
        Assert.isTrue(id > 0, "The ID of the child not specified");

        NutritionData nutritionData = nutritionRepository.getChildNutritionData(id);
        return Transformer.toNutritionDataDto(nutritionData);

    }

    public PersonMenuDto getMenu(int childId) {
        Assert.isTrue(childId > 0, "The ID of the child not specified");

        PersonMenu personMenu = nutritionRepository.getChildMenuData(childId);
        return Transformer.toPersonMenuDto(personMenu);

    }

    public void saveCalculation(CalculateResponseDto calculateResponseDto) {
        Assert.notNull(calculateResponseDto, "Calculation not specified");

        CalculateResponse calculateResponse = Transformer.toCalculateResponse(calculateResponseDto);

    }


    public void saveMenu(PersonMenuDto personMenuDto) {
        Assert.notNull(personMenuDto, "Menu not specified");

        PersonMenu personMenu = Transformer.toPersonMenuModel(personMenuDto);
        if (personMenu.getId() > 0) {
            nutritionRepository.updateMenu(personMenu);
        } else {
            nutritionRepository.addMenu(personMenu);
        }


//        CalculateResponse calculateResponse = new CalculateResponse();
//        calculateResponse.setChildId(30);
//        calculateResponse.setTotalEnergy(1100);
//        calculateResponse.setTotalFats(370);
//        calculateResponse.setTotalCarbs(500);
//        calculateResponse.setTotalProteins(150);
//
//        // Genereeri PersonMenuDto ja anna see calculateReponsgega kaasa
//        PersonMenuDto personMenuDto = null; // tekita siin objekt
       //calculateResponse.setPersonMenu(personMenuDto);
//
//        return calculateResponse;
    }



}
