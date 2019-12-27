package com.valiit.listedcompaniesapi.rest;

import com.valiit.listedcompaniesapi.dto.*;
import com.valiit.listedcompaniesapi.model.CalculateResponse;
import com.valiit.listedcompaniesapi.model.PersonMenu;
import com.valiit.listedcompaniesapi.service.NutritionDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/nutritiondata")
@CrossOrigin("*")

public class NutritionDataController {

    @Autowired
    private NutritionDataService nutritionDataService;

    @GetMapping("/{id}")
    public NutritionDataDto getChildNutritionData(@PathVariable("id") int id) {
        return nutritionDataService.getChildNutritionData(id);
    }

    @PostMapping("/register")
    public void generateMenu(@RequestBody PersonMenuDto personMenuDto) {
        nutritionDataService.saveMenu(personMenuDto);
    }

    @PostMapping("/calculation")
    public void generateCalculation(@RequestBody CalculateResponseDto calculateResponseDto) {
        nutritionDataService.saveCalculation(calculateResponseDto);
    }

    @GetMapping("/menu/{id}")
    public PersonMenuDto getMenu(@PathVariable("id") int id) {
        return nutritionDataService.getMenu(id);
    }

}
