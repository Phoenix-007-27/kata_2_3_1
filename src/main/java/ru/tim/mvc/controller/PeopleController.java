package ru.tim.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.tim.mvc.PersonDao.PersonDao;
import ru.tim.mvc.model.Person;

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
    public String create(@ModelAttribute("person") Person person) {
        personDao.create(person);
        return "redirect:/people";
    }

        @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") int id, Model model) {
        System.out.println("QQQQQQQQQQQQQQQQQQQQQQQQQ");
        model.addAttribute("person", personDao.show(id));
        return "edit";
    }


    @PatchMapping("/{id}")
    public String update(@ModelAttribute("person") Person person, @PathVariable("id") int id) {
        personDao.update(id, person);
        return "redirect:/people";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id){
        personDao.delete(id);
        return "redirect:/people";

    }
}
