package model.piece;

import model.PlayerColor;

public class PawnStrategy implements PieceStrategy {
    private final PlayerColor playerColor;

    public PawnStrategy(PlayerColor playerColor) {
        this.playerColor = playerColor;
    }

    @Override
    public String getName() {
        return "pawn";
    }

    @Override
    public Integer getPoints() {
        return 1;
    }

    @Override
    public int[][] getMovements(int x, int y) {
        int direction = playerColor == PlayerColor.WHITE ? 1 : -1;

        return (x == (playerColor == PlayerColor.WHITE ? 1 : 6)) ?
            new int[][]{
                {x + direction, y - 1}, {-8, -3},
                {x + direction, y + 1}, {-8, -3},
                {x + direction, y}, {x + direction * 2, y}, {-8, -2},
            } : new int[][]{
                {x + direction, y - 1}, {-8, -3},
                {x + direction, y + 1}, {-8, -3},
                {x + direction, y}, {-8, -2},
            };
    }
}
