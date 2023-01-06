package model.piece;

public class KnightStrategy implements PieceStrategy {
    @Override
    public String getName() {
        return "knight";
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
