package com.example.apuestas_app.utils;

import com.example.apuestas_app.models.User;

public class UserManager {
    private static User currentUser;

    public static User getUser(){
        if(currentUser == null){
            currentUser = new User("Jose Emmanuel");
            currentUser.setSaldo(3000.0);
        }
        return currentUser;
    }

    public static void setUser(User user)
    {
        currentUser = user;
    }
}
