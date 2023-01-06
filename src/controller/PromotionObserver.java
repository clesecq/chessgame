package controller;

import model.MoveObserver;
import model.Position;
import model.piece.*;
import view.ChessboardView;
import view.PromotionView;

public class PromotionObserver implements MoveObserver {
    private final ChessboardView view;
    private Position position;

    public PromotionObserver(ChessboardView view) {
        this.view = view;
    }


    /**
     * Do nothing.
     * @param oldPosition the old position of the piece
     * @param newPosition the new position of the piece
     */
    @Override
    public void beforeMove(Position oldPosition, Position newPosition) {

    }

    /**
     *
     * @param oldPosition the old position of the piece
     * @param newPosition the new position of the piece
     */
    @Override
    public void afterMove(Position oldPosition, Position newPosition) {
        Piece p = newPosition.getPiece();
        position = newPosition;
        if (p.getName().contains("pawn") && (newPosition.getRow() == 7 || newPosition.getRow() == 0)) {
            new PromotionView(this);

            view.getCell(newPosition).setPiece(p.getName());
        }
    }

    public void promote(String strategyName) {
        PieceStrategy strategy;
        switch (strategyName) {
            case "queen":
                strategy = new QueenStrategy();
                break;
            case "rook":
                strategy = new RookStrategy();
                break;
            case "bishop":
                strategy = new BishopStrategy();
                break;
            case "knight":
            default:
                strategy = new KnightStrategy();
                break;
        }
        position.getPiece().setStrategy(strategy);
        view.getCell(position).setPiece(position.getPiece().getName());
    }
}
