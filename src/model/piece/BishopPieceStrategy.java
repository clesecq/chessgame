package model.piece;

import static java.lang.Math.max;

public class BishopPieceStrategy implements PieceStrategy {

    @Override
    public Character getLetter() {
        return 'B';
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
