package model.piece;

import model.Position;

public class King implements Strategy {

    @Override
    public Character getLetter() {
        return 'K';
    }

    @Override
    public Integer getPoints() throws Exception {
         throw new Exception("Le roi ne peut mourir");
    }

    @Override
    public Position[] getMovements() {
        return new Position[0];
    }
}
