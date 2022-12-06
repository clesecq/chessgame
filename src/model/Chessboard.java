package model;

import model.piece.Piece;

import java.util.ArrayList;

public class Chessboard {

    private static Chessboard instance;
    private Position[] board = new Position[64];
    private ArrayList<Piece> capturedPiece;
    private Chessboard()
    {

    }
    public static Chessboard getInstance() {
        if(instance == null)
            instance = new Chessboard();
        return instance;
    }

}
