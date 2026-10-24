package com.scc;

import com.scc.dao.UserDao;
import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static final UserDao userDao = new UserDao();

    public static void main(String[] args) {

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
}