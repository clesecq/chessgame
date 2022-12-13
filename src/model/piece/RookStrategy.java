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
        int[][] movements = new int[14][2];

        for (int i = 0; i < 8; i++)
            if (i != y) movements[i < y ? i : i - 1] = new int[]{i, y};

        for (int i = 0; i < 8; i++)
            if (i != x) movements[7 + (i < x ? i : i - 1)] = new int[]{x, i};

        return movements;
    }
}
