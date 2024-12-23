package controller;

import model.Player;
import view.PlayerView;

import java.util.ArrayList;
import java.util.List;

public class PlayerController {
    private List<Player> players = new ArrayList<>();
    private PlayerView view;

    // Constructor
    public PlayerController(PlayerView view) {
        this.view = view;
    }

    // Add a new player
    public void addPlayer(int id, String name, String team, String role, int runs, int wickets) {
        Player player = new Player(id, name, team, role, runs, wickets);
        players.add(player);
    }

    // Update player statistics
    public void updatePlayerStats(int id, int runs, int wickets) {
        for (Player player : players) {
            if (player.getId() == id) {
                player.setRuns(runs);
                player.setWickets(wickets);
                System.out.println("Player stats updated: ");
                view.displayPlayerDetails(player);
                return;
            }
        }
        System.out.println("Player with ID " + id + " not found.");
    }

    // Display all players
    public void displayAllPlayers() {
        view.displayPlayersList(players);
    }

    // Retrieve players by team
    public void displayPlayersByTeam(String team) {
        List<Player> teamPlayers = new ArrayList<>();
        for (Player player : players) {
            if (player.getTeam().equalsIgnoreCase(team)) {
                teamPlayers.add(player);
            }
        }
        view.displayPlayersList(teamPlayers);
    }

    // Identify top scorer
    public void displayTopScorer() {
        Player topScorer = null;
        for (Player player : players) {
            if (topScorer == null || player.getRuns() > topScorer.getRuns()) {
                topScorer = player;
            }
        }
        System.out.println("Top Scorer: ");
        view.displayPlayerDetails(topScorer);
    }

    // Identify top wicket-taker
    public void displayTopWicketTaker() {
        Player topWicketTaker = null;
        for (Player player : players) {
            if (topWicketTaker == null || player.getWickets() > topWicketTaker.getWickets()) {
                topWicketTaker = player;
            }
        }
        System.out.println("Top Wicket Taker: ");
        view.displayPlayerDetails(topWicketTaker);
    }
}
