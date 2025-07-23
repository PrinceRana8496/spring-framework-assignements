package com.prince.restfulwebservice2.service;

import com.prince.restfulwebservice2.model.User;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    private final Map<Integer, User> users = new HashMap<>();

    public UserService() {
        users.put(1, new User(1, "Prince", 22, "pass123"));
        users.put(2, new User(2, "Ankit", 25, "ankt@2024"));
        users.put(3, new User(3, "Raj", 28, "raj_secure"));
    }

    public User getUserById(int id) {
        return users.get(id);
    }

    public void saveUser(User user) {
        users.put(user.getId(), user);
    }

    public boolean deleteUser(int id) {
        return users.remove(id) != null;
    }

    public Collection<User> getAllUsers() {
        return users.values();
    }
}
