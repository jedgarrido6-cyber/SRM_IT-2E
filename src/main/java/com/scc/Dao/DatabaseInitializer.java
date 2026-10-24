package com.scc.Dao;

import com.scc.dao.UserDao;

public class DatabaseInitializer {
    public static void initialize() {
        new UserDao();
        System.out.println("-> Database tables verified");
    }
}