package com.scc.ui;
import com.scc.dao.UserDao;
import java.util.Scanner;
import com.scc.model.User;
import java.util.List;

public class AdminMenu {
    private final UserDao userDao;
    private final Scanner scanner;

    public AdminMenu(UserDao userDao, Scanner scanner) {
        this.userDao = userDao;
        this.scanner = scanner;
    }

    public void display(User admin){
        boolean loggedIn = true;
        while (loggedIn){
            System.out.println("\n===============================");
            System.out.println("          ADMIN DASHBOARD         ");
            System.out.println("===============================");
            System.out.println("1. View ALL Users");
            System.out.println("2. View Pending User Approvals");
            System.out.println("3. Approve User Registration");
            System.out.println("4. Add New User");
            System.out.println("5. Update User Role / Status");
            System.out.println("6. Delete User Account");
            System.out.println("7. Log Out");
            System.out.print("Choose an option (1-7): ");

            String choice = scanner.nextLine().trim();

            switch (choice){
                case "1" -> viewAllUsers();
                default -> System.out.println(" -> [ERROR] invalid Option,");
            }
        }
    }

    private void displayUserTable(List<User> users, String tittle){
        System.out.println("\n============" + tittle + "============");
        if(users.isEmpty()){
            System.out.println("No user found");
            return;
        }

        System.out.println("+-----+----------------+----------+------------+");
        System.out.printf("| %-3s | %-15s | %-10s | %-10s |\n", "ID", "Username", "Role", "Status");
        System.out.println("+-----+----------------+----------+------------+");
        for(User user : users){
            System.out.printf("| %-3d | %-15s | %-10s | %-10s |\n",
                    user.id(), user.username(), user.roles(), user.status());
        }
        System.out.println("+-----+----------------+----------+------------+");
    }

    private void viewAllUsers(){
        displayUserTable(userDao.getAllUser(), "ALL REGISTERED USER");
    }
}