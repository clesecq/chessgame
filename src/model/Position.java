package model;

import model.piece.Piece;

import java.util.ArrayList;

public class Position {
    private final int x;
    private final int y;

    public ArrayList<MoveObserver> observer = new ArrayList<>();

    private Piece piece;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int[] getPosition() {
        return new int[]{x, y};
    }

    public int getRow() {
        return x;
    }

    public int getColumn() {
        return y;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }
}
