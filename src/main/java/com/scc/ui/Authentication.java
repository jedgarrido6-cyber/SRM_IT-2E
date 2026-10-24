package com.scc.ui;

import com.scc.model.User;
import com.scc.dao.UserDao;
import java.util.Scanner;

public class Authentication {

    private final UserDao userDao;
    private final Scanner sc;

    public Authentication(UserDao userDao, Scanner sc) {
        this.userDao = userDao;
        this.sc = sc;
    }

    public void start(){
        System.out.println("\n==============================");
        System.out.println(" STUDENT RECORD MANAGEMENT");
        System.out.println("==============================");
        System.out.println("1. LOGIN");
        System.out.println("2. Register");
        System.out.println("3. Exit");
        System.out.print("Choose an option: ");
        String choice = sc.nextLine();

        switch (choice) {
            case "1":
                handleLogin();
                break;
            case "2":
                System.out.print("Enter username: ");
                String user = sc.nextLine();
                System.out.print("Enter password: ");
                String pass = sc.nextLine();

                System.out.print("Select Role [1] TEACHER | [2] ADMIN: ");
                int roleChoice = sc.nextInt();
                sc.nextLine(); // Consume newline left-over
                String role;
                switch (roleChoice) {
                    case 1:
                        role = "TEACHER";
                        break;
                    case 2:
                        role = "ADMIN";
                        break;
                    default:
                        role = null;
                }

                if (role != null) {
                    userDao.registerUser(user, pass, role);
                } else {
                    System.out.println("Invalid role selection");
                }
                break;
        }
    }

    private void handleLogin(){
        System.out.print("Enter username: ");
        String username = sc.nextLine();
        System.out.print("Enter password: ");
        String password = sc.nextLine();

        User user = userDao.login(username, password);
        if (user != null) {
            System.out.println("\n -> Welcome " + user.username() + " ROLE: " + user.roles() + "");
            switch (user.roles()){
                case "ADMIN" -> new AdminMenu(userDao, sc).display(user);
                default -> System.out.println("Invalid role selection");
            }
        }
    }
}