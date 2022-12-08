package model;

public interface MoveObserver {
    void onMove(Position oldPosition, Position newPosition);
}