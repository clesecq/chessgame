package model.piece;

import model.Color;
import model.Position;

public class KnightStrategy implements PieceStrategy {
    @Override
    public Character getLetter() {
        return 'N';
    }

    @Override
    public Integer getPoints() {
        return 3;
    }

    @Override
    public int[][] getMovements(int x, int y) {
        return new int[][] {
            {x - 2, y - 1}, {-1, -1},
            {x - 2, y + 1}, {-1, -1},
            {x - 1, y - 2}, {-1, -1},
            {x - 1, y + 2}, {-1, -1},
            {x + 1, y - 2}, {-1, -1},
            {x + 1, y + 2}, {-1, -1},
            {x + 2, y - 1}, {-1, -1},
            {x + 2, y + 1}, {-1, -1},
        };
    }
}
