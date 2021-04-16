package optional;

import java.util.ArrayList;
import java.util.List;

public class Player implements Runnable {

    private String name;
    private int myTurn;
    private List<Token> myTokens = new ArrayList<>();
    private Board board;
    private String playerType;

    public String getName() {
        return name;
    }

    public Player(String name, Board board, String playerType) {
        this.name = name;
        this.board = board;
        this.playerType=playerType;
    }

    public List<Token> getMyTokens() {
        return myTokens;
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
            if(playerType=="human") {
                Token t = board.extractTokenHuman(myTurn);
                myTokens.add(t);
            }
            else
            {
                Token t = board.extractToken(myTurn);
                myTokens.add(t);
            }
        }
        board.getGame().getWinner();


    }

    @Override
    public String toString() {
        return "Nume_Player = '" +
                name + '\'';
    }
}
