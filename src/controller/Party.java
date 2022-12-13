package controller;

import model.*;
import view.*;

import javax.swing.*;
import java.awt.Color;

public class Party {
    private Chessboard chessboard;
    private ChessboardView view;

    private model.Color currentPlayer = model.Color.WHITE;

    private Position selectedPosition;


    public Party() {
        chessboard = new Chessboard();
        view = new ChessboardView(this);

        for (Position[] lines : chessboard.getBoard()) {
            for (Position position : lines) {
                position.observer.add(new CaptureObserver(chessboard));
              //  position.observer.add(new MoveObserver());

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

        Position position = chessboard.getBoard()[x][y];
        
        if (position.getPiece() != null && position.getPiece().getColor() == currentPlayer) {
            for (Position[] row : chessboard.getBoard())
                for (Position p : row)
                    view.resetColor(p);

            view.setColor(position, Color.GRAY);

            int row = selectedPosition.getRow();
            int column = selectedPosition.getColumn();

            for (int[] coordinates : selectedPosition.getPiece().getMovements(row, column)) {
                Position p = chessboard.getBoard()[coordinates[0]][coordinates[1]];
                
                if (p != null) {
                    view.setColor(p, Color.GREEN);
                    view.resetColor(p);
                }
            }

            selectedPosition = position;
        }
    }
}
