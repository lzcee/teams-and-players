import java.util.Scanner;

public class Main {

    public int submenuOptions() {
        int option;
        System.out.println("===== OPTIONS =====");
        System.out.println("1. List All");
        System.out.println("2. List One");
        System.out.println("3. Add");
        System.out.println("4. Update");
        System.out.println("5. Delete");
        System.out.println("Enter an option:");
        Scanner read = new Scanner(System.in);
        option = read.nextInt();
        return option;
    }

    public void playersMenu() {
        int option = submenuOptions();
    }

    public void teamsMenu() {
        int option = submenuOptions();
    }

    public int mainMenu() {
        int option;
        System.out.println("====== MENU ======");
        System.out.println("1. Players");
        System.out.println("2. Teams");
        System.out.println("3. Exit");
        System.out.println("Enter an option:");
        Scanner read = new Scanner(System.in);
        option = read.nextInt();
        return option;
    }

    public static void main(String[] args) {
        Main main = new Main();
        int option = main.mainMenu();
        switch (option) {
            case 1:
                main.playersMenu();
                break;
            case 2:
                main.teamsMenu();
                break;
            case 3:
                System.exit(0);
                break;
        }
    }
}
