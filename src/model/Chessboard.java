package model;

import model.piece.FactoryStrategy;
import model.piece.Piece;

import java.util.ArrayList;

public class Chessboard {

    private Position[][] board = new Position[8][8];
    private ArrayList<Piece> capturedPiece = new ArrayList<>();

    public ArrayList<MoveObserver> moveObservers = new ArrayList<>();

    public Chessboard()
    {
        Character[][] initial = {
            { 'R', 'N', 'B', 'Q', 'K', 'B', 'N', 'R' },
            // { 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P' },
            { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
            { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
            { ' ', ' ', ' ', ' ', 'B', ' ', ' ', ' ' },
            { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
            { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
            { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
            // { 'p', 'p', 'p', 'p', 'p', 'p', 'p', 'p' },
            { 'r', 'n', 'b', 'q', 'k', 'b', 'n', 'r' },
        };

        FactoryStrategy f = new FactoryStrategy();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Piece piece;
                Character letter = initial[i][j];

                switch (letter){
                    case 'R', 'r' -> piece = f.createRook('R' == letter ? Color.WHITE : Color.BLACK);
                    case 'N', 'n' -> piece = f.createKnight('N' == letter ? Color.WHITE : Color.BLACK);
                    case 'B', 'b' -> piece = f.createBishop('B' == letter ? Color.WHITE : Color.BLACK);
                    case 'Q', 'q' -> piece = f.createQueen('Q' == letter ? Color.WHITE : Color.BLACK);
                    case 'K', 'k' -> piece = f.createKing('K' == letter ? Color.WHITE : Color.BLACK);
                    case 'P', 'p' -> piece = f.createPawn('P' == letter ? Color.WHITE : Color.BLACK);
                    default -> piece = null;
                }

                Position position = new Position(i, j);
                position.setPiece(piece);
                board[i][j] = position;
            }
        }
    }

    public void addCapturedPiece(model.piece.Piece piece)
    {
        capturedPiece.add(piece);
    }

    public Position[][] getBoard() {
        return board;
    }

    public void movePiece(Position from, Position to)
    {
        for (MoveObserver moveObserver : moveObservers)
            moveObserver.beforeMove(from, to);

        to.setPiece(from.getPiece());
        from.setPiece(null);

        for (MoveObserver moveObserver : moveObservers)
            moveObserver.afterMove(from, to);
    }
}
