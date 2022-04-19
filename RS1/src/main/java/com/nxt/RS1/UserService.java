package com.nxt.RS1;

public interface UserService {
    String getName();
    void setName(String name);
    String getPass();
    void setPass(String pass);
    int getId();
    void setId(int id);
    void addUser(User user);
    void removeUser(User user);
    User getUser();
    User getUserById(int id);
    User getUserByName(String name);
}
