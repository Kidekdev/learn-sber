package com.example.crudservice.service;

import com.example.crudservice.models.User;

public interface UserService {

    User createUser(User user);

    User getUser(Long id);

    User updateUser(User user);

    void deleteUser(Long id);





}
