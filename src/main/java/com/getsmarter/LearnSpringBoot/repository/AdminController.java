package com.getsmarter.LearnSpringBoot.repository;

import com.getsmarter.LearnSpringBoot.dto.AdminCreate;
import com.getsmarter.LearnSpringBoot.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("admin")
@AllArgsConstructor
public class AdminController {

    private UserService userService;

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping
    public AdminCreate adminCreate(@RequestBody AdminCreate adminCreate){
        this.userService.createAdmin(adminCreate);
        return adminCreate;
    }
}
