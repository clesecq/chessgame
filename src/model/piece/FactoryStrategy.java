package model.piece;

import model.Color;

public class FactoryStrategy {

    public Piece createKing(Color color) {
        Piece piece = new Piece(color);
        piece.setStrategy(new KingStrategy());
        return piece;
    }

    public Piece createQueen(Color color) {
        Piece piece = new Piece(color);
        piece.setStrategy(new QueenStrategy());
        return piece;
    }

    public Piece createRook(Color color) {
        Piece piece = new Piece(color);
        piece.setStrategy(new RookStrategy());
        return piece;
    }

    public Piece createKnight(Color color) {
        Piece piece = new Piece(color);
        piece.setStrategy(new KnightStrategy());
        return piece;
    }

    public Piece createBishop(Color color) {
        Piece piece = new Piece(color);
        piece.setStrategy(new BishopPieceStrategy());
        return piece;
    }

    public Piece createPawn(Color color) {
        Piece piece = new Piece(color);
        piece.setStrategy(new PawnStrategy(color));
        return piece;
    }
}
