package controller;

import model.*;
import view.*;

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

        for (Position[] lines : chessboard.getBoard())
            for (Position position : lines)
                if (position.getPiece() != null)
                    view.getCase(position).setPiece(position.getPiece().getLetter().toString());
    }

    public model.Color getCurrentPlayer() {
        return currentPlayer;
    }

    public void selectCase(int x, int y) {
        if (x < 0 || x > 7 || y < 0 || y > 7)
            throw new IllegalArgumentException("Invalid position");

        view.resetAllBackground();

        if (previousPosition == null)
            selectPosition(chessboard.getBoard()[x][y]);
        else
            previousPosition = null;
    }

    public void moveCase(int x, int y) {
        if (x < 0 || x > 7 || y < 0 || y > 7)
            throw new IllegalArgumentException("Invalid position");

        view.resetAllBackground();

        boolean moved = movePiece(previousPosition, chessboard.getBoard()[x][y]);
        if (moved) changePlayer();
    }

    private boolean selectPosition(Position position) {
        if (position.getPiece() == null || position.getPiece().getColor() != currentPlayer)
            return false;

        previousPosition = position;
        Position[] movements = chessboard.getMovements(position);

        for (Position movement : movements)
            view.getCase(movement).setState(CaseState.POSSIBLE);

        return movements.length > 0;
    }

    private boolean movePiece(Position oldPosition, Position newPosition) {
        previousPosition = null;
        chessboard.movePiece(oldPosition, newPosition);
        return true;
    }

    private void changePlayer() {
        currentPlayer = currentPlayer == model.Color.WHITE ? model.Color.BLACK : model.Color.WHITE;
    }
}
