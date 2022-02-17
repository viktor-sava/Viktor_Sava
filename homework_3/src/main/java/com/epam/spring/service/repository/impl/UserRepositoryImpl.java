package com.epam.spring.service.repository.impl;

import com.epam.spring.exception.UserNotFoundException;
import com.epam.spring.service.model.User;
import com.epam.spring.service.repository.UserRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private final List<User> userList = new ArrayList<>();

    private final Function<String, Predicate<User>> isEmailEquals = s -> p -> p.getEmail().equals(s);

    @Override
    public User getUser(String email) {
        return userList.stream()
                .filter(isEmailEquals.apply(email))
                .findFirst()
                .orElseThrow(() -> new UserNotFoundException(email));
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
        User oldUser = userList.stream()
                .filter(isEmailEquals.apply(email))
                .findFirst()
                .orElseThrow(() -> new UserNotFoundException(email));
        userList.remove(oldUser);
        user.setCreateDate(oldUser.getCreateDate());
        user.setId(oldUser.getId());
        user.setEmail(email);
        userList.add(user);
        return user;
    }

    @Override
    public void deleteUser(String email) {
        userList.removeIf(isEmailEquals.apply(email));
    }
}
