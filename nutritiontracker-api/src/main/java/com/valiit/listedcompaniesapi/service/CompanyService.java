package com.valiit.listedcompaniesapi.service;

import com.valiit.listedcompaniesapi.dto.CompanyDto;
import com.valiit.listedcompaniesapi.model.Company;
import com.valiit.listedcompaniesapi.repository.CompanyRepository;
import com.valiit.listedcompaniesapi.util.Transformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    public List<CompanyDto> getCompanies() {
        return companyRepository.getCompanies().stream().map(Transformer::toCompanyDto).collect(Collectors.toList());
    }

    public CompanyDto getCompany(int id) {
        Assert.isTrue(id > 0, "The ID of the company not specified");

        Company company = companyRepository.getCompany(id);
        return Transformer.toCompanyDto(company);
    }

    public void saveCompany(CompanyDto companyDto) {
        Assert.notNull(companyDto, "Company not specified");
        Assert.hasText(companyDto.getName(), "Company name not specified");
        Assert.isTrue(companyDto.getEstablished() == null || companyDto.getEstablished().isBefore(LocalDate.now()),
                "Company must have been established in the past");

        Company company = Transformer.toCompanyModel(companyDto);
        if (company.getId() != null && company.getId() > 0) {
            companyRepository.updateCompany(company);
        } else {
            Assert.isTrue(!companyRepository.companyExists(company), "The company with the specified name already exists");
            companyRepository.addCompany(company);
        }
    }

    public void deleteCompany(int id) {
        if (id > 0) {
            companyRepository.deleteCompany(id);
        }
    }
}
