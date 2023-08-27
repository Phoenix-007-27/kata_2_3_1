package ru.tim.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.tim.mvc.PersonDao.PersonDao;
import ru.tim.mvc.model.Person;

import javax.validation.Valid;

@Controller
@RequestMapping("/people")
public class PeopleController {

    private PersonDao personDao;

    @Autowired
    public PeopleController(PersonDao personDao) {
        this.personDao = personDao;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("people", personDao.index());
        return "index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("person", personDao.show(id));
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
        personDao.create(person);
        return "redirect:/people";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") int id, Model model) {

        model.addAttribute("person", personDao.show(id));
        return "edit";
    }


    @PatchMapping("/{id}")
    public String update(@ModelAttribute("person") @Valid Person person, BindingResult bindingResult, @PathVariable("id") int id) {
        if (bindingResult.hasErrors()) {
            return "edit";
        }
        personDao.update(id, person);
        return "redirect:/people";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        personDao.delete(id);
        return "redirect:/people";

    }
}
