package ru.tim.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
//import ru.tim.mvc.PersonDao.PersonDao;
import ru.tim.mvc.model.Person;
import ru.tim.mvc.repositories.PeopleRepository;
import ru.tim.mvc.services.PeopleServece;

import javax.validation.Valid;

@Controller
@RequestMapping("/people")
public class PeopleController {

//    private PersonDao personDao;
//
//    @Autowired
//    public PeopleController(PersonDao personDao) {
//        this.personDao = personDao;
//    }

    private final PeopleServece peopleServece;

    private PeopleController(PeopleServece peopleServece) {
        this.peopleServece = peopleServece;
    }


    //    @GetMapping()
//    public String index(Model model) {
//        model.addAttribute("people", personDao.index());
//        return "index";
//    }
    @GetMapping()
    public String findAll(Model model) {
        model.addAttribute("people", peopleServece.findAll());
        return "index";
    }

//    @GetMapping("/{id}")
//    public String show(@PathVariable("id") int id, Model model) {
//        model.addAttribute("person", personDao.show(id));
//        return "show";
//    }

    @GetMapping("/{id}")
    public String findById(@PathVariable("id") int id, Model model) {
        model.addAttribute("person", peopleServece.findById(id));
        return "show";
    }

    @GetMapping("/create")
    public String form(@ModelAttribute("person") Person person) {
        return "formTL";
    }

    //    @PostMapping("/create")
//    public String create(@ModelAttribute("person") @Valid Person person, BindingResult bindingResult) {
//        if (bindingResult.hasErrors()) {
//            return "formTL";
//        }
//        personDao.create(person);
//        return "redirect:/people";
//    }
    @PostMapping("/create")
    public String create(@ModelAttribute("person") @Valid Person person, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "formTL";
        }
        peopleServece.save(person);
        return "redirect:/people";
    }

    //    @GetMapping("/{id}/edit")
//    public String edit(@PathVariable("id") int id, Model model) {
//
//        model.addAttribute("person", personDao.show(id));
//        return "edit";
//    }
    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") int id, Model model) {

        model.addAttribute("person", peopleServece.findById(id));
        return "edit";
    }


    //    @PatchMapping("/{id}")
//    public String update(@ModelAttribute("person") @Valid Person person, BindingResult bindingResult, @PathVariable("id") int id) {
//        if (bindingResult.hasErrors()) {
//            return "edit";
//        }
//        personDao.update(id, person);
//        return "redirect:/people";
//    }
    @PatchMapping("/{id}")
    public String update(@ModelAttribute("person") @Valid Person person, BindingResult bindingResult, @PathVariable("id") int id) {
        if (bindingResult.hasErrors()) {
            return "edit";
        }
        peopleServece.update(id, person);
        return "redirect:/people";
    }


    //    @DeleteMapping("/{id}")
//    public String delete(@PathVariable("id") int id) {
//        personDao.delete(id);
//        return "redirect:/people";
//
//    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        peopleServece.delete(id);
        return "redirect:/people";

    }
}
