import java.util.ArrayList;
import java.util.List;

class Column {
    private List<Token> tokens;
    public Column() {
        tokens = new ArrayList<Token>();
    }

    public boolean addToken(Token token) {
        if (tokens.size() < 6) {
            tokens.add(token);
            return true;
        }
        return false;
    }

    public List<Token> getTokens() {
        return tokens;
    }

    public Token getTokenAt(int index) {
        if (index >= 0 && index < tokens.size()) {
            return tokens.get(index);
        }
        return null;
    }

    public int size() {
        return tokens.size();
    }
}