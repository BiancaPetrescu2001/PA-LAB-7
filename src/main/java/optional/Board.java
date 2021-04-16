package optional;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Board {


    private volatile boolean empty = false;
    private LinkedList<Token> tokens = new LinkedList<>();
    private int maxInt;
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
        this.maxInt = n;
    }


    public int getNumber() {
        return maxInt;
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
            wait(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (!tokens.isEmpty()) {
            Token thisToken;
            Random rand = new Random();
            int upperBound= tokens.size();
            int int_random = rand.nextInt(upperBound);
            thisToken = tokens.get(int_random);
            tokens.remove(int_random);
            notifyAll();
            System.out.println("Player " + players.get(turn).getName() + " has chosen the following token: " + thisToken + " and this is his turn " + turn);
            try {
                Thread.sleep(100);
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //System.out.println("Player " + players.get(turn).getName() + " has chosen the following token: " + thisToken + " and this is his turn " + turn);
            return thisToken;
        }
        
        game.getWinner();
        empty=true;
        notifyAll();
        System.exit(0);
        return null;
    }
    public synchronized Token extractTokenHuman(int turn) {
        try {
            //Thread.sleep(100);
            wait(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (!tokens.isEmpty()) {
            Token thisToken;
            Boolean ok=true;
            int index=0;
            while(ok==true) {
                System.out.println("Insert a value smaller than "+ tokens.size());
                Scanner imput = new Scanner(System.in);
                index = imput.nextInt();
                if (index< tokens.size())
                {
                    ok=false;
                }
            }
            thisToken = tokens.get(index);
            tokens.remove(index);
            notifyAll();
            System.out.println("Player " + players.get(turn).getName() + " has chosen the following token: " + thisToken + " with the index " + index+ " and this is his turn " + turn);
            try {
                Thread.sleep(100);
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return thisToken;
        }

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
