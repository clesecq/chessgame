package model;

import model.piece.FactoryStrategy;
import model.piece.Piece;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * The chessboard.
 */
public class Chessboard {
    /**
     * All positions on the chessboard.
     */

    private Position[][] board = new Position[8][8];

    /**
     * List of movement observers.
     * TODO: move to controller
     */
    public ArrayList<MoveObserver> moveObservers = new ArrayList<>();

    public Chessboard()
    {
        // initial disposition, upper case for white, lower case for black
        Character[][] initial = {
            { 'R', 'N', 'B', 'K', 'Q', 'B', 'N', 'R' },
            { 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P' },
            { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
            { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
            { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
            { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
            { 'p', 'p', 'p', 'p', 'p', 'p', 'p', 'p' },
            { 'r', 'n', 'b', 'k', 'q', 'b', 'n', 'r' },
        };

        FactoryStrategy f = new FactoryStrategy();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Piece piece;
                Character letter = initial[i][j];

                switch (letter){
                    case 'R':
                    case 'r':
                        piece = f.createRook('R' == letter ? PlayerColor.WHITE : PlayerColor.BLACK);
                        break;
                    case 'N':
                    case 'n':
                        piece = f.createKnight('N' == letter ? PlayerColor.WHITE : PlayerColor.BLACK);
                        break;
                    case 'B':
                    case 'b':
                        piece = f.createBishop('B' == letter ? PlayerColor.WHITE : PlayerColor.BLACK);
                        break;
                    case 'Q':
                    case 'q':
                        piece = f.createQueen('Q' == letter ? PlayerColor.WHITE : PlayerColor.BLACK);
                        break;
                    case 'K':
                    case 'k':
                        piece = f.createKing('K' == letter ? PlayerColor.WHITE : PlayerColor.BLACK);
                        break;
                    case 'P':
                    case 'p':
                        piece = f.createPawn('P' == letter ? PlayerColor.WHITE : PlayerColor.BLACK);
                        break;
                    default:
                        piece = null;
                }

                Position position = new Position(i, j);
                position.setPiece(piece);
                board[i][j] = position;
            }
        }
    }

    /** Get the board.
     * @return the board
     */
    public Position[][] getBoard() {
        return board;
    }

    /**
     * Get the list of positions that a piece can move to.
     * @return the list of positions that a piece can move to
     */
    public Position[] getMovements(Position position) {
        // if the position is empty, return an empty list
        Piece piece = position.getPiece();
        if (piece == null)
            return new Position[]{};

        // get the list of theoretical positions that the piece can move to
        // each movement require that precedent movements are possible
        // this form chains of movements
        // the chains are separated by positions with negative coordinates
        int[][] movements = piece.getMovements(position.getRow(), position.getColumn());

        int j = 0;
        Position[] positions = new Position[movements.length];
        for (int i = 0; i < movements.length; i++) {
            // begin of new chain, remove this position
            if (movements[i][0] < 0) {
                // movement of pawn
                //   -2: piece can only move if the position is empty
                //   -3: piece can only move if the position is not empty
                if (j < positions.length-1 && j > 0) {
                    Piece p = positions[j-1].getPiece();
                    if ((movements[i][1] == -2 && p != null) || (movements[i][1] == -3 && p == null))
                        positions[--j] = null;
                }
            } else {
                // get the potential position from board
                Position potentialPosition = board[movements[i][0]][movements[i][1]];

                // check if potential position is empty,
                if (potentialPosition.getPiece() == null) {
                    positions[j++] = potentialPosition;
                } else {
                    // check if the piece can be captured
                    if (potentialPosition.getPiece().getPlayerColor() != piece.getPlayerColor())
                        positions[j++] = potentialPosition;

                    // search begin of next chain
                    while (i+1 < movements.length && movements[i+1][0] >= 0)
                        i++;
                }
            }
        }

        // remove null values
        return Arrays.copyOf(positions, j);
    }

    /**
     * Move a piece from an old position to a new position.
     * TODO: move to controller
     * @param from the old position
     * @param to the new position
     */
    public void movePiece(Position from, Position to)
    {
        // call before part of observers
        for (MoveObserver moveObserver : moveObservers)
            moveObserver.beforeMove(from, to);

        // move the piece
        to.setPiece(from.getPiece());
        from.setPiece(null);

        // call after part of observers
        for (MoveObserver moveObserver : moveObservers)
            moveObserver.afterMove(from, to);
    }
}
