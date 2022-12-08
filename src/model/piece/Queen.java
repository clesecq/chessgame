package model.piece;

import model.Position;

public class Queen implements Strategy {
    private final Position[][] board;

    public Queen(Position[][] board){
        this.board = board;
    }


    @Override
    public Character getLetter() {
        return 'Q';
    }

    @Override
    public Integer getPoints() {
        return 9;
    }

    @Override
    public Position[] getMovements(Position currentPosition) {
        return new Position[] { board[7][7] };
    }
}
