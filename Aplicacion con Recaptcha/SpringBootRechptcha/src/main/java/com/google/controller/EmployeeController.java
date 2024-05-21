package com.google.controller;


import com.google.controller.dto.EmployeeDTO;
import com.google.entities.EmployeeEntity;
import com.google.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;
import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping(path = {"/","/all"})
    public String showALl(Model model){

        List<EmployeeEntity> empployeeEntityList= employeeService.findAll();
        model.addAttribute("employees", empployeeEntityList);

        return  "index";

    }

    @GetMapping("/create/form")
    public String createForm(Model model){
        model.addAttribute("employee", new EmployeeEntity());
        return "form";

    }

    @PostMapping("/create/process")
    public String createProcess(EmployeeDTO employeeDTO){

        EmployeeEntity employeeEntity = EmployeeEntity.builder()
                .name(employeeDTO.getName())
                .lastName(employeeDTO.getLastName()) // Corrige el nombre del método si es necesario.
                .dateOfBirth(employeeDTO.getDateOfBirth())
                .build();


        employeeService.createEmployee(employeeEntity);

        return  "redirect:/all";


    }



    
}
