package model.piece;

import model.*;

public interface PieceStrategy {

    /**
     * Get the letter of the piece.
     * @return the letter of the piece
     */
    String getName();

    /**
     * Get the points of the piece.
     * @return the points of the piece
     */
    Integer getPoints();

    /**
     * Get the movements of the piece.
     * @param x the x position of the piece
     * @param y the y position of the piece
     * @return the movements of the piece
     */
    int[][] getMovements(int x, int y);
}
