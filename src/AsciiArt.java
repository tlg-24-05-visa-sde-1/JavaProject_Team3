import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AsciiArt {
    public static void main(String[] args) throws FileNotFoundException, InterruptedException {
        File file = new File("/Users/duresahinika/TLGLearning/StudentWork/Mini Project /JavaProject_Team3/resources/connect4boardcartoon.txt");
        Scanner reader = new Scanner(file);
        while (reader.hasNextLine()) {
            String line = reader.nextLine();
            System.out.println(line);
            Thread.sleep(100);
        }
    }
}
