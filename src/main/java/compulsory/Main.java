package compulsory;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        LinkedList<Player> myPlayers = new LinkedList<>();

        Board myBoard = new Board(5);
        Player p1 = new Player("Bianca", myBoard);
        Player p2 = new Player("Ionut", myBoard);

        myPlayers.add(p1);
        myPlayers.add(p2);
        myBoard.setPlayers(myPlayers);
        Game game = new Game(35, myBoard.getNumber(), 2, myPlayers, myBoard);
        myBoard.setGame(game);
        System.out.println("\n");
        System.out.println(game);
        System.out.println("\n");

        game.start();

    }
}
