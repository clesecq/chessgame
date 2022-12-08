package model.piece;

import model.Color;
import model.Position;

public class PawnStrategy implements PieceStrategy {
    private final Color color;

    public PawnStrategy(Color color) {
        this.color = color;
    }

    @Override
    public Character getLetter() {
        return 'P';
    }

    @Override
    public Integer getPoints() {
        return 1;
    }

    @Override
    public int[][] getMovements(int x, int y) {
        int[][] movements = new int[4][2];

        if (color == Color.WHITE) {
            movements[0] = new int[]{x - 1, y};
            movements[1] = new int[]{x - 1, y - 1};
            movements[2] = new int[]{x - 1, y + 1};
            if (x == 6) movements[3] = new int[]{x - 2, y};
        } else {
            movements[0] = new int[]{x + 1, y};
            movements[1] = new int[]{x + 1, y - 1};
            movements[2] = new int[]{x + 1, y + 1};
            if (x == 1) movements[3] = new int[]{x + 2, y};
        }

        return movements;
    }

}
