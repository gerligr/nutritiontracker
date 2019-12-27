package com.valiit.listedcompaniesapi.rest;

import com.valiit.listedcompaniesapi.dto.CompanyDto;
import com.valiit.listedcompaniesapi.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
@CrossOrigin("*")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @GetMapping
    public List<CompanyDto> getCompanies() {
        return companyService.getCompanies();
    }

    @GetMapping("/{id}")
    public CompanyDto getCompany(@PathVariable("id") int id) {
        return companyService.getCompany(id);
    }

    @PostMapping
    public void saveCompany(@RequestBody CompanyDto companyDto) {
        companyService.saveCompany(companyDto);
    }

    @DeleteMapping("/{id}")
    public void deleteCompany(@PathVariable("id") int id) {
        companyService.deleteCompany(id);
    }
}
