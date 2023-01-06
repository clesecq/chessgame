package model.piece;

import model.PlayerColor;

public class FactoryStrategy {

    public Piece createKing(PlayerColor playerColor) {
        Piece piece = new Piece(playerColor);
        piece.setStrategy(new KingStrategy());
        return piece;
    }

    public Piece createQueen(PlayerColor playerColor) {
        Piece piece = new Piece(playerColor);
        piece.setStrategy(new QueenStrategy());
        return piece;
    }

    public Piece createRook(PlayerColor playerColor) {
        Piece piece = new Piece(playerColor);
        piece.setStrategy(new RookStrategy());
        return piece;
    }

    public Piece createKnight(PlayerColor playerColor) {
        Piece piece = new Piece(playerColor);
        piece.setStrategy(new KnightStrategy());
        return piece;
    }

    public Piece createBishop(PlayerColor playerColor) {
        Piece piece = new Piece(playerColor);
        piece.setStrategy(new BishopStrategy());
        return piece;
    }

    public Piece createPawn(PlayerColor playerColor) {
        Piece piece = new Piece(playerColor);
        piece.setStrategy(new PawnStrategy(playerColor));
        return piece;
    }
}
