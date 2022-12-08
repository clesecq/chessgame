package model.piece;

import model.Position;

public class King implements Strategy {
    private final Position[][] board;

    public King(Position[][] board) {
        this.board = board;
    }

    @Override
    public Character getLetter() {
        return 'K';
    }

    @Override
    public Integer getPoints() throws Exception {
         throw new Exception("Le roi ne peut mourir");
    }


    @Override
    public Position[] getMovements(Position currentPosition) {
        return new Position[] { board[0][0] };
    }
}
