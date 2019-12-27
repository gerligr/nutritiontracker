package com.valiit.listedcompaniesapi.service;

import com.valiit.listedcompaniesapi.dto.ChildDto;
import com.valiit.listedcompaniesapi.model.Child;
import com.valiit.listedcompaniesapi.model.PersonMenu;
import com.valiit.listedcompaniesapi.model.User;
import com.valiit.listedcompaniesapi.repository.ChildRepository;
import com.valiit.listedcompaniesapi.repository.NutritionRepository;
import com.valiit.listedcompaniesapi.repository.UserRepository;
import com.valiit.listedcompaniesapi.util.Transformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ChildService {

    @Autowired
    private ChildRepository childRepository;

    @Autowired
    private NutritionRepository nutritionRepository;

    @Autowired
    private UserRepository userRepository;

    public List<ChildDto> getChildren() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User authenticatedUser = userRepository.getUserByUsername(username);
        List<Child> children = childRepository.getUserChildren(authenticatedUser.getId());

        for(int i = 0; i < children.size(); i++) {
            children.get(i).setMenu(nutritionRepository.getChildMenuData(children.get(i).getId()));
            children.get(i).setCalculation(nutritionRepository.getChildMenuCalculation(children.get(i).getId()));
            children.get(i).setNutrition(nutritionRepository.getChildNutritionData(children.get(i).getId()));

        }

        return children.stream().map(Transformer::toChildDto).collect(Collectors.toList());
    }

    public ChildDto getChild(int id) {
        Assert.isTrue(id > 0, "The ID of the child not specified");

        Child child = childRepository.getChild(id);

        child.setMenu(nutritionRepository.getChildMenuData(child.getId()));
        child.setCalculation(nutritionRepository.getChildMenuCalculation(child.getId()));
        child.setNutrition(nutritionRepository.getChildNutritionData(child.getId()));

        return Transformer.toChildDto(child);
    }

    public void saveChild(ChildDto childDto) {
        Assert.notNull(childDto, "Child not specified");
        Assert.hasText(childDto.getName(), "Child name not specified");
//        Assert.isTrue(childDto.getEstablished() == null || childDto.getEstablished().isBefore(LocalDate.now()),
//                "Company must have been established in the past");

        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User authenticatedUser = userRepository.getUserByUsername(username);
        childDto.setParentId(authenticatedUser.getId());

        Child child = Transformer.toChildModel(childDto);
        if (child.getId() > 0) {
            childRepository.updateChild(child);
        } else {
            childRepository.addChild(child);
        }
    }

    public void deleteChild(int id) {
        if (id > 0) {
            childRepository.deleteChild(id);
        }
    }
}
