package model.piece;

import model.Color;
import model.Position;

public class Factory {
    private Position[][] board;
    public Factory(Position[][] board){
        this.board = board;
    }

    public Piece createKing(Color color) {
        Piece piece = new Piece(color);
        piece.setStrategy(new King(board));
        return piece;
    }

    public Piece createQueen(Color color) {
        Piece piece = new Piece(color);
        piece.setStrategy(new Queen(board));
        return piece;
    }

    public Piece createRook(Color color) {
        Piece piece = new Piece(color);
        piece.setStrategy(new Rook(board));
        return piece;
    }

    public Piece createKnight(Color color) {
        Piece piece = new Piece(color);
        piece.setStrategy(new Knight(board));
        return piece;
    }

    public Piece createBishop(Color color) {
        Piece piece = new Piece(color);
        piece.setStrategy(new Bishop(board));
        return piece;
    }

    public Piece createPawn(Color color) {
        Piece piece = new Piece(color);
        piece.setStrategy(new Pawn(board, color));
        return piece;
    }
}
