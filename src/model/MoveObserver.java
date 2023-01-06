package model;

public interface MoveObserver {
    /**
     * Called before the move.
     * @param oldPosition the old position of the piece
     * @param newPosition the new position of the piece
     */
    void beforeMove(Position oldPosition, Position newPosition);

    /**
     * Called after the move.
     * @param oldPosition the old position of the piece
     * @param newPosition the new position of the piece
     */
    void afterMove(Position oldPosition, Position newPosition);
}