package model;

public class CaptureObserver implements MoveObserver {
    private Chessboard chessboard;

    public CaptureObserver(Chessboard chessboard) {
        this.chessboard = chessboard;
    }

    /**
     * Add the captured piece to the captured pieces list.
     */
    @Override
    public void beforeMove(Position oldPosition, Position newPosition) {
        // if new position is not empty, add the piece to the captured pieces list
        if (newPosition.getPiece() != null) {
            chessboard.addCapturedPiece(newPosition.getPiece());
        }
    }

    /**
     * Do nothing.
     */
    @Override
    public void afterMove(Position oldPosition, Position newPosition) {}
}