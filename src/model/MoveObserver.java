package model;

public interface MoveObserver {
    void beforeMove(Position oldPosition, Position newPosition);
    void afterMove(Position oldPosition, Position newPosition);
}