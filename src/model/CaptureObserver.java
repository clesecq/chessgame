package model;

public class CaptureObserver implements MoveObserver {
    private Chessboard chessboard;

    public CaptureObserver(Chessboard chessboard) {
        this.chessboard = chessboard;
    }

    @Override
    public void beforeMove(Position oldPosition, Position newPosition) {
        if (newPosition.getPiece() != null) {
            chessboard.addCapturedPiece(newPosition.getPiece());

        }
    }

    @Override
    public void afterMove(Position oldPosition, Position newPosition) {
        // nothing to do
    }
}