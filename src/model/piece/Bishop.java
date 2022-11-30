package model.piece;

import model.Position;

public class Bishop implements Strategy {

    @Override
    public Character getLetter() {
        return 'B';
    }

    @Override
    public Integer getPoints() {
        return 3;
    }

    @Override
    public Position[] getMovements() {
        return new Position[0];
    }
}
