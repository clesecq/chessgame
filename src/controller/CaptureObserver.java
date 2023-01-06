package controller;

import model.Chessboard;
import model.MoveObserver;
import model.PlayerColor;
import model.Position;
import model.piece.Piece;
import view.CapturedView;
import view.ChessboardView;

public class CaptureObserver implements MoveObserver {
    private ChessboardView view;

    public CaptureObserver(ChessboardView view) {
        this.view = view;
    }

    /**
     * Add the captured piece to the captured pieces list.
     */
    @Override
    public void beforeMove(Position oldPosition, Position newPosition) {
        Piece p = newPosition.getPiece();
        // if new position is not empty, add the piece to the captured pieces list
        if (p != null) {
            CapturedView c = p.getPlayerColor() == PlayerColor.WHITE ? view.whiteCaptured : view.blackCaptured;
            c.addPiece(p.getName());
            c.addScore(p.getPoints());
        }
    }

    /**
     * Do nothing.
     */
    @Override
    public void afterMove(Position oldPosition, Position newPosition) {}
}