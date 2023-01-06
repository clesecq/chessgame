package model.piece;

public class QueenStrategy implements PieceStrategy {
    @Override
    public String getName() {
        return "queen";
    }

    @Override
    public Integer getPoints() {
        return 9;
    }

    @Override
    public int[][] getMovements(int x, int y) {
        /* 36 movements:
         * 7 horizontal
         * 7 vertical
         * 8+6 diagonal
         * 8 stop chain
         */
        int[][] movements = new int[36][2];
        int index = 0;

        // like bishop
        int x1 = x, y1 = y;
        while (x1 < 7 && y1 < 7)
            movements[index++] = new int[]{++x1, ++y1};
        movements[index++] = new int[]{-1, -1};

        int x2 = x, y2 = y;
        while (x2 > 0 && y2 > 0)
            movements[index++] = new int[]{--x2, --y2};
        movements[index++] = new int[]{-1, -1};

        int x3 = x, y3 = y;
        while (x3 < 7 && y3 > 0)
            movements[index++] = new int[]{++x3, --y3};
        movements[index++] = new int[]{-1, -1};

        int x4 = x, y4 = y;
        while (x4 > 0 && y4 < 7)
            movements[index++] = new int[]{--x4, ++y4};
        movements[index++] = new int[]{-1, -1};

        // like a rook
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
