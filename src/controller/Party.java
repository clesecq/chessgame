package controller;

import model.*;
import view.*;

import javax.swing.*;
import java.awt.Color;

public class Party {
    private Chessboard chessboard;
    private ChessboardView view;

    private model.Color currentPlayer = model.Color.WHITE;

    private Position previousPosition;


    public Party() {
        chessboard = new Chessboard();
        view = new ChessboardView(this);

        for (Position[] lines : chessboard.getBoard()) {
            for (Position position : lines) {
                if (position.getPiece() != null) {
                    view.drawPosition(position);
                }
            }
        }
    }

    public model.Color getCurrentPlayer() {
        return currentPlayer;
    }

    public void clickOnCase(int x, int y) {
        if (x < 0 || x > 7 || y < 0 || y > 7)
            throw new IllegalArgumentException("Invalid position");

        view.resetAllBackground();
        Position position = chessboard.getBoard()[x][y];

        if (previousPosition == null) {
            if (position.getPiece() != null && position.getPiece().getColor() == currentPlayer) {
                view.setColor(position, Color.GRAY);

                int row = position.getRow();
                int column = position.getColumn();

                for (int[] coordinates : position.getPiece().getMovements(row, column)) {
                    if (coordinates[0] != -1 && coordinates[1] != -1) {
                        Position newPosition = chessboard.getBoard()[coordinates[0]][coordinates[1]];
                        view.setColor(newPosition, Color.GREEN);
                    }
                }
            }
        }
    }
}
