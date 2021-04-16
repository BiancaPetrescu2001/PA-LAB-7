package optional;

import javafx.util.Pair;

public class Token {
    private Pair<Integer, Integer> values;

    public Token(int token1, int token2) {
        this.values = new Pair<>(token1, token2);
    }


    public Pair<Integer,Integer> getValues() {
        return values;
    }

    @Override
    public String toString() {
        return "" + values.getKey()+"-"+values.getValue();
    }
}
