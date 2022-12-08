package model.piece;

import model.Color;
import model.Position;

public class Knight implements Strategy {
    private final Position[][] board;

    public Knight(Position[][] board) {
        this.board = board;
    }

    @Override
    public Character getLetter() {
        return 'N';
    }

    @Override
    public Integer getPoints() {
        return 3;
    }

    @Override
    public Position[] getMovements(Position currentPosition) {
         Position[] movements = new Position[64];

            int row = currentPosition.getRow();
            int column = currentPosition.getColumn();

            int[][] positions = {
                    {row + 2, column + 1},
                    {row + 2, column - 1},
                    {row - 2, column + 1},
                    {row - 2, column - 1},
                    {row + 1, column + 2},
                    {row + 1, column - 2},
                    {row - 1, column + 2},
                    {row - 1, column - 2}
            };

            Color color = currentPosition.getPiece().getColor();
            for (int[] position : positions) {
                int x = position[0];
                int y = position[1];

                if (x >= 0 && x < 8 && y >= 0 && y < 8 &&
                        (board[x][y].getPiece() == null || board[x][y].getPiece().getColor() !=  color)) {
                    movements[x + y * 8] = board[x][y];
                }
            }

            return movements;
    }
}
