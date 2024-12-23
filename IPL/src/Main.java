import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PlayerView view = new PlayerView();
        PlayerController controller = new PlayerController(view);

        Scanner scanner = new Scanner(System.in);

        // Sample players for testing
        controller.addPlayer(1, "Virat Kohli", "RCB", "Batsman", 600, 0);
        controller.addPlayer(2, "Jasprit Bumrah", "MI", "Bowler", 50, 25);
        controller.addPlayer(3, "MS Dhoni", "CSK", "Wicketkeeper", 300, 0);
        controller.addPlayer(4, "Rashid Khan", "GT", "All-rounder", 250, 20);

        System.out.println("=== IPL Player Management System ===");

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Add Player");
            System.out.println("2. Update Player Stats");
            System.out.println("3. Display All Players");
            System.out.println("4. Display Players by Team");
            System.out.println("5. Display Top Scorer");
            System.out.println("6. Display Top Wicket Taker");
            System.out.println("7. Exit");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter Player ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Team: ");
                    String team = scanner.nextLine();
                    System.out.print("Enter Role: ");
                    String role = scanner.nextLine();
                    System.out.print("Enter Runs: ");
                    int runs = scanner.nextInt();
                    System.out.print("Enter Wickets: ");
                    int wickets = scanner.nextInt();
                    controller.addPlayer(id, name, team, role, runs, wickets);
                    break;

                case 2:
                    System.out.print("Enter Player ID to Update: ");
                    id = scanner.nextInt();
                    System.out.print("Enter New Runs: ");
                    runs = scanner.nextInt();
                    System.out.print("Enter New Wickets: ");
                    wickets = scanner.nextInt();
                    controller.updatePlayerStats(id, runs, wickets);
                    break;

                case 3:
                    controller.displayAllPlayers();
                    break;

                case 4:
                    System.out.print("Enter Team Name: ");
                    scanner.nextLine(); // Consume newline
                    team = scanner.nextLine();
                    controller.displayPlayersByTeam(team);
                    break;

                case 5:
                    controller.displayTopScorer();
                    break;

                case 6:
                    controller.displayTopWicketTaker();
                    break;

                case 7:
                    System.out.println("Exiting the program...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}