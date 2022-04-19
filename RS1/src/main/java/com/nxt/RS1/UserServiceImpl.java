package com.nxt.RS1;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService{
    User user = new User();
    List<User> usersList = new ArrayList<>();
    @Override
    public String getName() {
        return user.getName();
    }
    @Override
    public void setName(String name) {
        user.setName(name);
    }
    @Override
    public String getPass() {
        return user.getPass();
    }
    @Override
    public void setPass(String pass) {
        user.setPass(pass);
    }
    @Override
    public int getId() {
        return user.getId();
    }
    @Override
    public void setId(int id) {
        user.setId(id);
    }

    @Override
    public void addUser(User user) {
        usersList.add(user);
    }

    @Override
    public void removeUser(User user) {
        usersList.remove(user);
    }

    @Override
    public User getUser() {
        return this.user;
    }

    @Override
    public User getUserById(int id) {
        return usersList.stream().filter(user1 -> Objects.equals(user1.getId(), id)).toList().get(0);
    }

    @Override
    public User getUserByName(String name) {
        return usersList.stream().filter(user1 -> Objects.equals(user1.getName(), name)).toList().get(0);
    }
}
