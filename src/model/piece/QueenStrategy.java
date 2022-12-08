package model.piece;

public class QueenStrategy implements PieceStrategy {
    @Override
    public Character getLetter() {
        return 'Q';
    }

    @Override
    public Integer getPoints() {
        return 9;
    }

    @Override
    public int[][] getMovements(int x, int y) {
        return new int[0][]; // TODO
    }
}
