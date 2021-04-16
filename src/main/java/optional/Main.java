package optional;

import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        LinkedList<Player> myPlayers = new LinkedList<>();

        Board myBoard = new Board(5);
        Player p1 = new Player("John", myBoard, "human");
        Player p2 = new Player("Mary", myBoard, "bot");
        Player p3 = new Player("Dave", myBoard, "human");
        Player p4 = new Player("Anna", myBoard, "human");

        myPlayers.add(p1);
        myPlayers.add(p2);
        //myPlayers.add(p3);
        myBoard.setPlayers(myPlayers);
        Game game = new Game(myBoard.getNumber(), 2, myPlayers, myBoard);
        myBoard.setGame(game);
        System.out.println("\n");
        System.out.println(game);
        System.out.println("\n");

        game.start();

    }
}
