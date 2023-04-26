package com.example.crudservice.repositories;

import com.example.crudservice.models.User;

public interface UserMockRepository {

    User persist(User user);

    User findUser(Long id);

    User updateUser(User user);

    void deleteUser(Long id);

}
