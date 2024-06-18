abstract class User {
    // protected field(s)/instance variable(s)
    protected Board board;

    // Constructor initializing User with Board object
    public User(Board board) {
        this.board = board;
    }

    /*
     * chooseColumn() : 1. Gets a list of available columns.
     * 2. Based on type of User, the method chooses to either:
     * prompt Player to choose a column, OR, BotOpponent randomly
     * chooses a column to dropToken() into.
     */
    protected int chooseColumn() {

    }
}