package View;

import Controller.ReceiptController;
import Controller.RoomController;
import Controller.UserController;
import Model.*;
import Service.receiptService.ReceiptServiceIMPL;
import Service.staffService.UserServiceIMPL;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class ReceiptView {
    Scanner scanner = new Scanner(System.in);
    ReceiptController receiptController = new ReceiptController();
    UserController userController = new UserController();
    List<Receipt> receiptList = ReceiptServiceIMPL.receiptList;
    List<User> userLoggingList = UserServiceIMPL.userLoggingList;


    public void createReceipt() throws ParseException {
        System.out.println("==========CREATE RECEIPT==========");
        SimpleDateFormat myFormat = new SimpleDateFormat("dd MM yyyy");

        int id;
        if (receiptList.size() == 0) {
            id = 1;
        } else {
            id = receiptList.get(receiptList.size() - 1).getReceiptId() + 1;
        }
        new UserView().showStaffList();
        System.out.println("ENTER THE STAFF'S ID: ");
        int staffId = Integer.parseInt(scanner.nextLine());
        new UserView().showGuestList();
        System.out.println("ENTER THE GUEST'S ID: ");
        int guestId = Integer.parseInt(scanner.nextLine());
        new RoomView().showAvailableRoomList();
        System.out.println("ENTER THE ROOM'S ID: ");
        int roomId = Integer.parseInt(scanner.nextLine());

        User staff = new UserController().findStaffById(staffId);
        User guest = new UserController().findGuestById(guestId);
        Room room = new RoomController().findById(roomId);

        User staffReceipt = new User(staff.getUserID(), staff.getName());
        User guestReceipt = new User(guest.getUserID(), guest.getName());

        System.out.println("Enter checkin date (dd MM yy): ");
        String dateIn = scanner.nextLine();
        System.out.println("Enter checkout date (dd MM yy): ");
        String dateOut = scanner.nextLine();
        Date checkIn = myFormat.parse(dateIn);
        Date checkOut = myFormat.parse(dateOut);
        long diff = checkOut.getTime() - checkIn.getTime();
        long days = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
        double totalPrice = days * room.getRoomPrice();
        Receipt receipt = new Receipt(id, staffReceipt, guestReceipt, room, checkIn, checkOut, totalPrice);
        receiptController.createReceipt(receipt);
        System.out.println("SUCCESFUL RECEIPT CREATION!!!");
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

    public void showListReceipt() {
        System.out.println(receiptController.showListReceipt());
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

    public void showReceiptList() {
        System.out.println(receiptController.showListReceipt());
    }

    public void deleteReceiptById() {
        System.out.println("ENTER RECEIPT'S ID YOU WANNA DELETE");
        int deleteId = Integer.parseInt(scanner.nextLine());
        receiptController.deleteById(deleteId);
        System.out.println("ENTER ANY KEY TO COME BACK MENU: ");
        String backMenu = scanner.nextLine();
        new StaffView();
    }

    public void findReceiptByRoomId() {
        System.out.println("ENTER ROOM'S ID YOU WANNA FIND : ");
        int findId = Integer.parseInt(scanner.nextLine());
        System.out.println(receiptController.findReceiptByRoomId(findId));
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

    public void findReceiptById() {
        System.out.println("ENTER RECEIPT'S ID YOU WANNA FIND: ");
        int findId = Integer.parseInt(scanner.nextLine());
        System.out.println(receiptController.findReceiptById(findId));
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

    public void getTotalRevenue() {
        System.out.println(receiptController.getAllTotalPrice());
        System.out.println("ENTER ANY KEY TO COME BACK MENU: ");
        String backMenu = scanner.nextLine();
        new StaffView();
    }

    public void editReceiptById(int id) throws ParseException {
        while (true) {
            for (int i = 0; i < receiptList.size(); i++) {
                if (id == receiptList.get(i).getReceiptId()) {
                    System.out.println("===============CHOOSE ONE OF THE FOLLOWING FUNCTION================");
                    System.out.println("1. EDIT RECEIPT'S GUEST");
                    System.out.println("2. EDIT RECEIPT'S STAFF");
                    System.out.println("3. EDIT RECEIPT'S ROOM");
                    System.out.println("4. EDIT RECEIPT'S CHECKIN");
                    System.out.println("5. EDIT RECEIPT'S CHECKOUT");
                    System.out.println("6. EDIT RECEIPT'S TOTALPRICE");
                    System.out.println("0. EXIT PROGRAM");
                    int choice = Integer.parseInt(scanner.nextLine());
                    switch (choice) {
                        case 0:
                            new StaffView();
                        case 1:
                            new UserView().showStaffList();
                            System.out.println("ENTER STAFF'S ID: ");
                            int staffIdEdit = scanner.nextInt();
                            User staffEdit = new UserController().findStaffById(staffIdEdit);
                            User staffEditReceipt = new User(staffEdit.getUserID(), staffEdit.getName());
                            receiptList.get(i).setStaff(staffEditReceipt);
                            new ReceiptServiceIMPL().save();
                            System.out.println("ENTER ANY KEY TO COME BACK EDIT MENU: ");
                            String backMenu1 = scanner.nextLine();
                            new ReceiptView().editReceiptById(id);
                            break;
                        case 2:
                            new UserView().showGuestList();
                            System.out.println("ENTER GUEST'S ID: ");
                            int guestIdEdit = scanner.nextInt();
                            User guestEdit = new UserController().findGuestById(guestIdEdit);
                            User guestEditReceipt = new User(guestEdit.getUserID(), guestEdit.getName());
                            receiptList.get(i).setStaff(guestEditReceipt);
                            new ReceiptServiceIMPL().save();
                            System.out.println("ENTER ANY KEY TO COME BACK MENU: ");
                            String backMenu2 = scanner.nextLine();
                            new ReceiptView().editReceiptById(id);
                            break;
                        case 3:
                            new RoomView().showAvailableRoomList();
                            System.out.println("ENTER ROOM'S ID: ");
                            int roomIdEdit = scanner.nextInt();
                            Room roomEdit = new RoomController().findById(roomIdEdit);
                            receiptList.get(i).setRoom(roomEdit);
                            long diff3 = receiptList.get(i).getCheckOut().getTime() - receiptList.get(i).getCheckIn().getTime();
                            long days3 = TimeUnit.DAYS.convert(diff3, TimeUnit.MILLISECONDS);
                            double totalPrice3 = days3 * roomEdit.getRoomPrice();
                            receiptList.get(i).setTotalPrice(totalPrice3);
                            new ReceiptServiceIMPL().save();
                            System.out.println("ENTER ANY KEY TO COME BACK MENU: ");
                            String backMenu3 = scanner.nextLine();
                            new ReceiptView().editReceiptById(id);
                            break;
                        case 4:
                            SimpleDateFormat myFormat = new SimpleDateFormat("dd MM yyyy");
                            System.out.println("Enter checkin date (dd MM yy): ");
                            String dateIn = scanner.nextLine();
                            Date checkIn = myFormat.parse(dateIn);
                            receiptList.get(i).setCheckIn(checkIn);
                            long diff4 = receiptList.get(i).getCheckOut().getTime() - checkIn.getTime();
                            long days4 = TimeUnit.DAYS.convert(diff4, TimeUnit.MILLISECONDS);
                            double totalPrice4 = days4 * receiptList.get(i).getRoom().getRoomPrice();
                            receiptList.get(i).setTotalPrice(totalPrice4);
                            new ReceiptServiceIMPL().save();
                            System.out.println("ENTER ANY KEY TO COME BACK MENU: ");
                            String backMenu4 = scanner.nextLine();
                            new ReceiptView().editReceiptById(id);
                            break;
                        case 5:
                            SimpleDateFormat myFormat1 = new SimpleDateFormat("dd MM yyyy");
                            System.out.println("Enter checkout date (dd MM yy): ");
                            String dateOut = scanner.nextLine();
                            Date checkOut = myFormat1.parse(dateOut);
                            receiptList.get(i).setCheckOut(checkOut);
                            long diff5 = checkOut.getTime() - receiptList.get(i).getCheckIn().getTime();
                            long days5 = TimeUnit.DAYS.convert(diff5, TimeUnit.MILLISECONDS);
                            double totalPrice5 = days5 * receiptList.get(i).getRoom().getRoomPrice();
                            receiptList.get(i).setTotalPrice(totalPrice5);
                            new ReceiptServiceIMPL().save();
                            System.out.println("ENTER ANY KEY TO COME BACK MENU: ");
                            String backMenu5 = scanner.nextLine();
                            new ReceiptView().editReceiptById(id);
                            break;
                        case 6:
                            System.out.println("ENTER TOTALPRICE: ");
                            double totalPrice = Double.parseDouble(scanner.nextLine());
                            receiptList.get(i).setTotalPrice(totalPrice);
                            new ReceiptServiceIMPL().save();
                            System.out.println("ENTER ANY KEY TO COME BACK EDIT MENU: ");
                            String backMenu6 = scanner.nextLine();
                            new ReceiptView().editReceiptById(id);
                            break;
                    }
                }
            }
        }
    }
}
