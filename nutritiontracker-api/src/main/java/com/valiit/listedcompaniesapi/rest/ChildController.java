package com.valiit.listedcompaniesapi.rest;

import com.valiit.listedcompaniesapi.dto.ChildDto;
import com.valiit.listedcompaniesapi.dto.CompanyDto;
import com.valiit.listedcompaniesapi.service.ChildService;
import com.valiit.listedcompaniesapi.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/children")
@CrossOrigin("*")
public class ChildController {

    @Autowired
    private ChildService childService;

    @GetMapping
    public List<ChildDto> getChildren() {
        return childService.getChildren();
    }
    /*@GetMapping
    public List<ChildDto> getUserChildren(@RequestBody ChildDto childDto) { return childService.getChildren();}*/

    @GetMapping("/{id}")
    public ChildDto getChild(@PathVariable("id") int id) {
        return childService.getChild(id);
    }

    @PostMapping("/register")
    public void saveChild(@RequestBody ChildDto childDto) {
        childService.saveChild(childDto);
    }

    @DeleteMapping("/{id}")
    public void deleteChild(@PathVariable("id") int id) {
        childService.deleteChild(id);
    }

}
