package view;

import model.PlayerColor;
import model.MoveObserver;
import model.Position;
import model.piece.FactoryStrategy;
import model.piece.Piece;

import java.util.Scanner;

public class MovementViewObserver implements MoveObserver {
    private ChessboardView chessboardView;

    public MovementViewObserver(ChessboardView chessboardView) {
        this.chessboardView = chessboardView;
    }

    /**
     * Empty the cell of the old position.
     */
    @Override
    public void beforeMove(Position oldPosition, Position newPosition) {
        chessboardView.getCell(oldPosition).empty();
    }

    /**
     * Set the piece in the new position.
     */
    @Override
    public void afterMove(Position oldPosition, Position newPosition) {
        chessboardView.getCell(newPosition).setPiece(newPosition.getPiece().getName());
    }
}
