package model.piece;

import model.Position;

public class Queen  implements Strategy {

    @Override
    public Character getLetter() {
        return 'Q';
    }

    @Override
    public Integer getPoints() {
        return 9;
    }

    @Override
    public Position[] getMovements() {
        return new Position[0];
    }
}
