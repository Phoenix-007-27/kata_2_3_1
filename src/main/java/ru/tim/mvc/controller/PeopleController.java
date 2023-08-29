package ru.tim.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.tim.mvc.model.Person;
import ru.tim.mvc.services.UserService;
import ru.tim.mvc.services.UserServiceImpl;
import javax.validation.Valid;

@Controller
@RequestMapping("/people")
public class PeopleController {


    private final UserService peopleService;

    @Autowired
    private PeopleController(UserService peopleServece) {
        this.peopleService = peopleServece;
    }

    @GetMapping()
    public String findAll(Model model) {
        model.addAttribute("people", peopleService.findAll());
        return "index";
    }

    @GetMapping("/{id}")
    public String findById(@PathVariable("id") int id, Model model) {
        model.addAttribute("person", peopleService.findById(id));
        return "show";
    }

    @GetMapping("/create")
    public String form(@ModelAttribute("person") Person person) {
        return "formTL";
    }


    @PostMapping("/create")
    public String create(@ModelAttribute("person") @Valid Person person, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "formTL";
        }
        peopleService.save(person);
        return "redirect:/people";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") int id, Model model) {

        model.addAttribute("person", peopleService.findById(id));
        return "edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("person") @Valid Person person, BindingResult bindingResult, @PathVariable("id") int id) {
        if (bindingResult.hasErrors()) {
            return "edit";
        }
        peopleService.update(id, person);
        return "redirect:/people";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        peopleService.delete(id);
        return "redirect:/people";

    }
}
