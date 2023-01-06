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
     * The captured pieces.
     */
    private ArrayList<Piece> capturedPiece = new ArrayList<>();

    /**
     * List of movement observers.
     * TODO: move to controller
     */
    public ArrayList<MoveObserver> moveObservers = new ArrayList<>();

    public Chessboard()
    {
        // initial disposition, upper case for white, lower case for black
        Character[][] initial = {
            { 'R', 'N', 'B', 'Q', 'K', 'B', 'N', 'R' },
            { 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P' },
            { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
            { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
            { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
            { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
            { 'p', 'p', 'p', 'p', 'p', 'p', 'p', 'p' },
            { 'r', 'n', 'b', 'q', 'k', 'b', 'n', 'r' },
        };

        FactoryStrategy f = new FactoryStrategy();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Piece piece;
                Character letter = initial[i][j];

                switch (letter){
                    case 'R', 'r' -> piece = f.createRook('R' == letter ? PlayerColor.WHITE : PlayerColor.BLACK);
                    case 'N', 'n' -> piece = f.createKnight('N' == letter ? PlayerColor.WHITE : PlayerColor.BLACK);
                    case 'B', 'b' -> piece = f.createBishop('B' == letter ? PlayerColor.WHITE : PlayerColor.BLACK);
                    case 'Q', 'q' -> piece = f.createQueen('Q' == letter ? PlayerColor.WHITE : PlayerColor.BLACK);
                    case 'K', 'k' -> piece = f.createKing('K' == letter ? PlayerColor.WHITE : PlayerColor.BLACK);
                    case 'P', 'p' -> piece = f.createPawn('P' == letter ? PlayerColor.WHITE : PlayerColor.BLACK);
                    default -> piece = null;
                }

                Position position = new Position(i, j);
                position.setPiece(piece);
                board[i][j] = position;
            }
        }
    }

    /**
     * Add a piece to the captured pieces list.
     * @param piece the piece to add
     */
    public void addCapturedPiece(Piece piece)
    {
        capturedPiece.add(piece);
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
            // end of possible movements
            if (movements[i] == null)
                break;

            // begin of new chain, remove this position
            if (movements[i][0] == -1 && movements[i][1] == -1) {
                continue;
            }

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
                while (i+1 < movements.length && !Arrays.equals(movements[i+1], new int[]{-1, -1}))
                    i++;
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
