package model.piece;

import model.*;

/**
 * A piece on chessboard.
 */
public class Piece {
    /**
     * The player color of the piece
     */
    private PlayerColor playerColor;
    /**
     * The strategy of the piece (type of the piece)
     */
    private PieceStrategy pieceStrategy;

    public Piece(PlayerColor playerColor){
        this.playerColor = playerColor;
    }

    /**
     * Get the player color of the piece.
     * @return the player color of the piece
     */
    public PlayerColor getPlayerColor()
    {
        return playerColor;
    }

    /**
     * Get the points of the piece.
     * @return the points of the piece
     */
    public Integer getPoints() {
        return pieceStrategy.getPoints();
    }

    /**
     * Get the letter of the piece.
     * @return the letter of the piece
     */
    public String getName()
    {
        String playerColor = this.playerColor == PlayerColor.WHITE ? "white" : "black";
        return playerColor + '-' + pieceStrategy.getName();
    }

    /**
     * Get the possible movement of the piece.
     * @return the strategy of the piece
     */
    public int[][] getMovements(int x, int y)
    {
        int[][] movements = pieceStrategy.getMovements(x, y);

        for (int i = 0; i < movements.length; i++) {
            // is necessary to prevent the second value from being reset to -1
            if (movements[i][0] < -7) movements[i][0] += 7;
            else if (movements[i][0] < 0 || movements[i][0] > 7 || movements[i][1] < 0 || movements[i][1] > 7)
                movements[i] = new int[]{-1, -1};
            else if (movements[i][0] == x && movements[i][1] == y)
                movements[i] = new int[]{-1, -1};
        }

        return movements;
    }

    /**
     * Set the strategy of the piece.
     * @param pieceStrategy the strategy of the piece
     */
    public void setStrategy(PieceStrategy pieceStrategy)
    {
        this.pieceStrategy = pieceStrategy;
    }
}
