package com.example.crudservice.controllers;

import com.example.crudservice.models.User;
import com.example.crudservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

   private final UserService userService;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    User getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }

    @PutMapping()
    @ResponseStatus(HttpStatus.OK)
    void saveUser(@RequestBody @Valid User user) {
        userService.createUser(user);
    }


    @PatchMapping()
    @ResponseStatus(HttpStatus.CREATED)
    User updateUser(@RequestBody User user) {
        return userService.updateUser(user);

    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);

    };
}
