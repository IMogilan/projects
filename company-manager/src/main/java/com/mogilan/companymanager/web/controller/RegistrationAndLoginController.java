package com.mogilan.companymanager.web.controller;

import com.mogilan.companymanager.service.user.UserService;
import com.mogilan.companymanager.web.dto.user.UserRegistrationDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class RegistrationAndLoginController {

    private final UserService userService;

    @ModelAttribute("user")
    public UserRegistrationDto userRegistrationDto(){
        return new UserRegistrationDto();
    }

    @GetMapping("/registration")
    public String showRegistrationForm(){
        return "registration/registration";
    }

    @PostMapping("/registration")
    public String registerUserAccount(@Valid @ModelAttribute(name = "user") UserRegistrationDto user, BindingResult result){
        if(result.hasErrors()){
            return "registration/registration";
        } else {
            userService.create(user);
            return "redirect:/registration?success";
        }
    }

    @GetMapping("/login")
    public String login(){
        return "registration/login";
    }


}
