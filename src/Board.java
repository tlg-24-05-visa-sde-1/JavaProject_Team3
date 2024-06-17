import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<List<Token>> columns;
    public Board() {
        columns = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            columns.add(new ArrayList<>());
        }
    }
    public boolean update(int column, Token token) {
        if (columns.get(column).size() == 6) {
            columns.get(column).add(token);
            return true;
        }
        return false;
    }
    public void show () {
        for (int row = 5; row >= 0; row--) {
            for (int col = 0; col < 7; col++) {
                if (columns.get(col).size()> row) {
                    System.out.println("| " + columns.get(col).get(row).getColor() + " ");
                }else {
                    System.out.println("| _ ");
                }
            }
            System.out.println("|");
        }
    }
    public boolean checkWin () {
        return false;
    }
    public boolean isFull(){
        for (List<Token> column : columns) {
            if (column.size() < 6) {
                return false;
            }
        }
        return true;
    }

}