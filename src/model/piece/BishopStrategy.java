package model.piece;
public class BishopStrategy implements PieceStrategy {

    @Override
    public String getName() {
        return "bishop";
    }

    @Override
    public Integer getPoints() {
        return 3;
    }

    @Override
    public int[][] getMovements(int x, int y) {
        int[][] movements = new int[36][2];
        int i = 0;

        int x1 = x, y1 = y;
        while (x1 < 7 && y1 < 7)
            movements[i++] = new int[]{++x1, ++y1};
        movements[i++] = new int[]{-1, -1};

        int x2 = x, y2 = y;
        while (x2 > 0 && y2 > 0)
            movements[i++] = new int[]{--x2, --y2};
        movements[i++] = new int[]{-1, -1};

        int x3 = x, y3 = y;
        while (x3 < 7 && y3 > 0)
            movements[i++] = new int[]{++x3, --y3};
        movements[i++] = new int[]{-1, -1};

        int x4 = x, y4 = y;
        while (x4 > 0 && y4 < 7)
            movements[i++] = new int[]{--x4, ++y4};
        movements[i++] = new int[]{-1, -1};

        while (i < movements.length)
            movements[i++] = new int[]{-1, -1};

        return movements;
    }
}
