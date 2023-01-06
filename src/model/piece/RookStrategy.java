package model.piece;

public class RookStrategy implements PieceStrategy {


    @Override
    public String getName() {
        return "rook";
    }

    @Override
    public Integer getPoints() {
        return 5;
    }


    @Override
    public int[][] getMovements(int x, int y) {
        int[][] movements = new int[18][2];
        int index = 0;

        for (int i = x+1; i < 8; i++)
            movements[index++] = new int[]{i, y};
        movements[index++] = new int[]{-1, -1};

        for (int i = x-1; i >= 0; i--)
            movements[index++] = new int[]{i, y};
        movements[index++] = new int[]{-1, -1};

        for (int i = y+1; i < 8; i++)
            movements[index++] = new int[]{x, i};
        movements[index++] = new int[]{-1, -1};

        for (int i = y-1; i >= 0; i--)
            movements[index++] = new int[]{x, i};
        movements[index++] = new int[]{-1, -1};

        while (index < movements.length)
            movements[index++] = new int[]{-1, -1};

        return movements;
    }
}
