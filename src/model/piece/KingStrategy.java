package model.piece;

import model.Position;

public class KingStrategy implements PieceStrategy {
    @Override
    public Character getLetter() {
        return 'K';
    }

    @Override
    public Integer getPoints() throws Exception {
         throw new Exception("Le roi ne peut mourir");
    }

    @Override
    public int[][] getMovements(int x, int y) {
        return new int[0][]; // TODO
    }

}
