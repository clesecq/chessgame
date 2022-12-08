package model.piece;

import model.Color;
import model.Position;

import static java.lang.Integer.min;
import static java.lang.Math.max;

public class Bishop implements Strategy {
    private final Position[][] board;

    public Bishop(Position[][] board) {
        this.board = board;
    }

    @Override
    public Character getLetter() {
        return 'B';
    }

    @Override
    public Integer getPoints() {
        return 3;
    }

    @Override
    public Position[] getMovements(Position currentPosition) {
        Piece piece = currentPosition.getPiece();
        Color color = piece.getColor();
        Position[] movements = new Position[64];
        boolean isBlocked = false;
        for (int i = min(currentPosition.getRow(), currentPosition.getColumn()) + 1; i < 8 && !isBlocked; i++) {
            int row = currentPosition.getRow() + i;
            int column = currentPosition.getColumn() + i;

            if (row >= 0 && row < 8 && column >= 0 && column < 8) {
                System.out.println("row: " + row + " column: " + column);
                Position position = board[row][column];

                if (position.getPiece() != null) {
                    isBlocked = true;
                    if (position.getPiece().getColor() != color)
                        movements[row + column * 8] = position;
                } else movements[row + column * 8] = position;
            }
        }

        for (int i = max(currentPosition.getRow(), currentPosition.getColumn()) + 1; i >= 8 && !isBlocked; i--) {
            int row = currentPosition.getRow() + i;
            int column = currentPosition.getColumn() + i;

            if (row >= 0 && row < 8 && column >= 0 && column < 8) {
                System.out.println("row: " + row + " column: " + column);
                Position position = board[row][column];

                if (position.getPiece() != null) {
                    isBlocked = true;
                    if (position.getPiece().getColor() != color)
                        movements[row + column * 8] = position;
                } else movements[row + column * 8] = position;
            }
        }

        return movements;
    }
}
