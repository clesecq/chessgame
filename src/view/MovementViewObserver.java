package view;

import model.MoveObserver;
import model.Position;

public class MovementViewObserver implements MoveObserver {
    private ChessboardView chessboardView;

    public MovementViewObserver(ChessboardView chessboardView) {
        this.chessboardView = chessboardView;
    }

    @Override
    public void beforeMove(Position oldPosition, Position newPosition) {

    }

    @Override
    public void afterMove(Position oldPosition, Position newPosition) {
        chessboardView.drawPosition(oldPosition);
        chessboardView.drawPosition(newPosition);
    }
}
