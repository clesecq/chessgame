package model.piece;

import model.Position;

public class Pawn implements Strategy {

    private Integer points = 1;
    private Character letter ;

    @Override
    public Character getLetter() {
        return 'P';
    }

    @Override
    public Integer getPoints() {
        return 1;
    }

    @Override
    public Position[] getMovements() {
        return new Position[0];
    }
}
