package View;

import java.text.ParseException;
import java.util.Scanner;

public class StaffView {
    public StaffView() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("==========HELLO STAFF, WISH YOU A EFFICIENT WORKING DAY!!!==========");
        System.out.println("===============CHOOSE ONE OF THE FOLLOWING FUNCTION================");
        System.out.println("1. SHOW ACCOUNT INFORMATION ");
        System.out.println("2. ROOM MANAGEMENT");
        System.out.println("3. RECEIPT MANAGEMENT");
        System.out.println("4. SHOW ALL ACCOUNT INFORMATION ");
        System.out.println("0. LOGOUT");
        System.out.println("=====================================================================");

        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 0:
                new UserView().logout();
                new Main();
                break;
            case 1:
                new UserView().showUserLogging();
                break;
            case 2:
                System.out.println("===============CHOOSE ONE OF THE FOLLOWING FUNCTION================");
                System.out.println("1. SHOW ROOM LIST ");
                System.out.println("2. ADD ROOM");
                System.out.println("3. EDIT ROOM BY ID");
                System.out.println("4. SHOW AVAILABLE ROOM");
                System.out.println("5. FIND ROOM BY ID");
                System.out.println("6. FIND AVAILABLE ROOM BY PRICE RANGE");
                System.out.println("0. EXIT");
                System.out.println("===================================================================");
                int choice2 = Integer.parseInt(scanner.nextLine());
                switch (choice2) {
                    case 0:
                        new StaffView();
                        break;
                    case 1:
                        new RoomView().showListRoom();
                        break;
                    case 2:
                        new RoomView().createRoom();
                        break;
                    case 3:
                        new RoomView().showRoomList();
                        System.out.println("ENTER ROOM'S ID YOU WANNA EDIT: ");
                        int id = scanner.nextInt();
                        new RoomView().editRoomById(id);
                        break;
                    case 4:
                        new RoomView().showAvailableRoom();
                        break;
                    case 5:
                        new RoomView().findRoomById();
                        break;
                    case 6:
                        new RoomView().findAvailableRoomByPriceRange();
                        break;
                }
                break;
            case 3:
                System.out.println("===============CHOOSE ONE OF THE FOLLOWING FUNCTION================");
                System.out.println("1. SHOW RECEIPT LIST ");
                System.out.println("2. ADD RECEIPT");
                System.out.println("3. EDIT RECEIPT BY ID");
                System.out.println("4. DELETE RECEIPT BY ID");
                System.out.println("5. FIND AND CALCULATE THE TOTAL BILL BY TIME");
                System.out.println("6. CALCULATE TOTAL REVENUE");
                System.out.println("0. EXIT");
                System.out.println("===================================================================");
                int choice3 = Integer.parseInt(scanner.nextLine());
                switch (choice3) {
                    case 0:
                        new StaffView();
                        break;
                    case 1:
                        new ReceiptView().showListReceipt();
                        break;
                    case 2:
                        try {
                            new ReceiptView().createReceipt();
                        } catch (ParseException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 3:
                        new ReceiptView().showReceiptList();
                        System.out.println("ENTER RECEIPT'S ID YOU WANNA EDIT: ");
                        int id = scanner.nextInt();
                        try {
                            new ReceiptView().editReceiptById(id);
                        } catch (ParseException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 4:
                        new ReceiptView().deleteReceiptById();
                        break;
                    case 5:
                        new ReceiptView().findReceiptById();
                        break;
                    case 6:
                        new ReceiptView().getTotalRevenue();
                        break;
                }
                break;
            case 4:
                new UserView().showUserList();
                break;
        }
    }

    public static void main(String[] args) {
        new StaffView();
    }
}
