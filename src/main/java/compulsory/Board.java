package compulsory;

import java.util.*;

public class Board {


    private volatile boolean empty = false;
    private LinkedList<Token> tokens = new LinkedList<>();
    private int n;
    private Game game;
    public synchronized boolean isEmpty() {
        return tokens.isEmpty();
    }
    private LinkedList<Player> players;


    public void setPlayers(LinkedList<Player> players) {
        this.players = players;
    }

    public Board(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                Token token = new Token(i, j);
                this.tokens.add(token);
            }
        }
        this.n = n;
    }


    public int getNumber() {
        return n;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    @Override
    public String toString() {
        return "(new board here){" +
                tokens + "}";
    }

    public synchronized Token extractToken(int turn) {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (!tokens.isEmpty()) {
            Token thisToken;
            thisToken = tokens.getFirst();
            tokens.removeFirst();
           // tokens.add(thisToken);

            notifyAll();
            System.out.println("Player " + players.get(turn).getName() + " has chosen the following token: " + thisToken);
            return thisToken;
        }
        //win(tokens,turn);

       // System.out.println("Out of tokens. Game stopped, no winners. Play again, why not?");
        game.getWinner();
        empty=true;
        notifyAll();
        System.exit(0);
        return null;
    }

    public synchronized void win(List<Token> theseTokens, int turn){

        notifyAll();
        System.out.println("Player " + (turn+1) + " with the following tokens = " + theseTokens + " has won the game!");
        empty=true;
        System.exit(0);
    }
}
