package optional;

import java.util.LinkedList;

public class Game {
    private int n;
    private int k;
    public LinkedList<Player> players;
    private Board board;
    private int isWon;
    public int currentTurn;

    @Override
    public String toString() {
        return "The game has begun: " +
                " maximum right value of token: " + n +
                ", number of players: " + k +
                ", with the following players: " + players +
                ", on the following board:\n " + board +
                '.';
    }

    public Game(int n, int k, LinkedList<Player> players, Board board) {
        this.n = n;
        this.k = k;
        this.players = players;
        this.board = board;
        this.isWon=0;
        this.currentTurn=0;
    }

    public void start() {
        for (int index = 0; index < players.size(); index++) {
            players.get(index).setTurn(index);
            new Thread(players.get(index)).start();
        }

    }

    public void getWinner()
    {
        if(this.isWon!=0) return;
        this.isWon=1;
      //  System.out.println("here");
        int bestScore=0;
        int winner=0;

        for(int i=0;i<players.size();i++)
        {
            int currentScore=players.get(i).getScore();
            if(currentScore>bestScore)
            {
                bestScore=currentScore;
                winner=i;
            }
        }
        System.out.println("Player " + players.get(winner).getName() + " with the following score = " + bestScore + " has won the game!");
        System.out.println( "with the following tokens = " + players.get(winner).getMyTokens());
        System.exit(0);
    }
}
