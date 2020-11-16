import dao.PlayerDAO;
import dao.TeamDAO;
import view.PlayerView;
import view.TeamView;

import java.util.Scanner;

public class Main {
    private PlayerDAO playerDAO;
    private PlayerView playerView;
    private TeamView teamView;
    private TeamDAO teamDAO;

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
        System.out.println("===== PLAYERS =====");
        int option = submenuOptions();
        switch (option) {
            case 1:
                playerView.ListAllPlayers(playerDAO);
                break;
            case 2:
                playerView.ListOnePlayers(playerDAO);
                break;
            case 3:
                playerView.AddPlayer(playerDAO);
                break;
            case 4:
                playerView.UpdatePlayer(playerDAO);
                break;
            case 5:
                playerView.DeletePlayer(playerDAO);
                break;
        }
    }

    public void teamsMenu() {
        int option = submenuOptions();
        switch (option) {
            case 1:
                teamView.listAllTeams(teamDAO);
                break;
            case 2:
                teamView.listOneTeam(teamDAO);
                break;
            case 3:
                teamView.addTeam(teamDAO);
                break;
            case 4:
                teamView.updateTeam(teamDAO);
                break;
            case 5:
                teamView.deleteTeam(teamDAO);
                break;
        }
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
        main.playerDAO = new PlayerDAO();
        main.playerView = new PlayerView();
        main.teamDAO = new TeamDAO();
        main.teamView = new TeamView();

        Boolean running = true;
        while (running) {
            int option = main.mainMenu();
            switch (option) {
                case 1:
                    main.playersMenu();
                    break;
                case 2:
                    main.teamsMenu();
                    break;
                case 3:
                    running = false;
                    System.exit(0);
                    break;
            }
        }
    }
}
