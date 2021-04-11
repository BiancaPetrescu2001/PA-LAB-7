package compulsory;

import java.util.*;

public class Player implements Runnable {

    private String name;
    private int myTurn;
    private List<Token> myTokens = new ArrayList<>();
    private Board board;

    public String getName() {
        return name;
    }

    public Player(String name, Board board) {
        this.name = name;
        this.board = board;
    }

    public void setTurn(int turn) {
        this.myTurn = turn;
    }

    public int getScore()
    {
        int score=0;
        for(int i=0;i<myTokens.size();i++)
            score+=myTokens.get(i).getValues().getKey()*myTokens.get(i).getValues().getValue();
        return score;
    }
    @Override
    public void run() {

        while(!board.isEmpty())
        {
            Token t=board.extractToken(myTurn);
            myTokens.add(t);
        }
        board.getGame().getWinner();


    }

    @Override
    public String toString() {
        return "Nume_Player = '" +
                name + '\'';
    }
}
