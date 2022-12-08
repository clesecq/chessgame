package model;

public class MovementObserver implements MoveObserver {
    public void onMove(Position oldPosition, Position newPosition) {
        newPosition.setPiece(oldPosition.getPiece());
        oldPosition.setPiece(null);
    }
}