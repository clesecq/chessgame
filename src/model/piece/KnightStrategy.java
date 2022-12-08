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
        return new int[0][]; // TODO
    }
}
