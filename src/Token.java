public class Token {
    private String color;

    public Token(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Token token = (Token) obj;
        return color.equals(token.color);
    }

    @Override
    public int hashCode() {
        return color.hashCode();
    }
}