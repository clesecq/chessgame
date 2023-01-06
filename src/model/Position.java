package model;

import model.piece.Piece;

import java.util.ArrayList;

/**
 * A position on chessboard.
 */
public class Position {
    /**
     * The row and column of the position
     */
    private final int x, y;
    /**
     * The piece on the position (null if empty)
     */
    private Piece piece;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Get the row of the position.
     * @return the row of the position
     */
    public int getRow() {
        return x;
    }

    /**
     * Get the column of the position.
     * @return the column of the position
     */
    public int getColumn() {
        return y;
    }

    /**
     * Get the piece on the position.
     * @return Piece on the position.
     */
    public Piece getPiece() {
        return piece;
    }

    /**
     * Set the piece on the position.
     * @param piece the piece to set
     */
    public void setPiece(Piece piece) {
        this.piece = piece;
    }
}
