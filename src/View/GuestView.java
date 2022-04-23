package View;

import java.util.Scanner;

public class GuestView {
    public GuestView() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("==========HELLO GUEST, THANK YOU FOR USING OUR SERVICE!!!==========");
        System.out.println("===============CHOOSE ONE OF THE FOLLOWING FUNCTION================");
        System.out.println("1. SHOW ACCOUNT INFORMATION ");
        System.out.println("2. ROOM MANAGEMENT");
        System.out.println("3. RECEIPT MANAGEMENT");
        System.out.println("0. LOGOUT");
        System.out.println("===================================================================");
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
                System.out.println("2. SHOW AVAILABLE ROOM");
                System.out.println("3. FIND ROOM BY ID");
                System.out.println("4. FIND AVAILABLE ROOM BY PRICE RANGE");
                System.out.println("0. EXIT");
                System.out.println("===================================================================");
                int choice2 = Integer.parseInt(scanner.nextLine());
                switch (choice2) {
                    case 0:
                        new GuestView();
                        break;
                    case 1:
                        new RoomView().showListRoom();
                        break;
                    case 2:
                        new RoomView().showAvailableRoom();
                        break;
                    case 3:
                        new RoomView().findRoomById();
                        break;
                    case 4:
                        new RoomView().findAvailableRoomByPriceRange();
                        break;
                }
                break;
            case 3:
                System.out.println("===============CHOOSE ONE OF THE FOLLOWING FUNCTION================");
                System.out.println("1. FIND RECEIPT BY ROOM ID");
                System.out.println("0. EXIT");
                System.out.println("===================================================================");
                int choice3 = Integer.parseInt(scanner.nextLine());
                switch (choice3) {
                    case 0:
                        new GuestView();
                        break;
                    case 1:
                        new ReceiptView().findReceiptByRoomId();
                        break;
                }
        }
    }
    public static void main (String[]args){
        new GuestView();
    }
}
