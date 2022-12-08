package model.piece;

import model.Color;
import model.Position;

public class Pawn implements Strategy {

    private final Position[][] board;
    private final Color color;


    public Pawn(Position[][] board, Color color) {
        this.board = board;
        this.color = color;
    }

    @Override
    public Character getLetter() {
        return 'P';
    }

    @Override
    public Integer getPoints() {
        return 1;
    }

    @Override
    public Position[] getMovements(Position currentPosition) {
        return new Position[] { board[0][0] };
    }
}
