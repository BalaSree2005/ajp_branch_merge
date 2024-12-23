import controller.PlayerController;
import model.Player;
import view.PlayerView;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PlayerView view = new PlayerView();
        PlayerController controller = new PlayerController(view);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- IPL Player Management System ---");
            System.out.println("1. Add a new player");
            System.out.println("2. Update player statistics");
            System.out.println("3. Display all players");
            System.out.println("4. Display players by team");
            System.out.println("5. Display top scorer");
            System.out.println("6. Display top wicket-taker");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Player ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Player Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Team Name: ");
                    String team = scanner.nextLine();
                    System.out.print("Enter Role (Batsman/Bowler/All-rounder): ");
                    String role = scanner.nextLine();
                    System.out.print("Enter Runs: ");
                    int runs = scanner.nextInt();
                    System.out.print("Enter Wickets: ");
                    int wickets = scanner.nextInt();
                    controller.addPlayer(id, name, team, role, runs, wickets);
                    break;

                case 2:
                    System.out.print("Enter Player ID to update stats: ");
                    int updateId = scanner.nextInt();
                    System.out.print("Enter Runs: ");
                    int updateRuns = scanner.nextInt();
                    System.out.print("Enter Wickets: ");
                    int updateWickets = scanner.nextInt();
                    controller.updatePlayerStats(updateId, updateRuns, updateWickets);
                    break;

                case 3:
                    controller.displayAllPlayers();
                    break;

                case 4:
                    System.out.print("Enter Team Name: ");
                    String searchTeam = scanner.nextLine();
                    controller.displayPlayersByTeam(searchTeam);
                    break;

                case 5:
                    controller.displayTopScorer();
                    break;

                case 6:
                    controller.displayTopWicketTaker();
                    break;

                case 7:
                    System.out.println("Exiting the application. Goodbye!");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
