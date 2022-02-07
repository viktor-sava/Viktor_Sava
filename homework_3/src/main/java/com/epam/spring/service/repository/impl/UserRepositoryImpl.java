package com.epam.spring.service.repository.impl;

import com.epam.spring.exception.UserNotFoundException;
import com.epam.spring.service.model.User;
import com.epam.spring.service.repository.UserRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private final List<User> userList = new ArrayList<>();

    @Override
    public User getUser(String email) {
        Optional<User> optionalUser = userList.stream().filter(p -> p.getEmail().equals(email)).findFirst();
        if (!optionalUser.isPresent()) {
            throw new UserNotFoundException();
        }
        return optionalUser.get();
    }

    @Override
    public List<User> listUsers() {
        return new ArrayList<>(userList);
    }

    @Override
    public User createUser(User user) {
        user.setCreateDate(Timestamp.valueOf(LocalDateTime.now()));
        user.setId(userList.size() + 1);
        userList.add(user);
        return user;
    }

    @Override
    public User updateUser(String email, User user) {
        Optional<User> optional = userList.stream().filter(p -> p.getEmail().equals(email)).findFirst();
        if (!optional.isPresent()) {
            throw new UserNotFoundException();
        }
        userList.removeIf(p -> p.getEmail().equals(email));
        User oldUser = optional.get();
        user.setCreateDate(oldUser.getCreateDate());
        user.setId(oldUser.getId());
        user.setEmail(email);
        userList.add(user);
        return user;
    }

    @Override
    public void deleteUser(String email) {
        userList.removeIf(p -> p.getEmail().equals(email));
    }
}
