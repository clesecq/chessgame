package model.piece;

public class RookStrategy implements PieceStrategy {


    @Override
    public Character getLetter() {
        return 'R';
    }

    @Override
    public Integer getPoints() {
        return 5;
    }


    @Override
    public int[][] getMovements(int x, int y) {
        int[][] movements = new int[16][2];

        for (int i = 0; i < 8; i++)
            if (i != y) movements[i < y ? i : i - 1] = new int[]{x, i};
        movements[7] = new int[]{-1, -1};

        for (int i = 0; i < 8; i++)
            if (i != x) movements[8 + (i < x ? i : i - 1)] = new int[]{i, y};
        movements[15] = new int[]{-1, -1};

        return movements;
    }
}
