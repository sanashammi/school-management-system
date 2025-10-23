package com.school.management.dao;

import java.util.*;
import com.school.management.model.User;

public class Database {
    private static List<User> users = new ArrayList<>();

    static {
        users.add(new User("admin", "admin123", "admin"));
        users.add(new User("teacher1", "teach123", "teacher"));
        users.add(new User("student1", "stud123", "student"));
    }

    public static User validateUser(String username, String password, String role) {
        for (User u : users) {
            if (u.getUsername().equals(username) && 
                u.getPassword().equals(password) && 
                u.getRole().equals(role)) {
                return u;
            }
        }
        return null;
    }
}
