package com.valiit.listedcompaniesapi.repository;

import com.valiit.listedcompaniesapi.model.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CompanyRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Company> getCompanies() {

        return jdbcTemplate.query("select * from company", mapCompanyRows);
    }

    public Company getCompany(int id) {
        List<Company> companies = jdbcTemplate.query("select * from company where id = ?", new Object[]{id}, mapCompanyRows);
        return companies.size() > 0 ? companies.get(0) : null;
    }

    public boolean companyExists(Company company) {
        Integer count = jdbcTemplate.queryForObject("select count(id) from company where name = ?", new Object[]{company.getName()}, Integer.class);
        return count != null && count > 0;
    }

    public void addCompany(Company company) {
        jdbcTemplate.update(
                "insert into company (name, logo, established, employees, revenue, net_income, securities, security_price, dividends) values (?, ?, ?, ?, ?, ?, ?, ?, ?)",
                company.getName(), company.getLogo(), company.getEstablished(), company.getEmployees(), company.getRevenue(),
                company.getNetIncome(), company.getSecurities(), company.getSecurityPrice(), company.getDividends()
        );
    }

    public void updateCompany(Company company) {
        jdbcTemplate.update(
                "update company set name = ?, logo = ?, established = ?, employees = ?, revenue = ?, net_income = ?, securities = ?, security_price = ?, dividends = ? where id = ?",
                company.getName(), company.getLogo(), company.getEstablished(), company.getEmployees(), company.getRevenue(),
                company.getNetIncome(), company.getSecurities(), company.getSecurityPrice(), company.getDividends(), company.getId()
        );
    }

    public void deleteCompany(int id) {
        jdbcTemplate.update("delete from company where id = ?", id);
    }

    private RowMapper<Company> mapCompanyRows = (rs, rowNum) -> {
        Company company = new Company();
        company.setId(rs.getInt("id"));
        company.setName(rs.getString("name"));
        company.setLogo(rs.getString("logo"));
        company.setEstablished(rs.getDate("established") != null ? rs.getDate("established").toLocalDate() : null);
        company.setEmployees(rs.getInt("employees"));
        company.setRevenue(rs.getDouble("revenue"));
        company.setNetIncome(rs.getDouble("net_income"));
        company.setSecurities(rs.getInt("securities"));
        company.setSecurityPrice(rs.getDouble("security_price"));
        company.setDividends(rs.getDouble("dividends"));
        return company;
    };
}
