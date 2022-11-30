package model.piece;

import model.Position;

public class Knight implements Strategy {

    @Override
    public Character getLetter() {
        return 'N';
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
