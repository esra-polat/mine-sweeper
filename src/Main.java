import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter tile size: ");
        String tileSize = scanner.nextLine();
        int row = Integer.parseInt(tileSize.substring(0, 1));
        int column = Integer.parseInt(tileSize.substring(2, 3));

        MineSweeper mineSweeper = new MineSweeper(row, column);
        mineSweeper.run();
    }
}
