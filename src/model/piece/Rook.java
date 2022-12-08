package model.piece;

import model.Color;
import model.Position;

public class Rook implements Strategy {
    Position[][] board;

    public Rook(Position[][] board) {
        this.board = board;
    }

    @Override
    public Character getLetter() {
        return 'R';
    }

    @Override
    public Integer getPoints() {
        return 5;
    }

    private boolean isPositionValid(int x, int y) {
        return x >= 0 && x < 8 && y >= 0 && y < 8;
    }

    private boolean isBlockedPosition(int row, int column) {
        return board[row][column].getPiece() != null;
    }

    private boolean isEnemyPosition(int row, int column, Color color) {
        return board[row][column].getPiece().getColor() != color;
    }

    @Override
    public Position[] getMovements(Position currentPosition) {
        Piece piece = currentPosition.getPiece();
        Color color = piece.getColor();
        Position[] movements = new Position[64];
        boolean isBlocked = false;

        int row = currentPosition.getRow();
        int column = currentPosition.getColumn();

        for (int i = row + 1; i < 8 && !isBlocked; i++) {
            if (isBlockedPosition(i, column)) {
                isBlocked = true;
                if (board[i][column].getPiece().getColor() != color)
                    movements[i + column * 8] = board[i][column];
            } else movements[i + column * 8] = board[i][column];
        }

        isBlocked = false;
        for (int i = row - 1; i >= 0 && !isBlocked; i--) {
            if (isBlockedPosition(i, column)) {
                isBlocked = true;
                if (board[i][column].getPiece().getColor() != color)
                    movements[i + column * 8] = board[i][column];
            } else movements[i + column * 8] = board[i][column];
        }

        isBlocked = false;
        for (int i = column + 1; i < 8 && !isBlocked; i++) {
            if (isBlockedPosition(row, i)) {
                isBlocked = true;
                if (board[row][i].getPiece().getColor() != color)
                    movements[row + i * 8] = board[row][i];
            } else movements[row + i * 8] = board[row][i];
        }

        isBlocked = false;
        for (int i = column - 1; i >= 0 && !isBlocked; i--) {
            if (isBlockedPosition(row, i)) {
                isBlocked = true;
                if (board[row][i].getPiece().getColor() != color)
                    movements[row + i * 8] = board[row][i];
            } else movements[row + i * 8] = board[row][i];
        }

        return movements;
    }
}
