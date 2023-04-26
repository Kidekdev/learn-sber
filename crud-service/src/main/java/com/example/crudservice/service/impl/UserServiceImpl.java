package com.example.crudservice.service.impl;


import com.example.crudservice.models.User;
import com.example.crudservice.repositories.UserMockRepository;
import com.example.crudservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

//todo добавить логирование
public class UserServiceImpl implements UserService {

  private final UserMockRepository userMockRepository;


    @Override
    public User createUser(User user) {

     return userMockRepository.persist(user);
    }

    @Override
    public User getUser(Long id) {
        return userMockRepository.findUser(id);
    }

    @Override
    public User updateUser(User user) {
      return userMockRepository.updateUser(user);
    }

    @Override
    public void deleteUser(Long id) {
     userMockRepository.deleteUser(id);
    }

//  @DeleteMapping("/users/{id}")
//  public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
//    userRepository.deleteById(id);
//    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
//  }

}
