package model.piece;

import model.Position;

public class Rook implements Strategy {

    @Override
    public Character getLetter() {
        return 'R';
    }

    @Override
    public Integer getPoints() {
        return 5;
    }

    @Override
    public Position[] getMovements() {
        return new Position[0];
    }
}
