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

        chessboard.moveObservers.add(new CaptureObserver(chessboard));
        chessboard.moveObservers.add(new MovementViewObserver(view));

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

        if (previousPosition == null) {
            selectPosition(chessboard.getBoard()[x][y]);
        }
        else {
            movePiece(previousPosition, chessboard.getBoard()[x][y]);
        }
    }

    private void selectPosition(Position position) {
        if (position.getPiece() != null && position.getPiece().getColor() == currentPlayer) {
            previousPosition = position;
            for (Position newPosition : chessboard.getMovements(position))
                view.setColor(newPosition, Color.GREEN);
        }
    }

    private void movePiece(Position oldPosition, Position newPosition) {
        chessboard.movePiece(oldPosition, newPosition);
        previousPosition = null;
    }
}
