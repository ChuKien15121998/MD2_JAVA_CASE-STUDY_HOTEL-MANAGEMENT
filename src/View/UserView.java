package View;

import Controller.UserController;
import Model.Role;
import Model.User;
import Service.staffService.UserServiceIMPL;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class UserView {
    Scanner scanner = new Scanner(System.in);
    UserController userController = new UserController();
    List<User> userList = UserServiceIMPL.userList;
    List<User> userLoggingList = UserServiceIMPL.userLoggingList;

    public void RegisterView() {
        System.out.println("==================REGISTER=================");
        int id;
        if (userList.size() == 0) {
            id = 1;
        } else {
            id = userList.get(userList.size() - 1).getUserID() + 1;
        }

        System.out.println("ENTER THE NAME: ");
        String name = scanner.nextLine();

        System.out.println("ENTER THE USERNAME (FROM 8 TO 16 CHARACTERS) : ");
        String username;
        boolean checkUserName;
        while (true) {
            username = scanner.nextLine();
            checkUserName = Pattern.matches("[A-Za-z0-9]{8,16}", username);
            if (!checkUserName) {
                System.err.println("USERNAME FAILED! PLEASE TRY AGAIN!");
            } else if (userController.existedByUserName(username)) {
                System.err.println("USERNAME IS EXISTED! PLEASE TRY AGAIN!");
            } else {
                break;
            }
        }

        System.out.println("ENTER THE PASSWORD (FROM 8 TO 16 CHARACTERS) : ");
        String password;
        boolean checkPassWord;
        while (true) {
            password = scanner.nextLine();
            checkPassWord = Pattern.matches("^[A-Za-z0-9]{8,16}$", password);
            if (!checkPassWord) {
                System.err.println("PASSWORD FAILED! PLEASE TRY AGAIN!");
            } else {
                break;
            }
        }

        System.out.println("ENTER THE EMAIL: ");
        String email;
        boolean checkEmail;
        while (true) {
            email = scanner.nextLine();
            checkEmail = Pattern.matches("^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$", email);
            if (!checkEmail) {
                System.err.println("EMAIL FAILED! PLEASE TRY AGAIN!");
            } else {
                break;
            }
        }

        System.out.println("ENTER PHONENUMBER (9 OR 10 CHARACTERS): ");
        String phoneNumber;
        boolean checkPhoneNumber;
        while (true) {
            phoneNumber = scanner.nextLine();
            checkPhoneNumber = Pattern.matches("^0[0-9]{8,9}$", phoneNumber);
            if (!checkPhoneNumber) {
                System.err.println("PHONENUMBER FAILED! PLEASE TRY AGAIN!");
            } else {
                break;
            }
        }

        User user = new User();
        user.setUserID(id);
        user.setName(name);
        user.setUserPhoneNumber(phoneNumber);
        user.setUserEmail(email);
        user.setUserName(username);
        user.setPassWord(password);
        System.out.println("CHOOSE THE ROLE (1 OR 2): ");
        System.out.println("1. GUEST");
        System.out.println("2. STAFF");
        int chooseRole = scanner.nextInt();
        switch (chooseRole) {
            case 1:
                user.setRoleName(Role.RoleName.GUEST);
                break;
            case 2:
                user.setRoleName(Role.RoleName.STAFF);
                break;
        }
        userController.createUser(user);
        if (user.getRoleName() == Role.RoleName.GUEST) {
            userController.createGuest(user);
        } else if (user.getRoleName() == Role.RoleName.STAFF) {
            userController.createStaff(user);
        }
        System.out.println("SUCCESSFUL REGISTRATION!!!");
        new Main();
    }

    public void LoginView() {
        System.out.println("===================LOGIN===================");

        System.out.println("ENTER USERNAME: ");
        String username = scanner.nextLine();
        System.out.println("ENTER PASSWORD: ");
        String password = scanner.nextLine();
        int count = 0;
        for (int i = 0; i < userList.size(); i++) {
            if (username.equals(userList.get(i).getUserName()) && password.equals(userList.get(i).getPassWord())) {
                System.out.println("SUCCESFUL LOGIN!!!");
                count++;
                User user = new User(userList.get(i).getUserID(), userList.get(i).getName(), userList.get(i).getUserPhoneNumber(), userList.get(i).getUserEmail(), userList.get(i).getUserName(), userList.get(i).getPassWord(), userList.get(i).getRoleName());
                userController.updateUserLogging(user);
                if (Role.RoleName.GUEST.equals(userList.get(i).getRoleName())) {
                    new GuestView();
                    break;
                } else {
                    new StaffView();
                    break;
                }
            } else if (count == 0 && i == userList.size() - 1) {
                System.out.println("WRONG LOGIN! PLEASE TRY AGAIN!");
                new UserView().LoginView();
            }
        }
    }

    public void showUserLogging() {
        System.out.println(userController.showUserLogging());
        String backMenu = "";
        while (!backMenu.equalsIgnoreCase("quit")) {
            System.out.println("ENTER \"QUIT\" TO COME BACK MENU: ");
            backMenu = scanner.nextLine();
            if (backMenu.equalsIgnoreCase("quit")) {
                for (int i = 0; i < userLoggingList.size(); i++) {
                    if (Role.RoleName.GUEST.equals(userLoggingList.get(i).getRoleName())) {
                        new GuestView();
                    } else {
                        new StaffView();
                    }
                }
            }
        }
    }

    public void showUserList() {
        System.out.println(userController.showListUser());
        String backMenu = "";
        while (!backMenu.equalsIgnoreCase("quit")) {
            System.out.println("ENTER \"QUIT\" TO COME BACK MENU: ");
            backMenu = scanner.nextLine();
            if (backMenu.equalsIgnoreCase("quit")) {
                for (int i = 0; i < userLoggingList.size(); i++) {
                    if (Role.RoleName.GUEST.equals(userLoggingList.get(i).getRoleName())) {
                        new GuestView();
                    } else {
                        new StaffView();
                    }
                }
            }
        }
    }

    public void showStaffList() {
        System.out.println(userController.showStaffList());
    }

    public void showGuestList() {
        System.out.println(userController.showGuestList());
    }

    public void logout() {
        userController.louout();
    }
}
