package com.google.controller;


import com.google.controller.dto.EmployeeDTO;
import com.google.entities.EmployeeEntity;
import com.google.service.EmployeeService;
import com.google.service.RecaptchaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private RecaptchaService recaptchaService;


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
    public String createProcess(@ModelAttribute(name="employee") EmployeeDTO employeeDTO, @RequestParam(name="g-recaptcha-response") String captcha,Model model){

        boolean captchaValid= recaptchaService.validateRecaptcha(captcha);

        if(captchaValid){

            EmployeeEntity employeeEntity = EmployeeEntity.builder()
                    .name(employeeDTO.getName())
                    .lastName(employeeDTO.getLastName()) // Corrige el nombre del método si es necesario.
                    .dateOfBirth(employeeDTO.getDateOfBirth())
                    .build();
            employeeService.createEmployee(employeeEntity);
            return  "redirect:/all";

        }else{
            model.addAttribute("message", "Captcha not valid");
            return  "error";

        }





    }



    
}
