package com.example.springJDBC.controller;

import com.example.springJDBC.entities.Person;
import com.example.springJDBC.entities.Product;
import com.example.springJDBC.service.PersonServiсe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class PersonController {
    PersonServiсe personServiсe;
    @GetMapping("/login")
    public String viewProduct(Model model){
        model.addAttribute("person",new Person());
        return "login";
    }
    @PostMapping("/login/add")
    public String viewProduct(@ModelAttribute(value = "person") Person person,
                              Model model){
        if(personServiсe.findByName(person.getName())==null){
            personServiсe.add(person);
        }
        return "redirect:/products?id="+personServiсe.findByName(person.getName()).getId();
    }

    @Autowired
    public PersonController(PersonServiсe personServiсe) {
        this.personServiсe = personServiсe;
    }
}
