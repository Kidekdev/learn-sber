package com.example.crudservice.repositories.impl;

import com.example.crudservice.models.User;
import com.example.crudservice.repositories.UserMockRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.*;

//todo обработать исключения
//todo добавить потокобезопасный доступ
@Repository
@Slf4j
public class UserMockRepositoryImpl implements UserMockRepository {

    private final Map<Long, User> usersDB;

    @Override
    public User persist(User user) {
//        if (usersDB.containsKey(user.getId())) {
//            throw new RuntimeException();
//        }
        usersDB.put(user.getId(), user);
        log.info("Юзер с айди {} сохранен", user.getId());
        return usersDB.get(user.getId());

    }


    @Override
    public User findUser(Long id) {

        if (!usersDB.containsKey(id)) {
            log.info("Юзер с айди {} не обнаружен",id);
            return null;
        }

        return usersDB.get(id);
    }

    @Override
    public User updateUser(User user) {
        usersDB.put(user.getId(), user);
        log.info("Юзер с айди {} обновлен",user.getId());
        return usersDB.get(user.getId());
    }

    @Override
    public void deleteUser(Long id) {

        usersDB.remove(id);
        log.info("Юзер с айди {} удален",id);
    }


    public UserMockRepositoryImpl() {
        usersDB = new HashMap<>();
    }

    @PostConstruct
    public void init() {
        usersDB.put(1l, new User(1L, "Ethan", "Gallagher"));
        usersDB.put(2L, new User(2L, "Olivia ", "Diaz"));
        usersDB.put(3L, new User(3L, "Benjamin ", "Patel"));
    }


}
