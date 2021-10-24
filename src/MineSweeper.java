import java.util.Scanner;

public class MineSweeper {

    private final int row;
    private final int column;
    private int mineNumber;

    private String[][] mapTile;
    private String[][] tile;

    public MineSweeper(int row, int column) {
        this.row = row;
        this.column = column;
        this.mineNumber = row * column / 4;
    }

    public void run() {
        buildTile();
        showTile("map");
        showTile("tile");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Please enter coordinates: ");
            String coordinates = scanner.nextLine();
            int r = Integer.parseInt(coordinates.substring(0, 1));
            int c = Integer.parseInt(coordinates.substring(2, 3));

            if (mapTile[r][c].equals("-")) {
                tile[r][c] = String.valueOf(calculateAdjacentMines(r, c));
                showTile("tile");
            } else {
                System.out.println("BOOOM!\n[GAME OVER]");
                showTile("map");
                break;
            }

        }

    }

    public void buildTile() {
        mapTile = new String[row][column];
        tile = new String[row][column];
        int randomRow;
        int randomColumn;

        while (mineNumber >= 0) {
            randomRow = (int) (Math.random() * row);
            randomColumn = (int) (Math.random() * column);
            mapTile[randomRow][randomColumn] = "*";
            mineNumber--;
        }

        for (int i = 0; i < row; i++)
            for (int j = 0; j < column; j++)
                if (mapTile[i][j] == null)
                    mapTile[i][j] = "-";


        for (int i = 0; i < row; i++)
            for (int j = 0; j < column; j++)
                tile[i][j] = "-";

    }

    public void showTile(String type) {

        if (type.equals("map")) {
            System.out.println("~*~*~*~*~*~*~ Map ~*~*~*~*~*~*~");

            for (String[] i : mapTile) {
                for (String j : i)
                    System.out.print(j + " ");
                System.out.println();
            }
        } else {
            System.out.println("~*~*~*~*~*~ Game Board ~*~*~*~*~");

            for (String[] i : tile) {
                for (String j : i)
                    System.out.print(j + " ");
                System.out.println();
            }
        }

    }

    public int calculateAdjacentMines(int r, int c) {
        int mines = 0;

        if ((r - 1 >= 0 && r - 1 < row) && (c >= 0 && c < column))
            if (mapTile[r - 1][c].equals("*"))
                mines++;

        if ((r + 1 >= 0 && r + 1 < row) && (c >= 0 && c < column))
            if (mapTile[r + 1][c].equals("*"))
                mines++;

        if ((r >= 0 && r < row) && (c + 1 >= 0 && c + 1 < column))
            if (mapTile[r][c + 1].equals("*"))
                mines++;

        if ((r >= 0 && r < row) && (c - 1 >= 0 && c - 1 < column))
            if (mapTile[r][c - 1].equals("*"))
                mines++;

        if ((r - 1 >= 0 && r - 1 < row) && (c + 1 >= 0 && c + 1 < column))
            if (mapTile[r - 1][c + 1].equals("*"))
                mines++;

        if ((r - 1 >= 0 && r - 1 < row) && (c - 1 >= 0 && c - 1 < column))
            if (mapTile[r - 1][c - 1].equals("*"))
                mines++;

        if ((r + 1 >= 0 && r + 1 < row) && (c + 1 >= 0 && c + 1 < column))
            if (mapTile[r + 1][c + 1].equals("*"))
                mines++;

        if ((r + 1 >= 0 && r + 1 < row) && (c - 1 >= 0 && c - 1 < column))
            if (mapTile[r + 1][c - 1].equals("*"))
                mines++;

        return mines;
    }

}