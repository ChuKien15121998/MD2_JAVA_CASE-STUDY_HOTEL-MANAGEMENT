package View;

import Controller.RoomController;
import Model.Role;
import Model.Room;
import Model.RoomStatus;
import Model.User;
import Service.roomService.RoomServiceIMPL;
import Service.staffService.UserServiceIMPL;

import java.util.List;
import java.util.Scanner;

public class RoomView {
    Scanner scanner = new Scanner(System.in);
    RoomController roomController = new RoomController();
    List<Room> roomList = RoomServiceIMPL.roomList;
    List<User> userLoggingList = UserServiceIMPL.userLoggingList;


    public void createRoom() {
        System.out.println("==========CREATE ROOM==========");
        int id;
        if (roomList.size() == 0) {
            id = 1;
        } else {
            id = roomList.get(roomList.size() - 1).getRoomID() + 1;
        }
        System.out.println("ENTER THE PRICE: ");
        double priceRoom = Double.parseDouble(scanner.nextLine());
        System.out.println("ENTER THE NUMBER OF BEDROOM: ");
        String numberOfBedroom = scanner.nextLine();
        System.out.println("ENTER THE NUMBER OF TOILET: ");
        String numberOfToilet = scanner.nextLine();
        Room room = new Room();
        room.setRoomID(id);
        room.setRoomPrice(priceRoom);
        room.setNumberOfBedroom(numberOfBedroom);
        room.setNumberOfToilet(numberOfToilet);
        System.out.println("CHOOSE THE STATUS (1, 2 OR 3): ");
        System.out.println("1. AVAILABLE");
        System.out.println("2. UNAVAILABLE");
        System.out.println("3. FIXING");
        int chooseStatus = scanner.nextInt();
        switch (chooseStatus) {
            case 1:
                room.setRoomStatus(RoomStatus.roomStatusName.AVAILABLE);
                break;
            case 2:
                room.setRoomStatus(RoomStatus.roomStatusName.UNAVAILABLE);
                break;
            case 3:
                room.setRoomStatus(RoomStatus.roomStatusName.FIXING);
                break;
        }
        roomController.createRoom(room);
        System.out.println("SUCCESFULL ROOM CREATION!!!");
        new StaffView();
    }

    public void showListRoom()  {
        System.out.println(roomController.showListRoom());
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

    public void showRoomList()  {
        System.out.println(roomController.showListRoom());

    }

    public void showAvailableRoomList() {
        System.out.println(roomController.showAvailableRoom());
    }

    public void findRoomById () {
        System.out.println("ENTER ROOM'S ID YOU WANNA FIND: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println(roomController.findById(id));
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


    public void showAvailableRoom() {
        System.out.println(roomController.showAvailableRoom());
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

    public void findAvailableRoomByPriceRange() {
        System.out.println("ENTER LOWEST PRICE: ");
        double minPriceRoom = Double.parseDouble(scanner.nextLine());
        System.out.println("ENTER HIGHEST PRICE: ");
        double maxPriceRoom = Double.parseDouble(scanner.nextLine());
        System.out.println(roomController.findAvailableRoomByPriceRange(minPriceRoom, maxPriceRoom));
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

    public void editRoomById(int id) {
        while (true) {
            for (int i = 0; i < roomList.size(); i++) {
                if (id == roomList.get(i).getRoomID()) {
                    System.out.println("===============CHOOSE ONE OF THE FOLLOWING FUNCTION================");
                    System.out.println("1. EDIT ROOM'S PRICE ");
                    System.out.println("2. EDIT NUMBER OF BEDROOM");
                    System.out.println("3. EDIT NUMBER OF TOILET");
                    System.out.println("4. EDIT ROOM'S STATUS");
                    System.out.println("0. EXIT PROGRAM");
                    int choice = Integer.parseInt(scanner.nextLine());
                    switch (choice) {
                        case 0:
                            new StaffView();
                        case 1:
                            System.out.println("ENTER PRICE: ");
                            double roomPrice = Double.parseDouble(scanner.nextLine());
                            roomList.get(i).setRoomPrice(roomPrice);
                            new RoomServiceIMPL().save();
                            System.out.println("ENTER ANY KEY TO COME BACK MENU: ");
                            String backMenu1 = scanner.nextLine();
                            new StaffView();
                            break;
                        case 2:
                            System.out.println("ENTER NUMBER OF BEDROOM: ");
                            String numberOfBedroom = scanner.nextLine();
                            roomList.get(i).setNumberOfBedroom(numberOfBedroom);
                            new RoomServiceIMPL().save();
                            System.out.println("ENTER ANY KEY TO COME BACK MENU: ");
                            String backMenu2 = scanner.nextLine();
                            new StaffView();
                            break;
                        case 3:
                            System.out.println("ENTER NUMBER OF TOILET: ");
                            String numberOfToilet = scanner.nextLine();
                            roomList.get(i).setNumberOfToilet(numberOfToilet);
                            new RoomServiceIMPL().save();
                            System.out.println("ENTER ANY KEY TO COME BACK MENU: ");
                            String backMenu3 = scanner.nextLine();
                            new StaffView();
                            break;
                        case 4:
                            System.out.println("CHOOSE THE STATUS (1, 2 OR 3): ");
                            System.out.println("1. AVAILABLE");
                            System.out.println("2. UNAVAILABLE");
                            System.out.println("3. FIXING");
                            int chooseStatus = scanner.nextInt();
                            switch (chooseStatus) {
                                case 1:
                                    roomList.get(i).setRoomStatus(RoomStatus.roomStatusName.AVAILABLE);
                                    break;
                                case 2:
                                    roomList.get(i).setRoomStatus(RoomStatus.roomStatusName.UNAVAILABLE);
                                    break;
                                case 3:
                                    roomList.get(i).setRoomStatus(RoomStatus.roomStatusName.FIXING);
                                    break;
                            }
                            new RoomServiceIMPL().save();
                            System.out.println("ENTER ANY KEY TO COME BACK MENU: ");
                            String backMenu4 = scanner.nextLine();
                            new StaffView();
                            break;
                    }
                }
            }
        }
    }
}
