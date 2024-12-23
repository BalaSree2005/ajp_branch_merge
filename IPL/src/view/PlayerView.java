package view;

import model.Player;

import java.util.List;

public class PlayerView {
    // Method to display player details
    public void displayPlayerDetails(Player player) {
        if (player != null) {
            System.out.println(player.toString());
        } else {
            System.out.println("No player data available.");
        }
    }

    // Method to display a list of players
    public void displayPlayersList(List<Player> players) {
        if (players.isEmpty()) {
            System.out.println("No players found.");
        } else {
            for (Player player : players) {
                System.out.println(player.toString());
            }
        }
    }
}
