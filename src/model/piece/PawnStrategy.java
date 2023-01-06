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
        int[][] movements = new int[8][2];
        int direction = color == Color.WHITE ? 1 : -1;

        movements[0] = new int[]{x + direction, y};
        movements[1] = new int[]{-1, -1};
        movements[2] = new int[]{x + direction, y - 1};
        movements[3] = new int[]{-1, -1};
        movements[4] = new int[]{x + direction, y + 1};
        movements[5] = new int[]{-1, -1};

        movements[6] = x == (color == Color.WHITE ? 1 : 6) ?
                new int[]{x + direction*2, y} : new int[]{-1, -1};
        movements[7] = new int[]{-1, -1};

        return movements;
    }

}
