package view;

import controller.CaseState;
import model.MoveObserver;
import model.Position;

public class MovementViewObserver implements MoveObserver {
    private ChessboardView chessboardView;

    public MovementViewObserver(ChessboardView chessboardView) {
        this.chessboardView = chessboardView;
    }

    @Override
    public void beforeMove(Position oldPosition, Position newPosition) {
        chessboardView.getCase(oldPosition).empty();
    }

    @Override
    public void afterMove(Position oldPosition, Position newPosition) {
        chessboardView.getCase(newPosition).setPiece(newPosition.getPiece().getLetter().toString());
    }
}
