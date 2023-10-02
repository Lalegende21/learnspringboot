package com.getsmarter.LearnSpringBoot.controller;

import com.getsmarter.LearnSpringBoot.entity.Command;
import com.getsmarter.LearnSpringBoot.service.CommandService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("command")
public class CommandController {

    private final CommandService commandService;

    public CommandController(CommandService commandService) {
        this.commandService = commandService;
    }


    // La methode pour inserer les commandes
    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping()
    public void create(@RequestBody Command command) {
        this.commandService.saveCategory(command);
    }

    // La methodde pour lire les commandes (Read du crud)
    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping()
    public List<Command> search() {
        return this.commandService.getAllCategory();
    }

    // La methode pour lire les commandes par id
    @GetMapping(path = "{id}")
    public Command read(@PathVariable Long id){
        return this.commandService.getCategory(id);
    }


    // La methode pour modifier les données des commandes
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    @PutMapping(path = "{id}")
    public void update(@PathVariable long id, @RequestBody Command command) {
        this.commandService.updateCategory(id, command);
    }


    // La methode pour supprimer toutes les commandes
    @ResponseStatus(value = HttpStatus.OK)
    @DeleteMapping()
    public void deleteAll() {
        this.commandService.deleteCategory();
    }


    // La methode pour supprimer une commande par son identifiant
    @ResponseStatus(value = HttpStatus.OK)
    @DeleteMapping(path = "{id}")
    public void delete(@PathVariable long id) {
        this.commandService.deleteCategoryById(id);
    }
}
