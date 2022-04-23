package View;

import java.util.Scanner;

public class Main {
    public Main() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("==========WELCOME TO OUR HOTEL!!!==========");
        System.out.println("===CHOOSE ONE OF THE FOLLOWING FUNCTION===");
        System.out.println("1. REGISTER");
        System.out.println("2. LOGIN");
        System.out.println("===========================================");

        int choose = Integer.parseInt(scanner.nextLine());
        switch (choose){
            case 1: new UserView().RegisterView();
                break;
            case 2: new UserView().LoginView();
                break;
        }
    }
    public static void main(String[] args) {
        new Main();
    }
}
