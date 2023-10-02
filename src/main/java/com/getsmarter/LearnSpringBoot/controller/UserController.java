package com.getsmarter.LearnSpringBoot.controller;

import com.getsmarter.LearnSpringBoot.dto.AdminCreate;
import com.getsmarter.LearnSpringBoot.dto.UserDTO;
import com.getsmarter.LearnSpringBoot.entity.User;
import com.getsmarter.LearnSpringBoot.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@AllArgsConstructor
@RestController()
@RequestMapping("user")
public class UserController {

    private UserService userService;

    // La methode pour inserer les utilisateurs
    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping()
    public User create(@RequestBody User user) throws RuntimeException {
        log.info("Inscription validee !");
        this.userService.saveUser(user);
        return user;
    }



    // La methodde pour lire les utilisateurs (Read du crud)
    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping()
    public List<UserDTO> search() {
        return this.userService.getAllUser();
    }


    // La methode pour lire les utilisateurs par id
    @GetMapping(path = "{id}")
    public UserDTO read(@PathVariable Long id){
        return this.userService.getUser(id);
    }


    // La methode pour modifier les données des utilisateurs
    @ResponseStatus(value = HttpStatus.OK)
    @PutMapping(path = "{id}")
    public void update(@PathVariable long id, @RequestBody User user) {
        this.userService.updateUser(id, user);
    }


    // La methode pour supprimer tous les utilisateurs
    @ResponseStatus(value = HttpStatus.OK)
    @DeleteMapping()
    public void deleteAll() {
        this.userService.deleteUser();
    }


    // La methode pour supprimer un utilisateur par son identifiant
    @ResponseStatus(value = HttpStatus.OK)
    @DeleteMapping(path = "{id}")
    public void delete(@PathVariable long id) {
        this.userService.deleteUserById(id);
    }
}
